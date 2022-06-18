package pt.labfinal;

public class Mapa {

	private static final Mapa instance = new Mapa ();
	private Mar mares[] =  new Mar[6];
	private int marAtivo = 0;
	
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
    
    public Peixe pescar() {
    	return mares[marAtivo].pescar();
    }
    
    public boolean checarInimigo(int x, int y) {
    	return mares[marAtivo].checarInimigo(x, y);
    }
    
    public void causarDano(int x, int y, int dano) {
    	mares[marAtivo].causarDano(x, y, dano);
    }
}
