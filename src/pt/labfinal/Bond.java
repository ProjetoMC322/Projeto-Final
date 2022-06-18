package pt.labfinal;

public class Bond implements Componente{
	
	private static final Bond instance = new Bond ();
	private String nome = "Bond";
	private int x, y, z, hpMax, hpAtual;
	private Inventario mala = new Inventario();
	
	private Bond(){}

    public static Bond getInstance(){
        return instance;
    }
    
    public void setHP(int max) {
    	hpMax = max;
    	hpAtual = max;
	};
	public void alteraHP(int mudanca) {
		hpAtual += mudanca;
	};
	public void melhoraHP(int aumento) {
		hpAtual += aumento;
		hpMax += aumento;
	}
    public int getHP() {
		return hpAtual;
	};
	public int getHPMax() {
		return hpMax;
	};
    public int getX() {
		return x;
	};
	public int getY() {
		return y;
	};
	public int getZ() {
		return z;
	};
	public void setX(int novo) {
		this.x = novo;
	};
	public void setY(int novo) {
		this.y = novo;
	}
	public void setZ(int novo) {
		this.z = novo;
	};
	
	public String getNome() {
		return nome;
	}
	
	public void pescar(Mapa mapa) {
		mala.addPeixe(mala.getVara(0).pescar(mapa));
	}
	
	public void atirar(Mapa mapa, String movimento) {
		mala.getArma(0).atirar(mapa, movimento, x, y);
	}
	
}
