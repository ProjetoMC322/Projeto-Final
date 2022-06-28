package pt.labfinal.model.item;

public class Peixe implements Item{
	private String nome, imagem;
	private int preco;
	public Peixe(String nome, int preco, String imagem){
		this.nome = nome;
		this.preco = preco;
		this.imagem = imagem;
	}
	
	public String getNome() {
		return nome;
	}
	public String getImage() {
		return System.getProperty("user.dir") + imagem;
	}
	public int getPreco() {
		return preco;
	}
	
}
