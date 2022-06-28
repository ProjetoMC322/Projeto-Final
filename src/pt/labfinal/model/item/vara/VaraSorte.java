package pt.labfinal.model.item.vara;

import pt.labfinal.model.item.Peixe;
import pt.labfinal.model.mapa.Mapa;

public class VaraSorte extends Vara{
	private int bonus;
	
	public VaraSorte(String nome, int preco, int durabilidade, String imagem, int bonus){
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
