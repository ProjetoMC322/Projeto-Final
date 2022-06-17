package pt.labfinal;

public class Peixe implements Item{
	private String nome;
	private int preco;
	//imagem
	Peixe(String nome, int preco){
		this.nome = nome;
		this.preco = preco;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getPreco() {
		return preco;
	}
	
}
