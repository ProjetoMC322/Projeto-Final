package pt.labfinal;

public class Arma implements Item{
	private String nome;
	private int preco;
	private int municaoMax;
	private int municaoAtual;
	
	//imagem
	Arma(String nome, int preco, int municao){
		this.nome = nome;
		this.preco = preco;
		this.municaoAtual = municao;
		this.municaoMax = municao;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getPreco() {
		return preco;
	}
	
	public int getMunicaoMax() {
		return municaoMax;
	}
	
	public int getMunicaoAtual() {
		return municaoAtual;
	}
}
