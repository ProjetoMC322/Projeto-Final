package pt.labfinal.model.mapa.componente.inimigo;

public class Tanque extends Inimigo{
	private boolean escudo;
	Tanque(String nome, int x, int y, int z, int hp, int dano, String imagem){
		super(nome, x, y, z, hp, dano, imagem);
		this.escudo = true;
	}
	
	public void alteraHP(int mudanca) {
		if(escudo) {
			escudo = false;
		}else {
			hpAtual += mudanca;
		}
	}
}

