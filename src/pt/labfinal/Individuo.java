package pt.labfinal;

public class Individuo extends Componente{
	protected int hpAtual, hpMax;
	
	Individuo(String nome, int x, int y, int z, int hp, String imagem){
		super(nome, x, y, z, imagem);
		this.hpAtual = hp;
		this.hpMax = hp;
	}
	
	public int getHP() {
		return hpAtual;
	}
	
	public int getHPMax() {
		return hpMax;
	}
	
	public void alteraHP(int valor) {
		hpAtual += valor;
	}
	
	public void andar(String movimento, Mapa mapa) {
		if (movimento.equalsIgnoreCase("w")) {
			mapa.moveIndividuo(this.x, this.y, this.x - 1, this.y, this);
			if(this.x > 0) {
				this.x--;
			}
		}else if (movimento.equalsIgnoreCase("a")) {
			mapa.moveIndividuo(this.x, this.y, this.x, this.y -1, this);
			if(this.y > 0) {
				this.y--;
			}
		}else if (movimento.equalsIgnoreCase("s")) {
			mapa.moveIndividuo(this.x, this.y, this.x + 1, this.y, this);
			if(this.x < 9) {
				this.x++;
			}
		}else if (movimento.equalsIgnoreCase("d")) {
			mapa.moveIndividuo(this.x, this.y, this.x, this.y + 1, this);
			if(this.y < 9) {
				this.y++;
			}
		}else if (movimento.equalsIgnoreCase("z")) {
			mapa.sobeIndividuo(false, this);
			if(this.z < 5) {
				this.z++;
			}
		}else if (movimento.equalsIgnoreCase("x")) {
			mapa.sobeIndividuo(true, this);
			if(this.z > 0) {
				this.z--;
			}
		}
	}
}
