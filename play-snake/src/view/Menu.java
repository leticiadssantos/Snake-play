package view;

import java.awt.FlowLayout;
import javax.sql.rowset.RowSetMetaDataImpl;
import javax.swing.JButton;

public class Menu extends View{
		 private JButton novoJogo;
		 private JButton instrucoes;
		 private JButton sair;
		 
		 
		 
		 public Menu() {
			super();
			
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLayout(new FlowLayout());
			
			novoJogo = new JButton("novoJogo");
			instrucoes = new JButton ("instrucoes");
			sair = new JButton ("sait");
			
			add(novoJogo);
			add(instrucoes);
			add(sair);
			
			setVisible(true);
			
		}

		public JButton getNovoJogo() {
			return novoJogo;
		}

		public JButton getInstrucoes() {
			return instrucoes;
		}

		public JButton getSair() {
			return sair;
		}

	}


