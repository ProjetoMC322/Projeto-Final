package pt.labfinal;

import java.awt.event.*;

public class Leitor extends KeyAdapter {
	private static final Leitor instance = new Leitor();
	
	private Controle controleAtivo;
	Leitor(){
		
	}
	
	public static Leitor getInstance() {
		return instance;
	}
	
	public void conectaControle(Controle control) {	
		this.controleAtivo = control;
	}
	
	public void desconectaControle() {
		//System.out.println("is disconecting");
		controleAtivo = null;
	}
	
	public void keyPressed(KeyEvent e) {
		//System.out.println(controleAtivo);
		String command  = "";
		
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W:
			command = "w";
			break;
		case KeyEvent.VK_A:
			command = "a";
			break;
		case KeyEvent.VK_S:
			command = "s";
			break;
		case KeyEvent.VK_D:
			command = "d";
			break;
		case KeyEvent.VK_J:
			command = "j";
			break;
		case KeyEvent.VK_L:
			command = "l";
			break;
		case KeyEvent.VK_K:
			command = "k";
			break;
		case KeyEvent.VK_I:
			command = "i";
			break;
		case KeyEvent.VK_Q:
			command = "q";
			break;
		case KeyEvent.VK_P:
			command = "p";
			break;
		case KeyEvent.VK_U:
			command = "u";
			break;
		case KeyEvent.VK_M:
			command = "m";
			break;
		case KeyEvent.VK_1:
			command = "1";
			break;
		case KeyEvent.VK_2:
			command = "2";
			break;
		case KeyEvent.VK_3:
			command = "3";
			break;
		case KeyEvent.VK_4:
			command = "4";
			break;
		case KeyEvent.VK_5:
			command = "5";
			break;
		case KeyEvent.VK_6:
			command = "6";
			break;
		case KeyEvent.VK_7:
			command = "7";
			break;
		case KeyEvent.VK_8:
			command = "8";
			break;
		case KeyEvent.VK_9:
			command = "9";
			break;
		case KeyEvent.VK_0:
			command = "0";
			break;	
		}
		if(!controleAtivo.interpreta(command)) {
			System.out.println("cabo o jogo!");
		}
	}
	

}
