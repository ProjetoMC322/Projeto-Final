package pt.labfinal;

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
    		}
    	}
    }
    
    public int getMarAtivo() {
    	return marAtivo;
    }
    
    public void conecta(Componente c) {
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
    
    public boolean checarInimigo(int x, int y) {
    	return mares[marAtivo].checar(x, y, 'i');
    }
    
    public void causarDano(int x, int y, int dano) {
    	mares[marAtivo].causarDano(x, y, dano);
    }
    
    public void moveIndividuo(int xa, int ya, int xd, int yd, Individuo i) {
    	mares[marAtivo].moveIndividuo(xa, ya, xd, yd, i);
    }
    
    public void sobeIndividuo(boolean saida, Individuo i) {
    	mares[marAtivo].remove(i, i.getX(), i.getY());
    	if(saida) {
    		mares[marAtivo-1].colocaIndividuo(i, saida);
    	}else {
    		mares[marAtivo+1].colocaIndividuo(i, saida);
    		//erros
    	}
    }
    
    public void entra(int x, int y, int z, Bond b) {
    	mares[z].entra(x, y, b);
    }
    
    public void remove(Componente c, int x, int y) {
		mares[marAtivo].remove(c, x, y);
    }
}
