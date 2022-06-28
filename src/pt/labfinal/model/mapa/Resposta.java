package pt.labfinal.model.mapa;

import java.lang.Math;

import pt.labfinal.model.mapa.componente.Bond;
import pt.labfinal.model.mapa.componente.Componente;
import pt.labfinal.model.mapa.componente.inimigo.Inimigo;

public class Resposta {
	
	private static final Resposta instance = new Resposta();
	private Inimigo inimigosRestantes[]  = new Inimigo[30];
	private Componente correntesMaritmas[] = new Componente[15];
	private Mapa mapa;
	private Bond bond;
	private Inimigo godzilla;
	
	Resposta(){}
	public static Resposta getInstance(){
        return instance;
    }
	
	public Inimigo[] getInimigos() {
		Inimigo inimigos[] = new Inimigo[10];
		int aux = 0;
		for(int i = 0; i < inimigosRestantes.length; i++) {
			if(inimigosRestantes[i] == null) {
				return inimigos;
			}else if(inimigosRestantes[i].getZ() == bond.getZ()){
				inimigos[aux] = inimigosRestantes[i];
				aux++;
			}
		}
		return inimigos;
	}
	
	public void adicionaInimigos(Inimigo novo) {
		for(int i = 0; i < inimigosRestantes.length; i++) {
			if(inimigosRestantes[i] == null) {
				inimigosRestantes[i] = novo;
				return;
			}
		}
	}
	
	public void adicionaCorrente(Componente novo) {
		for(int i = 0; i < correntesMaritmas.length; i++) {
			if(correntesMaritmas[i] == null) {
				
				correntesMaritmas[i] = novo;
				return;
			}
	
		}
	}
	
	public void setGodzilla(Inimigo novo) {
		mapa = Mapa.getInstance();
		bond = Bond.getInstance();
		godzilla = novo;
	}
	
	public void tick() {
		
		if (bond.getHP() <= 0) {
			System.out.println("morreu");
			bond.perdeuJogo();
		}else if(godzilla.getHP() <= 0) {
			bond.ganhouJogo();
		}
		int dead = 0;
		for(int i = 0; i<inimigosRestantes.length; i++) {
			if(inimigosRestantes[i-dead] == null) {
				continue;
			}
			if(inimigosRestantes[i-dead].getHP() <= 0){
				mapa.remove(inimigosRestantes[i-dead], inimigosRestantes[i-dead].getX(), inimigosRestantes[i-dead].getY());
				for(int j = i-dead; j<inimigosRestantes.length; j++) {
					inimigosRestantes[j] = inimigosRestantes[j+1];
					
					if(inimigosRestantes[j] == null) {
						dead++;
						break;
					}
				}
			
			}
		}
		
		for(int i = 0; i<correntesMaritmas.length; i++) {
			if(correntesMaritmas[i] == null) {
				break;
			}
			if((correntesMaritmas[i].getZ() == bond.getZ()) && (correntesMaritmas[i].getX() == bond.getX()) &&
					(correntesMaritmas[i].getY() == bond.getY())) {
				if(correntesMaritmas[i].getNome().equals("Saida")) {
					 bond.andar("z", mapa);
					 break;
				}else if(correntesMaritmas[i].getNome().equals("Entrada")) {
					 bond.andar("x", mapa);
					 break;
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
