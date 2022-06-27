package pt.labfinal;

public class Vara implements Item{
	private String nome, imagem;
	private int preco;
	private int durabilidadeMax;
	protected int durabilidadeAtual;
	
	//imagem
	Vara(String nome, int preco, int durabilidade, String imagem){
		this.nome = nome;
		this.preco = preco;
		this.durabilidadeAtual = durabilidade;
		this.durabilidadeMax = durabilidade;
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
	
	public int getDurabilidadeMax() {
		return durabilidadeMax;
	}
	
	public int getDurabilidadeAtual() {
		return durabilidadeAtual;
	}
	
	public Peixe pescar(Mapa mapa) {
		System.out.println("Camada4");
		if(durabilidadeAtual<1) {
			//erro arma sem durabilidade
			return null;
		}else {
			durabilidadeAtual--;
			return mapa.pescar(0);
		}
	}
}
