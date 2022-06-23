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
    
    public void moveBond(int xa, int ya, int xd, int yd, Bond p) {
    	mares[marAtivo].moveBond(xa, ya, xd, yd, p);
    }
    
    public void sobeBond(boolean saida, Bond p) {
    	mares[marAtivo].remove("Bond", p.getX(), p.getY());
    	if(saida) {
    		mares[marAtivo-1].colocaBond(p, saida);
    	}else {
    		mares[marAtivo+1].colocaBond(p, saida);
    		//erros
    	}
    }
    
    public void entra(int x, int y, int z, Bond b) {
    	mares[z].entra(x, y, b);
    }
    
    public void remove(String nome, int x, int y) {
		mares[marAtivo].remove(nome, x, y);
    }
}
