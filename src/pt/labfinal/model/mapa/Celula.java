package pt.labfinal.model.mapa;

import java.awt.Image;
import java.net.URL;
import java.util.Objects;

import javax.swing.ImageIcon;

import pt.labfinal.model.mapa.componente.Bond;
import pt.labfinal.model.mapa.componente.Componente;
import pt.labfinal.model.mapa.componente.Individuo;
import pt.labfinal.model.mapa.componente.Mercado;
import pt.labfinal.model.mapa.componente.Oficina;
import pt.labfinal.model.mapa.componente.inimigo.Inimigo;

public class Celula {
	int x, y, nComponentes;
	Componente componentes[] = new Componente[4];
	Celula(int x, int y) {
		this.x = x;
		this.y = y;
		this.nComponentes = 0;
	}
	
	public void adicionaComponente(Componente novo) {
		
		if(novo instanceof Oficina || novo instanceof Mercado) {
			for(int i = 0; i<nComponentes; i++) {
				if(componentes[i] instanceof Oficina || componentes[i] instanceof Mercado) {
					//send error
					return;
				}
			}
			componentes[nComponentes] = novo;
			nComponentes++;
			return;
		}
		if(novo instanceof Inimigo) {
			for(int i = 0; i<nComponentes; i++) {
				if(componentes[i] instanceof Oficina || componentes[i] instanceof Mercado || componentes[i] instanceof Inimigo || componentes[i] instanceof Bond) {
					//send error
					return;
				}
			}
			componentes[nComponentes] = novo;
			nComponentes++;
			return;
		}
		if(novo instanceof Bond) {
			for(int i = 0; i<nComponentes; i++) {
				if(componentes[i] instanceof Inimigo) {
					//send error
					return;
				}
			}
			componentes[nComponentes] = novo;
			nComponentes++;
			return;
		}
		componentes[nComponentes] = novo;
		nComponentes++;
		
		//erro
		return;
	}
	
	public void removeComponente(Componente c) {
		
		for(int i = 0; i<nComponentes; i++) {
			
			if(componentes[i].equals(c)) {
				for(int j = i; j<nComponentes-1 ; j++) {
					
					componentes[j] = componentes[j+1];
				}
				break;
			}else {
				//throw error
			}
		}
		nComponentes--;
		componentes[nComponentes] = null;
		
	}
	
	 public Mercado achaMercado() {
		 if(nComponentes > 0) {
			 for(int i = 0; i<nComponentes; i++){
				if(componentes[i] instanceof Mercado) {
						return (Mercado)componentes[i];
				} 
			 }
		 }
		 return null;
	 }
	 
	 public Oficina achaOficina() {
		 if(nComponentes > 0) {
			 for(int i = 0; i<nComponentes; i++){
				if(componentes[i] instanceof Oficina) {
						return (Oficina)componentes[i];
				} 
			 }
		 }
		 return null;
	 }
	
	public boolean adicionaIndividuo(Individuo i) {
		if(nComponentes > 0 && componentes[nComponentes-1] instanceof Individuo) {
			//parado!
			return false;
		}else {
			componentes[nComponentes] = i;
			nComponentes++;
			return true;
		}
	}
	
	public boolean checar(char c) {
		for(int i = 0; i<nComponentes; i++) {
			if(c == 'i') {
				if(componentes[i] instanceof Inimigo) {
					if(componentes[i].getHP() > 0) {
						return true;
					}
					return false;
				}
			}else if(c == 'm') {
				if(componentes[i] instanceof Mercado) {
					return true;
				}
			}else if(c == 'o') {
				if(componentes[i] instanceof Oficina) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void entra(Bond b) {
		for(int i = 0; i<nComponentes; i++){
			if(componentes[i] instanceof Mercado || componentes[i] instanceof Oficina) {
				componentes[i].entra(b);
				return;
			}
		}
	}
	
	public void causarDano(int dano) {
		for(int i = 0; i<nComponentes; i++) {
			if(componentes[i] instanceof Inimigo) {
				componentes[i].alteraHP((-1)*dano);
				return;
			}
		}
	}
	
	public URL mostraImagem() {
		if (componentes[0] == null) {
			return null;
		}
		return Objects.requireNonNull(Componente.class.getResource(componentes[0].getImage()));
	}
}
