package pt.labfinal;

public class Inimigo implements Componente{
	private String nome;
	private int x, y, z, hpMax, hpAtual; ;
	//imagem
	Inimigo(String nome, int x, int y, int z, int hp){
		this.nome = nome;
		this.x = x;
		this.y = y;
		this.z = z;
		this.hpAtual = hp;
		this.hpMax = hp;
	}
	
	public String getNome() {
		return nome;
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
	
	public void andar() {
		return;
	}
	public void atirar(){
		return;
	}

}