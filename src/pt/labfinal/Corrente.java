package pt.labfinal;

public class Corrente implements Componente{
	private String nome;
	private String imagem;
	private int x, y, z;
	//imagem
	Corrente(String nome, int x, int y, int z, String imagem){
		this.nome = nome;
		this.x = x;
		this.y = y;
		this.z = z;
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
	public void alteraHP(int novo) {
		return;
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