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
		System.out.println("dinheiro antes: " + dinheiro);
		dinheiro += add;
		System.out.println("dinheiro depois: " + dinheiro);
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
	
	public void mostra(int index) {
		if(index>3) {
			return;
		}else if(index == 3) {
			for(int i = 0; i<peixes.length; i++) {
				if(peixes[i] == null) {
					return;
				}
				System.out.println(peixes[i].getNome() + " " + peixes[i].getPreco());
			}
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
				System.out.println(armas[i].getNome() + " " + armas[i].getPreco());
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
			peixes[index] = null;
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

	
