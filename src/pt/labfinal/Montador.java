package pt.labfinal;

public class Montador {
	private Mapa mapa;
	Mar novo[] = new Mar[6];
	Montador(){
		mapa = Mapa.getInstance();
	}
	
	public void montaMapa(String arquivoComponentes[][], String arquivoItens[][]) {
		int aux = 0;
		novo[aux] = new Mar(arquivoItens[0][0], arquivoItens[0][1]);
		for(int i = 0; i<arquivoItens.length; i++) {
			if(arquivoItens[i].length == 2 && i>0) {
			
				
				mapa.adicionaMar(novo[aux]);
				aux++;
				novo[aux] = new Mar(arquivoItens[i][0], arquivoItens[i][1]);
				
			}else if(arquivoItens[i][0].equals("A")){
				novo[aux].adicionaArma(new Arma(arquivoItens[i][1], Integer.parseInt(arquivoItens[i][2]),
						Integer.parseInt(arquivoItens[i][3]) , Integer.parseInt(arquivoItens[i][4]),
						arquivoItens[i][5]));
			}else if(arquivoItens[i][0].equals("AC")){
				novo[aux].adicionaArma(new ArmaCanhao(arquivoItens[i][1], Integer.parseInt(arquivoItens[i][2]),
						Integer.parseInt(arquivoItens[i][3]) , Integer.parseInt(arquivoItens[i][4]),
						arquivoItens[i][5]));
			}else if(arquivoItens[i][0].equals("AE")){
				novo[aux].adicionaArma(new ArmaEscopeta(arquivoItens[i][1], Integer.parseInt(arquivoItens[i][2]),
						Integer.parseInt(arquivoItens[i][3]) , Integer.parseInt(arquivoItens[i][4]),
						arquivoItens[i][5]));
			}else if(arquivoItens[i][0].equals("AP")){
				novo[aux].adicionaArma(new ArmaRPG(arquivoItens[i][1], Integer.parseInt(arquivoItens[i][2]),
						Integer.parseInt(arquivoItens[i][3]) , Integer.parseInt(arquivoItens[i][4]),
						arquivoItens[i][5]));
			}else if(arquivoItens[i][0].equals("AR")){
				novo[aux].adicionaArma(new ArmaRajada(arquivoItens[i][1], Integer.parseInt(arquivoItens[i][2]),
						Integer.parseInt(arquivoItens[i][3]) , Integer.parseInt(arquivoItens[i][4]),
						arquivoItens[i][5], Integer.parseInt(arquivoItens[i][6])));
			}else if(arquivoItens[i][0].equals("V")){
				novo[aux].adicionaVara(new Vara(arquivoItens[i][1], Integer.parseInt(arquivoItens[i][2]),
						Integer.parseInt(arquivoItens[i][3]), arquivoItens[i][4]));
	
			}else if(arquivoItens[i][0].equals("VS")){
				novo[aux].adicionaVara(new VaraSorte(arquivoItens[i][1], Integer.parseInt(arquivoItens[i][2]),
						Integer.parseInt(arquivoItens[i][3]), arquivoItens[i][4],
						Integer.parseInt(arquivoItens[i][5])));
	
			}else if(arquivoItens[i][0].equals("P")){
				novo[aux].adicionaPeixe(new Peixe(arquivoItens[i][2], Integer.parseInt(arquivoItens[i][3]),
						arquivoItens[i][4]), Integer.parseInt(arquivoItens[i][1]));
			}
		}
		mapa.adicionaMar(novo[aux]);
		
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
