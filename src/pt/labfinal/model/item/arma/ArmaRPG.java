package pt.labfinal.model.item.arma;

import pt.labfinal.model.mapa.Mapa;

public class ArmaRPG extends Arma{
	
	public ArmaRPG(String nome, int preco, int municao, int dano, String imagem){
		super(nome, preco, municao, dano, imagem);
	}
	
	public void atirar(Mapa mapa, String movimento, int x, int y) {
		if(municaoAtual < 1) {
			//erro
			return;
		}
		if (movimento.equalsIgnoreCase("i")) {
			while(x>0) {
				if(mapa.checarInimigo(x-1, y)){
					for(int i = 0; i<3; i++) {
						for(int j = 0; j<3; j++) {
							mapa.causarDano(x-2+i, y-1+j, dano);
						}
					}
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
					for(int i = 0; i<3; i++) {
						for(int j = 0; j<3; j++) {
							mapa.causarDano(x-1+i, y-2+j, dano);
						}
					}
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
					for(int i = 0; i<3; i++) {
						for(int j = 0; j<3; j++) {
							mapa.causarDano(x+i, y-1+j, dano);
						}
					}
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
					for(int i = 0; i<3; i++) {
						for(int j = 0; j<3; j++) {
							mapa.causarDano(x-1+i, y+j, dano);
						}
					}
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
}
