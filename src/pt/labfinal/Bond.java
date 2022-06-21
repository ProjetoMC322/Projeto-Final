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
	}
	public void alteraHP(int mudanca) {
		hpAtual += mudanca;
	}
	public void melhoraHP(int aumento) {
		hpAtual += aumento;
		hpMax += aumento;
	}
    public int getHP() {
		return hpAtual;
	}
	public int getHPMax() {
		return hpMax;
	}
    public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getZ() {
		return z;
	}
	public void setX(int novo) {
		this.x = novo;
	}
	public void setY(int novo) {
		this.y = novo;
	}
	public void setZ(int novo) {
		this.z = novo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void pescar(Mapa mapa) {
		mala.addPeixe(mala.getVara(0).pescar(mapa));
	}
	
	public void atirar(Mapa mapa, String movimento) {
		mala.getArma(0).atirar(mapa, movimento, x, y);
	}
	
	public void equipar() {
		mala.menus();
	}
	
	public void andar(String movimento, Mapa mapa) {
		if (movimento.equalsIgnoreCase("w")) {
			mapa.moveBond(this.x, this.y, this.x - 1, this.y, this);
			if(this.x > 0) {
				this.x--;
			}
		}else if (movimento.equalsIgnoreCase("a")) {
			mapa.moveBond(this.x, this.y, this.x, this.y -1, this);
			if(this.y > 0) {
				this.y--;
			}
		}else if (movimento.equalsIgnoreCase("s")) {
			mapa.moveBond(this.x, this.y, this.x + 1, this.y, this);
			if(this.x < 9) {
				this.x++;
			}
		}else if (movimento.equalsIgnoreCase("d")) {
			mapa.moveBond(this.x, this.y, this.x, this.y + 1, this);
			if(this.y < 9) {
				this.y++;
			}
		}else if (movimento.equalsIgnoreCase("z")) {
			mapa.sobeBond(false, this);
			if(this.z < 5) {
				this.z++;
			}
		}else if (movimento.equalsIgnoreCase("x")) {
			mapa.sobeBond(true, this);
			if(this.z > 0) {
				this.z--;
			}
		}
	}
	
}
