package pt.labfinal;

public class Oficina implements Componente{
	private String nome;
	private int x, y, z;
	//imagem
	Oficina(String nome, int x, int y, int z){
		this.nome = nome;
		this.x = x;
		this.y = y;
		this.z = z;
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
	public void setX(int novo) {
		this.x = novo;
	};
	public void setY(int novo) {
		this.y = novo;
	}
	public void setZ(int novo) {
		this.z = novo;
	};
	
	public String getNome() {
		return nome;
	}
	
	public void andar() {
		return;
	}
	public void atirar(){
		return;
	}
	public void alteraHP(int novo) {
		return;
	}
}
