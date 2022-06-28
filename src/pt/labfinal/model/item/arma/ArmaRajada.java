package pt.labfinal.model.item.arma;

import pt.labfinal.model.mapa.Mapa;

public class ArmaRajada extends Arma{
	private int tiros;
	
	public ArmaRajada(String nome, int preco, int municao, int dano, String imagem, int tiros){
		super(nome, preco, municao, dano, imagem);
		this.tiros = tiros;
	}
	
	public void atirar(Mapa mapa, String movimento, int x, int y) {
		for(int i = 0; i<tiros; i++) {
			super.atirar(mapa, movimento, x, y);
		}
	}
}
