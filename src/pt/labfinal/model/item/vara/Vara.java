package pt.labfinal.model.item.vara;

import pt.labfinal.model.item.Item;
import pt.labfinal.model.item.Peixe;
import pt.labfinal.model.mapa.Mapa;

public class Vara implements Item{
	private String nome, imagem;
	private int preco;
	private int durabilidadeMax;
	protected int durabilidadeAtual;
	
	//imagem
	public Vara(String nome, int preco, int durabilidade, String imagem){
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
		return imagem;
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
		
		if(durabilidadeAtual<1) {
			//erro arma sem durabilidade
			return null;
		}else {
			durabilidadeAtual--;
			return mapa.pescar(0);
		}
	}
}
