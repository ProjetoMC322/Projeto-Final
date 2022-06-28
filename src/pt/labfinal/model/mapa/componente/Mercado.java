package pt.labfinal.model.mapa.componente;

import pt.labfinal.model.item.arma.Arma;
import pt.labfinal.model.item.vara.Vara;

public class Mercado extends Componente{
	private Arma armas[] = new Arma[5];
	private Vara varas[] = new Vara[5];
	private int precoMunicao;
	
	public Mercado(String nome, int x, int y, int z, int precoMunicao, String imagem){
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
	
	public Arma[] getArmas() {
		return armas;
	}
	
	public Vara[] getVaras() {
		return varas;
	}
	
	public void mostra(int index) {
		if(index>3) {
			return;
		}else if(index == 2) {
			for(int i = 0; i<varas.length; i++) {
				if(varas[i] == null) {
					return;
				}
				System.out.println(varas[i].getNome() + " " + varas[i].getPreco());
			}
		}else if(index == 1) {
			for(int i = 0; i<armas.length; i++) {
				if(armas[i] == null) {
					return;
				}
				System.out.println(armas[i].getNome() + " " + armas[i].getPreco() + " causando " + armas[i].getDano() + "de dano");
			}
		}
	}
	
	public void compraArma(int index, Bond bond) {
		if(index < 0) {
			return;
		}
		if(index > armas.length) {
			return;
		}
		if(armas[index] == null) {
			return;
		}else {
			Arma aux = armas[index];
			if(aux.getPreco() > bond.getDinheiro()) {
				System.out.println("Voce nao tem dinheiro necessario!");
				return;
			}
			bond.adicionaArma(aux);
			bond.gastaDinheiro(aux.getPreco());
			
			for(int i = index; i<armas.length; i++) {
				if(armas[i] == null) {
					return;
				}
				armas[i] = armas[i+1];
			}
			
		}
	}
	
	public void compraVara(int index, Bond bond) {
		if(index < 0) {
			return;
		}
		if(index > varas.length) {
			return;
		}
		if(varas[index] == null) {
			return;
		}else {
			Vara aux = varas[index];
			if(aux.getPreco() > bond.getDinheiro()) {
				return;
			}
			bond.adicionaVara(aux);
			bond.gastaDinheiro(aux.getPreco());
			varas[index] = null;
			for(int i = index; i<varas.length; i++) {
				if(varas[i] == null) {
					return;
				}
				varas[i] = varas[i+1];
			}
			
		}
	}
	
	public void compraMunicao(Bond bond) {
		if(precoMunicao> bond.getDinheiro()) {
			return;
		} 
		bond.gastaDinheiro(precoMunicao);
		bond.adicionaMunicao();
	}
	
}
