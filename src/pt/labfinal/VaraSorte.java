package pt.labfinal;

public class VaraSorte extends Vara{
	private int bonus;
	
	VaraSorte(String nome, int preco, int durabilidade, String imagem, int bonus){
		super(nome, preco, durabilidade, imagem);
		this.bonus = bonus;
	}
	
	public Peixe pescar(Mapa mapa) {
		if(durabilidadeAtual<1) {
			//erro arma sem durabilidade
			return null;
		}else {
			durabilidadeAtual--;
			return mapa.pescar(bonus);
		}
	}
}
