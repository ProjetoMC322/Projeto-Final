package pt.labfinal;

public class Vara implements Item{
	private String nome;
	private int preco;
	private int durabilidadeMax;
	private int durabilidadeAtual;
	
	//imagem
	Vara(String nome, int preco, int durabilidade){
		this.nome = nome;
		this.preco = preco;
		this.durabilidadeAtual = durabilidade;
		this.durabilidadeMax = durabilidade;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getPreco() {
		return preco;
	}
	
	public int getDurabilidadeMax() {
		return durabilidadeMax;
	}
	
	public int getDurabilidadeAtual() {
		return durabilidadeAtual;
	}
}
