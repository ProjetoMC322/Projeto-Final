package pt.labfinal;

public class Oficina implements Componente{
	private String nome;
	private int x, y;
	//imagem
	Oficina(String nome, int x, int y){
		this.nome = nome;
		this.x = x;
		this.y = y;
	}
	
	public String getNome() {
		return nome;
	}
	public void add(Mar mar) {
		mar.adiciona(this, x, y);
	};
	
	public void andar() {
		return;
	}
	public void atirar(){
		return;
	}
}
