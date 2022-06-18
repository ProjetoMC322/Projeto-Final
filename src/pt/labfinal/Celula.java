package pt.labfinal;

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
		//erro
		return;
	}
	
	public void removeComponente(String nome) {
		for(int i = 0; i<nComponentes; i++) {
			if(componentes[i].getNome().equals(nome)) {
				for(int j = i; j<nComponentes-1 ; j++) {
					componentes[j] = componentes[j+1];
				}
				break;
			}
		}
		componentes[nComponentes] = null;
		nComponentes--;
	}
	
	public void adicionaBond(Bond b) {
		if(nComponentes > 0 && componentes[nComponentes-1] instanceof Inimigo) {
			//decidir o que fazer
			return;
		}else {
			componentes[nComponentes] = b;
			nComponentes++;
		}
	}
}
