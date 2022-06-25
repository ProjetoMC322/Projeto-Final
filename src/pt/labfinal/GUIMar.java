package pt.labfinal;

import javax.swing.*;
import java.awt.*;


public class GUIMar extends JFrame{
	
	private static final long serialVersionUID = 3L;
	private Mapa mapa = Mapa.getInstance();
	
	
	public GUIMar(String linkimagem) {
		setTitle("007: Aposentadoria");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000,500);
		setVisible(true);
		setLayout(new BorderLayout(50,50));
		
		JPanel painel_esq = new JPanel();
		painel_esq.setSize(200,200);
		JLabel comandos = new JLabel ("comandos aqui");
		JButton botao = new JButton ("Clique aqui!");
		painel_esq.add(botao, BorderLayout.NORTH);
		painel_esq.add(comandos, BorderLayout.SOUTH);
		add(painel_esq);
		
		JPanel painel_dir = new JPanel();
		painel_dir.setLayout(new GridLayout(10,10));
		painel_dir.setSize(800,800);
		
		for(int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				JPanel painel = new JPanel();
				painel.setBounds(0,0,50,50);
				painel.setBackground(Color.getHSBColor(0.66f, 1.0f, 0.58f));
				Imagem imagex = new Imagem(linkimagem);
				painel.add(imagex);
				painel_dir.add(painel);
			}
		}
		add(painel_dir);
	}
}
