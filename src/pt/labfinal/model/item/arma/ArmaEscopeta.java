package pt.labfinal.model.item.arma;

import pt.labfinal.model.mapa.Mapa;

public class ArmaEscopeta extends Arma{
	
	public ArmaEscopeta(String nome, int preco, int municao, int dano, String imagem){
		super(nome, preco, municao, dano, imagem);
	}
	
	public void atirar(Mapa mapa, String movimento, int x, int y) {
		if(municaoAtual < 1) {
			//erro
			return;
		}
		if (movimento.equalsIgnoreCase("i")) {
			mapa.causarDano(x-1, y, dano);
			mapa.causarDano(x-2, y-1, dano/2);
			mapa.causarDano(x-2, y, dano/2);
			mapa.causarDano(x-2, y+1, dano/2);
			municaoAtual--;
			return;
		}else if (movimento.equalsIgnoreCase("j")) {
			mapa.causarDano(x, y-1, dano);
			mapa.causarDano(x-1, y-2, dano/2);
			mapa.causarDano(x, y-2, dano/2);
			mapa.causarDano(x+1, y-2, dano/2);
			municaoAtual--;
			return;
		}else if (movimento.equalsIgnoreCase("k")) {
			mapa.causarDano(x+1, y, dano);
			mapa.causarDano(x+2, y-1, dano/2);
			mapa.causarDano(x+2, y, dano/2);
			mapa.causarDano(x+2, y+1, dano/2);
			municaoAtual--;
			return;
		}else if (movimento.equalsIgnoreCase("l")) {
			mapa.causarDano(x, y+1, dano);
			mapa.causarDano(x-1, y+2, dano/2);
			mapa.causarDano(x, y+2, dano/2);
			mapa.causarDano(x+1, y+2, dano/2);
			municaoAtual--;
			return;
		}
		return;
	}
}
