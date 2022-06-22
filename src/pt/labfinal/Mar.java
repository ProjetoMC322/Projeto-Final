package pt.labfinal;

import java.util.Random;

public class Mar {
	private String nome;
	private Peixe peixes[] = new Peixe[3];
	private int probabilidades[] = new int[3];
	private Celula celulas[][] = new Celula[10][10];
	private Arma armas[] = new Arma[5];
	private Vara varas[] = new Vara[5];
	private Componente correntes[] = new Componente[3];
	//melhorias
	//imagem
	//inimigos
	Mar(String nome) {
		for(int i = 0; i<10; i++){
			for(int j = 0; j<10; j++){
				this.celulas[i][j] =  new Celula(i, j);
			}
		}
		this.nome = nome;
	}
	
	//metodo peixe-probabilidae
	
	void adicionaArma(Arma arma) {
		for(int i = 0; i<armas.length; i++) {
			if(armas[i] == null) {
				armas[i] = arma;
				return;
			}
		}
	}
	
	void adicionaVara(Vara vara) {
		for(int i = 0; i<varas.length; i++) {
			if(varas[i] == null) {
				varas[i] = vara;
				return;
			}
		}
	}
	public void associaCelula(Componente c, int x, int y) {
		if((x < 10)&&(y < 10)&&(x >= 0)&&(y >= 0)) {
			celulas[x][y].adicionaComponente(c);
			if(c instanceof Corrente) {
				for(int i = 0; i<correntes.length; i++) {
					if(correntes[i] == null) {
						correntes[i] = c;
						return;
					}
				}
			}else if(c instanceof Mercado) {
				for(int i = 0; i<armas.length; i++) {
					if(armas[i] == null) {
						break;
					}else {
						c.adicionaArma(armas[i]);
					}
				}
				for(int i = 0; i<varas.length; i++) {
					if(varas[i] == null) {
						break;
					}else {
						c.adicionaVara(varas[i]);
					}
				}
			}
		}
	}
	
	public void moveBond(int xa, int ya, int xd, int yd, Bond p) {
		if((xd > 9)||(yd > 9)||(xd < 0)||(yd < 0)) {
			System.out.println("A célula que você quer acessar é fora do mar");
			//throw exception
			return;
		}
		celulas[xa][ya].removeComponente("Bond");
		celulas[xd][yd].adicionaBond(p);
	}
	
	public void colocaBond(Bond p, boolean saida) {
		for(int i = 0; i<correntes.length; i++) {
			if(saida) {
				if(correntes[i].getNome().equals("Saida")) {
					celulas[correntes[i].getX()][correntes[i].getY()].adicionaBond(p);
				}
			}else {
				if(correntes[i].getNome().equals("Entrada")) {
					celulas[correntes[i].getX()][correntes[i].getY()].adicionaBond(p);
				}
			}
		}
	}
	
	public void remove(String nome, int x, int y) {
		if((x < 10)&&(y < 10)&&(x >= 0)&&(y >= 0)) {
			celulas[x][y].removeComponente(nome);
		}
	}
	
	public Peixe pescar() {
		Random rand = new Random();
		int num = rand.nextInt(101), aux = 0;
		while(num>probabilidades[aux]) {
			aux++;
		}
		return peixes[aux];
	}
	
	public boolean checar(int x, int y, char c) {
    	return celulas[x][y].checar(c);
    }
	
	public void causarDano(int x, int y, int dano) {
		celulas[x][y].causarDano(dano);
	}
	
	public void entra(int x, int y, Bond b) {
		if(celulas[x][y].checar('m')) {
			//mercado
		}else if(celulas[x][y].checar('o')) {
			//oficina
			celulas[x][y].entra(b);
		}else {
			//nao se paga de trouxa!
			return;
		}
	}
}
