package pt.labfinal.model.item.arma;

import pt.labfinal.model.mapa.Mapa;

public class ArmaCanhao extends Arma{
		
	public ArmaCanhao(String nome, int preco, int municao, int dano, String imagem){
		super(nome, preco, municao, dano, imagem);
	}
	
	public void atirar(Mapa mapa, String movimento, int x, int y) {
		if(municaoAtual < 1) {
			//erro
			return;
		}
		if (movimento.equalsIgnoreCase("i")) {
			while(x>0) {
				mapa.causarDano(x-1, y, dano);
				x--;
			}
			municaoAtual--;
			return;
		}else if (movimento.equalsIgnoreCase("j")) {
			while(y>0) {
				mapa.causarDano(x, y-1, dano);
				y--;
			}
			municaoAtual--;
			return;
		}else if (movimento.equalsIgnoreCase("k")) {
			while(x<9) {
				mapa.causarDano(x+1, y, dano);
				x++;
			}
			municaoAtual--;
			return;
		}else if (movimento.equalsIgnoreCase("l")) {
			while(y<9) {
				mapa.causarDano(x, y+1, dano);
				y++;
			}
			municaoAtual--;
			return;
		}
		return;
	}
}


