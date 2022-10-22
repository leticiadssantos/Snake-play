package control;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Menu;

public class ControleTelaMenu implements ActionListener{
	private Menu tela;
	
	public ControleTelaMenu(Menu tela) {
		this.tela= tela;
		
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == tela.getNovoJogo()) {
			
		} else if (e.getSource()== tela.getInstrucoes()){
			
		} 
		
		
	}

}
