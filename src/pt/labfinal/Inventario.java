package pt.labfinal;

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
}
