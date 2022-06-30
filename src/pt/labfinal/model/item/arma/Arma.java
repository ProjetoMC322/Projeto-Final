package pt.labfinal.model.item.arma;

import pt.labfinal.model.item.Item;
import pt.labfinal.model.mapa.Mapa;

public class Arma implements Item{
	private String nome;
	private String imagem;
	private int preco;
	private int municaoMax;
	protected int municaoAtual;
	protected int dano;
	
	//imagem
	public Arma(String nome, int preco, int municao, int dano, String imagem){
		this.nome = nome;
		this.preco = preco;
		this.municaoAtual = municao;
		this.municaoMax = municao;
		this.dano = dano;
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
	
	public int getMunicaoMax() {
		return municaoMax;
	}
	
	public int getMunicaoAtual() {
		return municaoAtual;
	}
	
	public int getDano() {
		return dano;
	}
	
	
	public void atirar(Mapa mapa, String movimento, int x, int y) {
		if(municaoAtual < 1) {
			return;
		}
		if (movimento.equalsIgnoreCase("i")) {
			while(x>0) {
				if(mapa.checarInimigo(x-1, y)){
					mapa.causarDano(x-1, y, dano);
					municaoAtual--;
					return;
				}
				x--;
			}
			municaoAtual--;
			return;
		}else if (movimento.equalsIgnoreCase("j")) {
			while(y>0) {
				if(mapa.checarInimigo(x, y-1)){
					mapa.causarDano(x, y-1, dano);
					municaoAtual--;
					return;
				}
				y--;
			}
			municaoAtual--;
			return;
		}else if (movimento.equalsIgnoreCase("k")) {
			while(x<9) {
				if(mapa.checarInimigo(x+1, y)){
					mapa.causarDano(x+1, y, dano);
					municaoAtual--;
					return;
				}
				x++;
			}
			municaoAtual--;
			return;
		}else if (movimento.equalsIgnoreCase("l")) {
			while(y<9) {
				if(mapa.checarInimigo(x, y+1)){
					mapa.causarDano(x, y+1, dano);
					municaoAtual--;
					return;
				}
				y++;
			}
			municaoAtual--;
			return;
		}
		return;
	}
	
	public void adicionaMunicao() {
		municaoAtual +=  municaoAtual/4;
		if(municaoAtual/4 < 1) {
			municaoAtual += 1;
		}
		if(municaoAtual > municaoMax) {
			municaoAtual = municaoMax;
		}
	}
}
