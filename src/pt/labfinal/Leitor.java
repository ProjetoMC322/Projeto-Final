package pt.labfinal;

import java.util.Scanner;

public class Leitor {
	private static final Leitor instance = new Leitor();
	private Resposta resposta;
	private Bond bond;
	private Mapa mapa;
	private Controle controleAtivo;
	Leitor(){
		
	}
	
	public static Leitor getInstance() {
		return instance;
	}
	
	public void conectaControle(Controle control) {
		resposta = Resposta.getInstance();
		bond = Bond.getInstance();
		mapa = Mapa.getInstance();
		controleAtivo = control;
	}
	
	public void desconectaControle() {
		controleAtivo = null;
	}
	
	public void leTeclado() {
		Scanner keyboard = new Scanner(System.in);
		String command = keyboard.nextLine();
		if(controleAtivo == null) {
			//fim  de jogo
		}
		while(controleAtivo.interpreta(command)) {
			command = keyboard.nextLine();
		}
		
		keyboard.close();
		
	}
}
