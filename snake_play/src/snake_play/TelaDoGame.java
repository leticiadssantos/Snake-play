package snake_play;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;

import javax.swing.JPanel;

public class TelaDoGame extends  JPanel implements ActionListener {
	
	private static final int LARGURA = 1300;
	private static final int ALTURA = 750;
	private static final int TAMANHO_BLOCO = 50;
	private static final int UNIDADES = LARGURA * ALTURA / (TAMANHO_BLOCO * TAMANHO_BLOCO);
	private static final int INTERVALO = 150;
	private static final String NOME_FONTE = "Ink Free";
	private final int[] eixoX = new int[UNIDADES];
	private final int[] eixoY = new int[UNIDADES];
	private int corpoCobra = 6;
	private int blocosComidos;
	private int blocoX;
	private int blocoY;
	private char direcao = 'D'; // D(direita) E(esquerda) B(baixo) C(cima)
	private boolean estaRodando = false; //vai controlar se o jogo está sendo executado
	Timer timer; //redenrização do jogo
	Random random; //gerador aleatório de numero para posicionar o bloco
	
	TelaDoGame() {
		random = new Random();
		setPreferredSize(new Dimension(LARGURA, ALTURA));
		setBackground(Color.black);
		setFocusable(true);
		addKeyListener(new LeitorDeTeclasAdapter());
		inicioGame();
	}
	
	public void inicioGame() {
		criarBloco();
		estaRodando = true;
		timer = new Timer(INTERVALO, this);
		timer.start();
	}
	
	public void desenharTela(Graphics g) {
		
		if (estaRodando) {
			g.setColor(Color.red);//MAÇA A SER COMIDA
			g.fillOval(blocoX, blocoY, TAMANHO_BLOCO, TAMANHO_BLOCO);
			
			for (int i = 0; i < corpoCobra; i++) {
				if (i == 0) { //CABEÇA DA COBRA
					g.setColor(Color.YELLOW);
					g.fillRect(eixoX[0], eixoY[0], TAMANHO_BLOCO, TAMANHO_BLOCO);
				} else {// CORPO DA COBRA
					g.setColor(new Color (234, 228, 46));
					g.fillRect(eixoX[i], eixoY[i], TAMANHO_BLOCO, TAMANHO_BLOCO);
				}
			}
			
			g.setColor(Color.red);
			g.setFont(new Font(NOME_FONTE, Font.BOLD, 40));
			FontMetrics metrics = getFontMetrics(g.getFont());
			g.drawString("Pontos: " + blocosComidos, (LARGURA - metrics.stringWidth("Pontuação: " + blocosComidos)) / 2, g.getFont().getSize());
		} else {
			fimDeJogo(g);
		}
	
	private void criarBloco( ) {
		blocoX = random.nextInt(LARGURA / TAMANHO_BLOCO) * TAMANHO_BLOCO;
		blocoY = random.nextInt(ALTURA / TAMANHO_BLOCO) * TAMANHO_BLOCO;
	}
	
	private void andar() {
		for (int i = corpoCobra; i > 0; i--) {
			eixoX[i] = eixoX[i - 1];
			eixoY[i] = eixoY[i - 1];
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
}
