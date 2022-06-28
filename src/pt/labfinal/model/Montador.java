package pt.labfinal.model;

import pt.labfinal.model.item.Peixe;
import pt.labfinal.model.item.arma.Arma;
import pt.labfinal.model.item.arma.ArmaCanhao;
import pt.labfinal.model.item.arma.ArmaEscopeta;
import pt.labfinal.model.item.arma.ArmaRPG;
import pt.labfinal.model.item.arma.ArmaRajada;
import pt.labfinal.model.item.vara.Vara;
import pt.labfinal.model.item.vara.VaraSorte;
import pt.labfinal.model.mapa.Mapa;
import pt.labfinal.model.mapa.Mar;
import pt.labfinal.model.mapa.componente.Bond;
import pt.labfinal.model.mapa.componente.Corrente;
import pt.labfinal.model.mapa.componente.Mercado;
import pt.labfinal.model.mapa.componente.Oficina;
import pt.labfinal.model.mapa.componente.inimigo.Inimigo;

public class Montador {
	private Mapa mapa;
	Mar novo[] = new Mar[6];
	public Montador(){
		mapa = Mapa.getInstance();
	}
	
	public void montaMapa(String arquivoComponentes[][], String arquivoItens[][]) {
		int aux = 0;
		novo[aux] = new Mar(arquivoItens[0][0], "no-link", (Float.parseFloat(arquivoItens[0][1])/240),
				(Float.parseFloat(arquivoItens[0][2])/240), (Float.parseFloat(arquivoItens[0][3])/240));
		for(int i = 0; i<arquivoItens.length; i++) {
			if(arquivoItens[i].length == 4 && i>0) {
			
				
				mapa.adicionaMar(novo[aux]);
				aux++;
				novo[aux] = new Mar(arquivoItens[i][0], "no-link", (Float.parseFloat(arquivoItens[i][1])/240),
						(Float.parseFloat(arquivoItens[i][2])/240),(Float.parseFloat(arquivoItens[i][3])/240));
				
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
