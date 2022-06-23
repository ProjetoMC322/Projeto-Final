package pt.labfinal;

public class Montador {
	private Mapa mapa;
	Montador(){
		mapa = Mapa.getInstance();
	}
	
	public void montaMapa(String arquivoComponentes[][], String arquivoItens[][]) {
		Mar novo = new Mar(arquivoItens[0][0], arquivoItens[0][1]);
		for(int i = 0; i<arquivoItens.length; i++) {
			if(arquivoItens[i].length == 2) {
				novo = new Mar(arquivoItens[i][0], arquivoItens[i][1]);
			}else if(arquivoComponentes[i][0].equals("A")){
				novo.adicionaArma(new Arma(arquivoItens[i][1], Integer.parseInt(arquivoItens[i][2]),
						Integer.parseInt(arquivoComponentes[i][3]) , Integer.parseInt(arquivoComponentes[i][4]),
						arquivoItens[i][5]));
			}else if(arquivoComponentes[i][0].equals("V")){
				novo.adicionaVara(new Vara(arquivoItens[i][1], Integer.parseInt(arquivoItens[i][2]),
						Integer.parseInt(arquivoComponentes[i][3]), arquivoItens[i][4]));
	
			}else if(arquivoComponentes[i][0].equals("P")){
				novo.adicionaPeixe(new Peixe(arquivoItens[i][2], Integer.parseInt(arquivoItens[i][3]),
						arquivoItens[i][4]), Integer.parseInt(arquivoItens[i][1]));
			}
		}
		
		for(int i = 0; i<arquivoComponentes.length; i++) {
			if(arquivoComponentes[i][0].equals("B")) {
				Bond b = Bond.getInstance();
				b.setX(Integer.parseInt(arquivoComponentes[i][2]));
				b.setY(Integer.parseInt(arquivoComponentes[i][3]));
				b.setZ(Integer.parseInt(arquivoComponentes[i][4]));
				mapa.conecta(b);
			}else if(arquivoComponentes[i][0].equals("I")) {
				mapa.conecta(new Inimigo(arquivoComponentes[i][1], Integer.parseInt(arquivoComponentes[i][2]), 
						Integer.parseInt(arquivoComponentes[i][3]), Integer.parseInt(arquivoComponentes[i][4]),
						Integer.parseInt(arquivoComponentes[i][5]), Integer.parseInt(arquivoComponentes[i][6]),
						arquivoComponentes[i][7]));
			}else if(arquivoComponentes[i][0].equals("IG")) {
				mapa.conectaGodzilla(new Inimigo(arquivoComponentes[i][1], Integer.parseInt(arquivoComponentes[i][2]), 
						Integer.parseInt(arquivoComponentes[i][3]), Integer.parseInt(arquivoComponentes[i][4]),
						Integer.parseInt(arquivoComponentes[i][5]), Integer.parseInt(arquivoComponentes[i][6]),
						arquivoComponentes[i][7]));
						
			}else if(arquivoComponentes[i][0].equals("M")) {
				mapa.conecta(new Mercado("mercado", Integer.parseInt(arquivoComponentes[i][1]),
						Integer.parseInt(arquivoComponentes[i][2]), Integer.parseInt(arquivoComponentes[i][3]),
						Integer.parseInt(arquivoComponentes[i][4]), arquivoComponentes[i][5]));
			}else if(arquivoComponentes[i][0].equals("C")) {
				mapa.conecta(new Corrente(arquivoComponentes[i][1], Integer.parseInt(arquivoComponentes[i][2]),
						Integer.parseInt(arquivoComponentes[i][3]), Integer.parseInt(arquivoComponentes[i][4]),
						arquivoComponentes[i][5]));
			}else if(arquivoComponentes[i][0].equals("O")) {
				mapa.conecta(new Oficina("oficina", Integer.parseInt(arquivoComponentes[i][1]),
						Integer.parseInt(arquivoComponentes[i][2]), Integer.parseInt(arquivoComponentes[i][3]),
						Integer.parseInt(arquivoComponentes[i][4]), Integer.parseInt(arquivoComponentes[i][5]),
						Integer.parseInt(arquivoComponentes[i][6]), Integer.parseInt(arquivoComponentes[i][7]),
						arquivoComponentes[i][8]));
			}
		}
	}
}
