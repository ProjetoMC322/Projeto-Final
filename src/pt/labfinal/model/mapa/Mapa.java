package pt.labfinal.model.mapa;

import pt.labfinal.model.item.Peixe;
import pt.labfinal.model.mapa.componente.Bond;
import pt.labfinal.model.mapa.componente.Componente;
import pt.labfinal.model.mapa.componente.Corrente;
import pt.labfinal.model.mapa.componente.Individuo;
import pt.labfinal.model.mapa.componente.Mercado;
import pt.labfinal.model.mapa.componente.Oficina;
import pt.labfinal.model.mapa.componente.inimigo.Inimigo;

public class Mapa {

	private static final Mapa instance = new Mapa ();
	private Mar mares[] =  new Mar[6];
	private int marAtivo = 0;
	private Resposta resposta = Resposta.getInstance();
	
	private Mapa(){}

    public static Mapa getInstance(){
        return instance;
    }
	
    public void adicionaMar(Mar novo) {
    	for(int i = 0; i<mares.length; i++) {
    		
  
    		if(mares[i] == null) {
    			mares[i] = novo;
    			return;
    		}
    	}
    }
    
    public int getMarAtivo() {
    	return marAtivo;
    }
    
    public void conecta(Componente c) {
    	if(c instanceof Corrente) {
    		resposta.adicionaCorrente(c);
    	}
    	if(c instanceof Inimigo) {
    		resposta.adicionaInimigos((Inimigo)c);
    	}
		mares[c.getZ()].associaCelula(c, c.getX(), c.getY());
		
	}
    
    public void conectaGodzilla(Inimigo c) {
		conecta(c);
		resposta.setGodzilla(c);
	}
    
    public Peixe pescar(int bonus) {
    	System.out.println("Camada5");
    	return mares[marAtivo].pescar(bonus);
    }
    
    public void mostraMapa() {
    	mares[marAtivo].mostra();
    }
    
    public boolean checarInimigo(int x, int y) {
    	return mares[marAtivo].checar(x, y, 'i');
    }
    
    public void causarDano(int x, int y, int dano) {
    	mares[marAtivo].causarDano(x, y, dano);
    }
    
    public boolean moveIndividuo(int xa, int ya, int xd, int yd, Individuo i) {
    	return mares[marAtivo].moveIndividuo(xa, ya, xd, yd, i);
    }
    
    public boolean sobeIndividuo(boolean saida, Individuo i) {
    	mares[marAtivo].remove(i, i.getX(), i.getY());
    	if(saida) {
    		
    		marAtivo++;
    		System.out.println("esta aparecendo "+ marAtivo+" vezes");
    		if(mares[marAtivo].colocaIndividuo(i, saida)) {
    			//i.setZ(marAtivo);
    			return true;
    		}
    		return false;
    	}else {
    		marAtivo--;
    		if(mares[marAtivo].colocaIndividuo(i, saida)) {
    			//i.setZ(marAtivo);
    			return true;
    		}
    		return false;
    		//erros
    	}
    }
    
    public Mercado achaMercado(int x, int y, int z) {
    	return mares[z].achaMercado(x,y);
    }
    
    public Oficina achaOficina(int x, int y, int z) {
    	return mares[z].achaOficina(x,y);
    }
    
    public void entra(int x, int y, int z, Bond b) {
    	
    	mares[z].entra(x, y, b);
    }
    
    public void remove(Componente c, int x, int y) {
		mares[marAtivo].remove(c, x, y);
    }
    
    public String mostraImagem(int x, int y) {
    	return mares[marAtivo].mostraImagem(x,y);
    }
    
    public float pegaCorH() {
    	return mares[marAtivo].getCorH();
    }
    
    public float pegaCorS() {
    	return mares[marAtivo].getCorS();
    }
    
    public float pegaCorB() {
    	return mares[marAtivo].getCorB();
    }
}
