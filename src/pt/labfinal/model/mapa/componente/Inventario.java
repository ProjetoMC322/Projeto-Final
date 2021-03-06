package pt.labfinal.model.mapa.componente;

import pt.labfinal.model.item.Peixe;
import pt.labfinal.model.item.arma.Arma;
import pt.labfinal.model.item.vara.Vara;
import pt.labfinal.view.GUIUtilsPanel;

public class Inventario {
	private int dinheiro;
	private Arma armas[] = new Arma[15];
	private Vara varas[] = new Vara[15];
	private Peixe peixes[] = new Peixe[100];
	
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
				return;
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
				return;
			}
		}
	}
	
	public Peixe getPeixe(int index) {
		return peixes[index];
	}
	
	public Peixe[] getPeixes() {
		return peixes;
	}
	
	public Arma[] getArmas() {
		return armas;
	}
	
	public Vara[] getVaras() {
		return varas;
	}
	
	public void addPeixe(Peixe novo) {
		GUIUtilsPanel.ultimaPescaria = novo;
		for(int i = 0; i<peixes.length; i++) {
			if(peixes[i] == null) {
				peixes[i] = novo;
				return;
			}
		}
	}
	
	public void equipaArma(int index) {
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
			for(int i = index; i>0; i--) {
				armas[i] = armas[i-1];
			}
			armas[0] = aux;
		}
	}
	
	public void equipaVara(int index) {
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
			for(int i = index; i>0; i--) {
				varas[i] = varas[i-1];
			}
			varas[0] = aux;
		}
	}
	
	public void vendePeixe(int index) {
		if(index < 0) {
			return;
		}
		if(index > peixes.length) {
			return;
		}
		if(peixes[index] == null) {
			return;
		}else {
			addDinheiro(peixes[index].getPreco());
			
			for(int i = index; i<peixes.length; i++) {
				if(peixes[i] == null) {
					return;
				}
				peixes[i] = peixes[i+1];
			}
		}
	}
	
	public void adicionaMunicao() {
		for(int i = 0; i<armas.length; i++) {
			if(armas[i] == null) {
				return;
			}
			armas[i].adicionaMunicao();
		}
	}
	
}

	
