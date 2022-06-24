package pt.labfinal;

import java.util.Scanner;

public class Mercado extends Componente{
	private Arma armas[] = new Arma[5];
	private Vara varas[] = new Vara[5];
	private int precoMunicao;
	
	Mercado(String nome, int x, int y, int z, int precoMunicao, String imagem){
		super(nome, x, y, z, imagem);
		this.precoMunicao = precoMunicao;
		
	}
	
	
	public void adicionaArma(Arma novo) {
		for(int i = 0; i<armas.length; i++) {
			if(armas[i] == null) {
				armas[i] = novo;
				return;
			}
		}
	}
	
	public void adicionaVara(Vara novo) {
		for(int i = 0; i<varas.length; i++) {
			if(varas[i] == null) {
				varas[i] = novo;
				return;
			}
		}
	}
	
	public void entra(Bond b) {
		String comando = leTeclado();
		if(comando.equalsIgnoreCase("m")) {
			return;
		}
		if(comando.equalsIgnoreCase("1")) {
			//armas
			comando = leTeclado();
			if(!comando.matches("-?\\d+")) {
				entra(b);
			}
			Arma aux = armas[Integer.parseInt(comando) - 1];
			if(b.getDinheiro() > aux.getPreco()) {
				b.adicionaArma(aux);
				b.gastaDinheiro(aux.getPreco());
				for(int i = Integer.parseInt(comando) - 1; i<armas.length; i++) {
					armas[i] = armas[i+1];
					if(armas[i+1] == null) {
						break;
					}
				}
			}else {
				//falta
				
			}
			entra(b);
		}else if(comando.equalsIgnoreCase("2")) {
			//varas
			comando = leTeclado();
			if(!comando.matches("-?\\d+")) {
				entra(b);
			}
			Vara aux = varas[Integer.parseInt(comando) - 1];
			if(b.getDinheiro() > aux.getPreco()) {
				b.adicionaVara(aux);
				b.gastaDinheiro(aux.getPreco());
				for(int i = Integer.parseInt(comando) - 1; i<varas.length; i++) {
					varas[i] = varas[i+1];
					if(varas[i+1] == null) {
						break;
					}
				}
			}else {
				//falta
				
			}
			entra(b);
		}else if(comando.equalsIgnoreCase("3")) {
			b.venda();
			entra(b);
		}else if(comando.equalsIgnoreCase("4")) {
			//ammo
			if(b.getDinheiro() > precoMunicao) {
				b.adicionaMunicao();
				b.gastaDinheiro(precoMunicao);
			}else {
				//falta 
			}
			entra(b);
		}else {
			entra(b);
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
