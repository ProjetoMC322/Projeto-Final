package pt.labfinal;

public class Oficina extends Componente{
	private int cura, precoCura, melhoria, precoMelhoria;
	//imagem
	Oficina(String nome, int x, int y, int z, int cura, int precoCura, int melhoria, int precoMelhoria, String imagem){
		super(nome, x, y, z, imagem);
		this.cura = cura;
		this.precoCura = precoCura;
		this.melhoria = melhoria;
		this.precoMelhoria = precoMelhoria;
	}
	
	public void cura(Bond b) {
		if(b.getDinheiro() > precoCura) {
			b.alteraHP(cura);
			precoCura = precoCura*3;
		}
	}
	
	public void melhora(Bond b) {
		if(b.getDinheiro() > precoMelhoria) {
			b.melhoraHP(melhoria);
			precoMelhoria = precoMelhoria*3;
		}
	}	

}
