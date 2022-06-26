package pt.labfinal;

import java.util.Random;

public class Mar {
	private String nome, imagem;
	private Peixe peixes[] = new Peixe[5];
	private int probabilidades[] = new int[5];
	private Celula celulas[][];
	private Arma armas[] = new Arma[5];
	private Vara varas[] = new Vara[5];
	private Componente correntes[] = new Componente[3];
	private float CorH, CorS, CorB;

	
	Mar(String nome, String imagem, float CorH, float CorS, float CorB) {
		this.celulas = new Celula[10][10];
		for(int i = 0; i<10; i++){
			for(int j = 0; j<10; j++){
				this.celulas[i][j] =  new Celula(i, j);
			}
		}
		this.nome = nome;
		this.imagem = imagem;
		this.CorH = CorH;
		this.CorS = CorS;
		this.CorB = CorB;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getImage() {
		return imagem;
	}
	
	public float getCorH() {
		return CorH;
	}
	public float getCorS() {
		return CorS;
	}
	public float getCorB() {
		return CorB;
	}
	
	
	public void adicionaArma(Arma arma) {
		for(int i = 0; i<armas.length; i++) {
			if(armas[i] == null) {
				armas[i] = arma;
				return;
			}
		}
	}
	
	public void adicionaVara(Vara vara) {
		for(int i = 0; i<varas.length; i++) {
			if(varas[i] == null) {
				varas[i] = vara;
				return;
			}
		}
	}
	
	public void adicionaPeixe(Peixe peixe, int probabilidade) {
		for(int i = 0; i<peixes.length; i++) {
			if(peixes[i] == null) {
				probabilidades[i] = probabilidade;
				peixes[i] = peixe;
				return;
			}
		}
	}
	
	public void associaCelula(Componente c, int x, int y) {
		if((x < 10)&&(y < 10)&&(x >= 0)&&(y >= 0)) {
			
			if(c instanceof Corrente) {
				for(int i = 0; i<correntes.length; i++) {
					if(correntes[i] == null) {
						correntes[i] = c;
						celulas[x][y].adicionaComponente(c);
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
			celulas[x][y].adicionaComponente(c);
		}
	}
	
	public boolean moveIndividuo(int xa, int ya, int xd, int yd, Individuo i) {
		if((xd > 9)||(yd > 9)||(xd < 0)||(yd < 0)) {
			System.out.println("A célula que você quer acessar é fora do mar");
			//throw exception
			return false;
		}
		
		if(celulas[xd][yd].adicionaIndividuo(i)) {
			celulas[xa][ya].removeComponente(i);
			return true;
		}
		return false;
	}
	
	public boolean colocaIndividuo(Individuo p, boolean saida) {
		for(int i = 0; i<correntes.length; i++) {
			if(saida) {
				System.out.println(correntes[i].getNome().equals("Entrada"));
				if(correntes[i].getNome().equals("Entrada")) {
					System.out.println(correntes[i].getX() + " " + correntes[i].getY());
					celulas[correntes[i].getX()][correntes[i].getY()].adicionaIndividuo(p);
					p.setX(correntes[i].getX());
					p.setY(correntes[i].getY());
					return true;
				}
			}else {
				System.out.println(correntes[i].getNome().equals("Saida"));
				if(correntes[i].getNome().equals("Saida")) {
					celulas[correntes[i].getX()][correntes[i].getY()].adicionaIndividuo(p);
					p.setX(correntes[i].getX());
					p.setY(correntes[i].getY());
					return true;
				}
			}
		}
		return false;
	}
	
	
	
	public void mostra() {
		
		for(int i = 0; i<10; i++) {
			for(int j = 0; j<10; j++) {
				System.out.print(celulas[i][j].getChar());
			}
			System.out.println("");
		}
	}
	
	public void remove(Componente c, int x, int y) {
		if((x < 10)&&(y < 10)&&(x >= 0)&&(y >= 0)) {
			System.out.println(" tentando remover o componente " + c.getNome());
			celulas[x][y].removeComponente(c);
		}
	}
	//passar classe no remove
	public Peixe pescar(int bonus) {
		
		Random rand = new Random();
		int num = rand.nextInt(101), aux = 0;
		num += bonus;
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
	
	 public Mercado achaMercado(int x, int y) {
	    return celulas[x][y].achaMercado();
	 }
	 
	 public Oficina achaOficina(int x, int y) {
		    return celulas[x][y].achaOficina();
	 }
	 
	public void entra(int x, int y, Bond b) {
		System.out.println("entrou4");
		if(celulas[x][y].checar('m')) {
			celulas[x][y].entra(b);
		}else if(celulas[x][y].checar('o')) {
			//oficina
			celulas[x][y].entra(b);
		}else {
			//nao se paga de trouxa!
			return;
		}
	}
	public String mostraImagem(int x, int y) {
		return celulas[x][y].mostraImagem();
	}
}
