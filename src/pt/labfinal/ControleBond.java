package pt.labfinal;

public class ControleBond implements Controle{
	private static final ControleBond instance = new ControleBond();
	private Bond bond;
	private Mapa mapa;
	private Resposta resposta;
	private Leitor leitor;

	
	ControleBond(){
	}
	
	public static ControleBond getInstance() {
		return instance;
	}
	
	public void iniciaControle() {
		this.bond = Bond.getInstance();
		this.resposta = Resposta.getInstance();
		this.mapa = Mapa.getInstance();
		this.leitor = Leitor.getInstance();
		
	}
	
	public boolean interpreta(String comandos) {
		
		for(int i = 0; i < comandos.length(); i++) {
			if (!(bond.verificaGanhou() || bond.verificaPerdeu())) {
				if (comandos.substring(i, i+1).equalsIgnoreCase("w") ||
					comandos.substring(i, i+1).equalsIgnoreCase("a") ||	
					comandos.substring(i, i+1).equalsIgnoreCase("s") ||
					comandos.substring(i, i+1).equalsIgnoreCase("d") ) {
						bond.andar(comandos.substring(i, i + 1), mapa); 
						return true;
				}
				else if (comandos.substring(i, i+1).equalsIgnoreCase("i") ||
						comandos.substring(i, i+1).equalsIgnoreCase("j") ||	
						comandos.substring(i, i+1).equalsIgnoreCase("k") ||
						comandos.substring(i, i+1).equalsIgnoreCase("l")) {
							bond.atirar(mapa, comandos.substring(i, i+1));
							return true;
				}
				else if (comandos.substring(i, i+1).equalsIgnoreCase("p")) {
					
					bond.pescar(mapa);
					return true;
				}
				else if (comandos.substring(i, i+1).equalsIgnoreCase("u")) {
					leitor.desconectaControle();
					leitor.conectaControle(new ControleInventario(bond.getInventario()));
					return true;
				}
				else if (comandos.substring(i, i+1).equalsIgnoreCase("m")) {
					Mercado mercado = mapa.achaMercado(bond.getX(), bond.getY(), bond.getZ());
					Oficina oficina = mapa.achaOficina(bond.getX(), bond.getY(), bond.getZ());
					if(mercado == null) {
						if(oficina == null) {
							return true;
						}
						leitor.desconectaControle();
						leitor.conectaControle(new ControleOficina(bond.getInventario(), oficina));
						return true;
					}
					leitor.desconectaControle();
					leitor.conectaControle(new ControleMercado(bond.getInventario(), mercado));
					return true;
				}else if (comandos.substring(i, i+1).equalsIgnoreCase("q")) {
					//sethp -1
					//break
					return false;
				} 
				else {
					System.out.println("Tecla invalida!");
				}
				resposta.tick();
			}else{
				return false;
				
				//perdeu (ou ganhou) playboy
			}
		}
		return true;
	}

}
