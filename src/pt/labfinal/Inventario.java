package pt.labfinal;

import java.util.Scanner;

public class Inventario {
	private int dinheiro;
	private Arma armas[] = new Arma[10];
	private Vara varas[] = new Vara[10];
	private Peixe peixes[] = new Peixe[10];
	
	public int getDinheiro() {
		return dinheiro;
	}
	public void addDinheiro(int add) {
		dinheiro += add;
	}
	public Arma getArma(int index) {
		return armas[index];
	}
	public void addArma(Arma nova) {
		for(int i = 0; i<armas.length; i++) {
			if(armas[i] == null) {
				armas[i] = nova;
			}
		}
	}
	public Vara getVara(int index) {
		return varas[index];
	}
	public void addVara(Vara nova) {
		for(int i = 0; i<varas.length; i++) {
			if(varas[i] == null) {
				varas[i] = nova;
			}
		}
	}
	
	public Peixe getPeixe(int index) {
		return peixes[index];
	}
	public void addPeixe(Peixe novo) {
		for(int i = 0; i<peixes.length; i++) {
			if(peixes[i] == null) {
				peixes[i] = novo;
			}
		}
	}
	
	public void menus() {
		String comando = leTeclado();
		if(comando.equalsIgnoreCase("u")) {
			return;
		}
		if(comando.equalsIgnoreCase("1")) {
			comando = leTeclado();
			if(comando.matches("-?\\d+")) {
				menus();
			}
			Arma aux = armas[Integer.parseInt(comando) - 1];
			for(int i = (Integer.parseInt(comando) - 1); i>0; i--) {
				armas[i] = armas[i-1];
			}
			armas[0] = aux;
			menus();
		}else if(comando.equalsIgnoreCase("2")) {
			comando = leTeclado();
			Vara aux = varas[Integer.parseInt(comando) - 1];
			for(int i = (Integer.parseInt(comando) - 1); i>0; i--) {
				varas[i] = varas[i-1];
			}
			varas[0] = aux;
			menus();
		}else if(comando.equalsIgnoreCase("3")) {
			//peixes(interface gráfica) -> nao esquece de jogar pros menus se digitar u
		}else {
			menus();
			//manda que o mano ta arrastando
		}
	}
	
	public String leTeclado() {
		Scanner keyboard = new Scanner(System.in);
		String command = keyboard.nextLine();
		keyboard.close();
		return command;
	
	}
}

	
