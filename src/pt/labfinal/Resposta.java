package pt.labfinal;

import java.lang.Math;

public class Resposta {
	
	private static final Resposta instance = new Resposta();
	private Inimigo inimigosRestantes[]  = new Inimigo[30];
	private Corrente correntesMaritmas[] = new Corrente[15];
	private Mapa mapa = Mapa.getInstance();
	private Bond bond = Bond.getInstance();
	private Inimigo godzilla;
	Resposta(){}
	public static Resposta getInstance(){
        return instance;
    }
	
	public void adicionaInimigos(Inimigo novo) {
		for(int i = 0; i < inimigosRestantes.length; i++) {
			if(inimigosRestantes[i] == null) {
				inimigosRestantes[i] = novo;
				return;
			}
		}
	}
	
	public void adicionaCorrente(Corrente novo) {
		for(int i = 0; i < correntesMaritmas.length; i++) {
			if(correntesMaritmas[i] == null) {
				correntesMaritmas[i] = novo;
				return;
			}
	
		}
	}
	
	public void setGodzilla(Inimigo novo) {
		godzilla = novo;
	}
	
	public void tick() {
		if (bond.getHP() <= 0) {
			bond.perdeuJogo();
		}else if(godzilla.getHP() <= 0) {
			bond.ganhouJogo();
		}

		
		
		for(int i = 0; i<inimigosRestantes.length; i++) {
			if(inimigosRestantes[i] == null) {
				break;
			}else if(inimigosRestantes[i].getHP() <= 0){
				mapa.remove(inimigosRestantes[i], inimigosRestantes[i].getX(), inimigosRestantes[i].getY());
			}
		}
		
		for(int i = 0; i<correntesMaritmas.length; i++) {
			if(correntesMaritmas[i] == null) {
				break;
			}
			if(correntesMaritmas[i].getZ() == bond.getZ() || correntesMaritmas[i].getX() == bond.getX() ||
					correntesMaritmas[i].getY() == bond.getY()) {
				if(correntesMaritmas[i].getNome().equals("Saida")) {
					 bond.andar("z", mapa);
				}else if(correntesMaritmas[i].getNome().equals("Entrada")) {
					 bond.andar("x", mapa);
				}
			}
		}
		
		for(int i = 0; i<inimigosRestantes.length; i++) {
			if(inimigosRestantes[i] == null) {
				break;
			}
			if(inimigosRestantes[i].getZ() == bond.getZ()) {
				if(((Math.abs(inimigosRestantes[i].getX() - bond.getX()))) >= 
						((Math.abs(inimigosRestantes[i].getY() - bond.getY())))){
							if((inimigosRestantes[i].getX() - bond.getX()) > 0) {
								if(!(mapa.checarInimigo(inimigosRestantes[i].getX()-1,inimigosRestantes[i].getY()))) {
										inimigosRestantes[i].andar("w", mapa);
								}
							}else if((inimigosRestantes[i].getX() - bond.getX()) < 0) {
								if(!(mapa.checarInimigo(inimigosRestantes[i].getX()+1,inimigosRestantes[i].getY()))) {
									inimigosRestantes[i].andar("s", mapa);
								}
							}
				}else {
					if((inimigosRestantes[i].getY() - bond.getY()) > 0) {
						if(!(mapa.checarInimigo(inimigosRestantes[i].getX(),inimigosRestantes[i].getY()-1))) {
							inimigosRestantes[i].andar("a", mapa);
						}
					}else if((inimigosRestantes[i].getY() - bond.getY()) < 0) {
						if(!(mapa.checarInimigo(inimigosRestantes[i].getX(),inimigosRestantes[i].getY()+1))) {
							inimigosRestantes[i].andar("d", mapa);
					}
					}
				}
			}
		}
		for(int i = 0; i<inimigosRestantes.length; i++) {
			if(inimigosRestantes[i] == null) {
				break;
			}
			if(inimigosRestantes[i].getZ() == bond.getZ()) {
				if(((Math.abs(inimigosRestantes[i].getX() - bond.getX()) <= 1)) &&
						(((Math.abs(inimigosRestantes[i].getY() - bond.getY()) <= 1)))) {
					inimigosRestantes[i].danifica(bond);
				}
			}
		}
	}
}
