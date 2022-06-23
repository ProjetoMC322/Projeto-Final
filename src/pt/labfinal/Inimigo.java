package pt.labfinal;

public class Inimigo implements Componente{
	private String nome;
	private String imagem;
	protected int x, y, z, hpMax, hpAtual, dano; 
	//imagem
	Inimigo(String nome, int x, int y, int z, int hp, int dano, String imagem){
		this.nome = nome;
		this.x = x;
		this.y = y;
		this.z = z;
		this.hpAtual = hp;
		this.hpMax = hp;
		this.dano = dano;
		this.imagem = imagem;
	}
	
	public String getNome() {
		return nome;
	}
	public String getImage() {
		return imagem;
	}
	public int getX() {
		return x;
	};
	
	public int getY() {
		return y;
	};
	public int getZ() {
		return z;
	};
	
	public int getHP() {
		return hpAtual;
	};
	public int getHPMax() {
		return hpMax;
	};
	public void alteraHP(int mudanca) {
		hpAtual += mudanca;
	}
	public void setX(int novo) {
		this.x = novo;
	};
	public void setY(int novo) {
		this.y = novo;
	}
	public void setZ(int novo) {
		this.z = novo;
	};
	
	public void andar(String movimento, Mapa mapa) {
		return;
	}
	public void atirar(){
		return;
	}
	public void danifica(Bond bond) {
		bond.alteraHP((-1)*dano);
	}
	public void entra(Bond b) {
		return;
	}
	public void adicionaArma(Arma a) {
		return;
	}
	public void adicionaVara(Vara v) {
		return;
	}
}