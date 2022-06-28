package pt.labfinal.model.mapa.componente;

import pt.labfinal.model.item.arma.Arma;
import pt.labfinal.model.item.vara.Vara;
import pt.labfinal.model.mapa.Mapa;

public class Bond extends Individuo{
	
	private static final Bond instance = new Bond ();
	private Inventario mala = new Inventario();
	private boolean ganhou = false;
	private boolean perdeu = false;
	
	private Bond(){
		super("Bond", 0, 0, 0, 500, "/assets/bond.png");
		mala.addArma(new Arma("pistola silenciada", 100, 100, 100, "/assets/silenced.png"));
		mala.addVara(new Vara("Vara de pesca desgastada", 100, 100, "/assets/vara1.png"));
	}
	
    public static Bond getInstance(){
        return instance;
    }
    
    public Inventario getInventario() {
    	return mala;
    }
    
    public void ganhouJogo() {
    	ganhou = true;
    }
    
    public void perdeuJogo() {
    	perdeu = true;
    }
    
    public boolean verificaGanhou() {
    	return ganhou;
    }
    
    public boolean verificaPerdeu() {
    	return perdeu;
    }
    
    public int getDinheiro() {
    	return mala.getDinheiro();
    }
    
    public void gastaDinheiro(int gasto) {
    	mala.addDinheiro((-1)*gasto);
    }
   
	public void melhoraHP(int aumento) {
		hpAtual += aumento;
		hpMax += aumento;
	}
	
	public void adicionaArma(Arma novo) {
		mala.addArma(novo);
	}
	public void adicionaVara(Vara novo) {
		mala.addVara(novo);
	}
	
	public void pescar(Mapa mapa) {
		mala.addPeixe(mala.getVara(0).pescar(mapa));
	}
	
	public Arma getArmaAtiva() {
		return mala.getArma(0);
	}
	
	public Vara getVaraAtiva() {
		return mala.getVara(0);
	}
	
	public void atirar(Mapa mapa, String movimento) {
		mala.getArma(0).atirar(mapa, movimento, x, y);
	}
	
	
	public void entra(Mapa mapa) {
		mapa.entra(x, y, z, this);
	}	
	
	public void adicionaMunicao() {
		mala.adicionaMunicao();
		return;
	}
	
}
