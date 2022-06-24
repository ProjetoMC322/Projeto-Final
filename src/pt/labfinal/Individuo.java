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
			if(mapa.moveIndividuo(this.x, this.y, this.x - 1, this.y, this)) {
				this.x--;
			};
			
		}else if (movimento.equalsIgnoreCase("a")) {
			if(mapa.moveIndividuo(this.x, this.y, this.x, this.y -1, this)) {
				this.y--;
			}
			
		}else if (movimento.equalsIgnoreCase("s")) {
			if(mapa.moveIndividuo(this.x, this.y, this.x + 1, this.y, this)) {
				this.x++;
			}
			
		}else if (movimento.equalsIgnoreCase("d")) {
			if(mapa.moveIndividuo(this.x, this.y, this.x, this.y + 1, this)) {
				this.y++;
			}
			
		}else if (movimento.equalsIgnoreCase("z")) {
			if(mapa.sobeIndividuo(true, this)) {
				this.z++;
			}
			
		}else if (movimento.equalsIgnoreCase("x")) {
			if(mapa.sobeIndividuo(false, this)) {
				this.z--;
			}
			
		}
	}
}
