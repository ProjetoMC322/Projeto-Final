package pt.labfinal;

import javax.swing.*;
import java.awt.*;


public class GUIMar extends JFrame{
	private static final GUIMar instance = new GUIMar ();
	public static GUIMar getInstance(){
        return instance;
    }
	
	private static final long serialVersionUID = 3L;
	private Mapa mapa = Mapa.getInstance();
	
	public GUIMar() {
		//criando frame
		setTitle("007: Aposentadoria");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,500);
		setVisible(true);
		
		//criando painel dentro do frame
		JPanel painel = new JPanel();
		painel.setSize(500,500);
		painel.setLayout(new GridLayout(10,10));

		
		//criando cada painelzinho da grid
		for(int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				JPanel painelzim = new JPanel();
				painelzim.setSize(80, 80);
				painelzim.setBackground(Color.getHSBColor(mapa.pegaCorH(), mapa.pegaCorS(), mapa.pegaCorB()));
				//tava 0.66f, 1.0f, 0.58f, vamos ter que adicionar no csv os valores pra cor de cada mapa
				Imagem imagex = new Imagem(mapa.mostraImagem(i, j));
				painelzim.add(imagex);
				painel.add(painelzim);
			}
		}
		
		add(painel);
		pack();
	}
	
	//temos que ver como atualizar o guimar para que nao sejam criadas novas abas com o mar toda hora, ver se vai ser singleton, etc.
	
	
	
	//ta dando bosta no atualizaGUIMar
	public void atualizaGUIMar() {
		setTitle("007: Aposentadoria");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800,800);
		setVisible(true);
		
		//criando painel dentro do frame
		JPanel painel = new JPanel();
		painel.setSize(800,800);
		painel.setLayout(new GridLayout(10,10));
		for(int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				JPanel painelzim = new JPanel();
				painelzim.setSize(80, 80);
				painelzim.setBackground(Color.getHSBColor(mapa.pegaCorH(), mapa.pegaCorS(), mapa.pegaCorB()));
				//tava 0.66f, 1.0f, 0.58f, vamos ter que adicionar no csv os valores pra cor de cada mapa
				Imagem imagex = new Imagem(mapa.mostraImagem(i, j));
				painelzim.add(imagex);
				painel.add(painelzim);
			}
		}
	}
}
