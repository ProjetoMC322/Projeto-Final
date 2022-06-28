package pt.labfinal.model.mapa.componente;

public class Oficina extends Componente{
	private int cura, precoCura, melhoria, precoMelhoria;
	//imagem
	public Oficina(String nome, int x, int y, int z, int cura, int precoCura, int melhoria, int precoMelhoria, String imagem){
		super(nome, x, y, z, imagem);
		this.cura = cura;
		this.precoCura = precoCura;
		this.melhoria = melhoria;
		this.precoMelhoria = precoMelhoria;
	}
	
	public int getCura() {
		return cura;
	}
	
	public int getMelhoria() {
		return melhoria;
	}
	
	public int getPrecoCura() {
		return precoCura;
	}
	
	public int getPrecoMelhoria() {
		return precoMelhoria;
	}
	
	public void cura(Bond b) {
		if(b.getDinheiro() > precoCura) {
			b.alteraHP(cura);
			b.gastaDinheiro(precoCura);
			precoCura = precoCura*3;
		}
	}
	
	public void melhora(Bond b) {
		if(b.getDinheiro() > precoMelhoria) {
			b.gastaDinheiro(precoMelhoria);
			b.melhoraHP(melhoria);
			precoMelhoria = precoMelhoria*3;
		}
	}	

}
