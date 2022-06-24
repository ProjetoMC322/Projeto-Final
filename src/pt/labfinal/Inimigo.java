package pt.labfinal;

public class Inimigo extends Individuo{
	protected int dano;
	
	Inimigo(String nome, int x, int y, int z, int hp, int dano, String imagem){
		super(nome, x, y, z, hp, imagem);
		this.dano = dano;
	}
	
	public void danifica(Bond bond) {
		bond.alteraHP((-1)*dano);
	}
}