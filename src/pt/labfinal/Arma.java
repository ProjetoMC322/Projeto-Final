package pt.labfinal;

public class Arma implements Item{
	private String nome;
	private int preco;
	private int municaoMax;
	private int municaoAtual;
	private int dano;
	
	//imagem
	Arma(String nome, int preco, int municao, int dano){
		this.nome = nome;
		this.preco = preco;
		this.municaoAtual = municao;
		this.municaoMax = municao;
		this.dano = dano;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getPreco() {
		return preco;
	}
	
	public int getMunicaoMax() {
		return municaoMax;
	}
	
	public int getMunicaoAtual() {
		return municaoAtual;
	}
	
	public void atirar(Mapa mapa, String movimento, int x, int y) {
		if(municaoAtual < 1) {
			//erro
			return;
		}
		if (movimento.equalsIgnoreCase("i")) {
			while(x>0) {
				if(mapa.checarInimigo(x-1, y){
					mapa.causarDano(x-1, y, dano);
					municaoAtual--;
					return;
				}
				x--;
			}
			municaoAtual--;
			return;
		}
	}
}
