package pt.labfinal;

import javax.swing.*;
import java.awt.*;


public class GUIMar extends JFrame{
	
	private static final long serialVersionUID = 3L;	
	
	public GUIMar(String linkimagem) {
		//criando frame
		setTitle("007: Aposentadoria");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000,1000);
		setVisible(true);
		setLayout(new BorderLayout());
		
		//criando painel ao sul
		JPanel painel_sul = new JPanel();
		//painel_sul.setSize(200,200);
		painel_sul.setLayout(new BorderLayout());
		
		//criando painel dentro do sul, mas à esquerda
		JPanel painel_sul_esq = new JPanel();
		painel_sul_esq.setLayout(new BorderLayout());
		painel_sul.add(painel_sul_esq);
		
		//criando botoes do painel dentro do sul, esquerda
		JButton painel_s_e_c = new JButton("Anda p/ cima");
		JButton painel_s_e_e = new JButton("Anda p/ esquerda");
		JButton painel_s_e_d = new JButton("Anda p/ direita");
		JButton painel_s_e_b = new JButton("Anda p/ baixo");
		JButton painel_s_e_centro = new JButton("Pesca");
		
		painel_sul_esq.add(painel_s_e_c, BorderLayout.NORTH);
		painel_sul_esq.add(painel_s_e_e, BorderLayout.WEST);
		painel_sul_esq.add(painel_s_e_d, BorderLayout.EAST);
		painel_sul_esq.add(painel_s_e_b, BorderLayout.SOUTH);
		painel_sul_esq.add(painel_s_e_centro, BorderLayout.CENTER);
		
		//adicionando painel sul esq ao painel sul
		painel_sul.add(painel_sul_esq, BorderLayout.WEST);
		
		//criando painel sul, a direita
		JPanel painel_sul_dir = new JPanel();
		painel_sul_dir.setLayout(new BoxLayout(painel_sul_dir, BoxLayout.Y_AXIS));
		painel_sul_dir.setBackground(Color.cyan);
		painel_sul.add(painel_sul_dir,BorderLayout.EAST);
		
		//colocando label no painel sul,direita
		JLabel label_s_d1 = new JLabel("DADOS DO BONDZUDO:");
		JLabel label_s_d2 = new JLabel("HP = 87/100");
		JLabel label_s_d3 = new JLabel("Arma atual = pistoleta");
		JLabel label_s_d4 = new JLabel("Vara atual = vara velha");
		JLabel label_s_d5 = new JLabel("Dinheiro = $400");
		JLabel label_s_d6 = new JLabel("Ultimo peixe pescado = lambari");
		
		painel_sul_dir.add(label_s_d1);
		painel_sul_dir.add(label_s_d2);
		painel_sul_dir.add(label_s_d3);
		painel_sul_dir.add(label_s_d4);
		painel_sul_dir.add(label_s_d5);
		painel_sul_dir.add(label_s_d6);
		
		//adicionando painel sul ao frame
		add(painel_sul, BorderLayout.SOUTH);
		
		//criando o painel norte do frame
		JPanel painel_nor = new JPanel();
		painel_nor.setLayout(new GridLayout(10,10));
		painel_nor.setSize(800,800);
		
		for(int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				JPanel painel = new JPanel();
				painel.setBounds(0,0,50,50);
				painel.setBackground(Color.getHSBColor(0.66f, 1.0f, 0.58f));
				Imagem imagex = new Imagem(linkimagem);
				painel.add(imagex);
				painel_nor.add(painel);
			}
		}
		//adicionando painel norte ao frame
		add(painel_nor, BorderLayout.NORTH);
		pack();
	}
}
