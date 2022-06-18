package pt.labfinal;

public class Montador {
	private Mapa mapa;
	Montador(){
		mapa = Mapa.getInstance();
	}
	
	public void montaMapa(String arquivo[][]) {
		for(int i = 0; i<arquivo.length; i++) {
			if(arquivo[i][0].equals("B")) {
				Bond b = Bond.getInstance();
				b.setX(Integer.parseInt(arquivo[i][2]));
				b.setY(Integer.parseInt(arquivo[i][3]));
				b.setZ(Integer.parseInt(arquivo[i][4]));
				mapa.conecta(b);
			}else if(arquivo[i][0].equals("I")) {
				//lógica inimigo
				mapa.conecta();
			}else if(arquivo[i][0].equals("M")) {
				mapa.conecta(new Mercado(arquivo[i][1], Integer.parseInt(arquivo[i][2]),
						Integer.parseInt(arquivo[i][3]), Integer.parseInt(arquivo[i][4])));
			}else if(arquivo[i][0].equals("C")) {
				mapa.conecta(new Corrente(arquivo[i][1], Integer.parseInt(arquivo[i][2]),
						Integer.parseInt(arquivo[i][3]), Integer.parseInt(arquivo[i][4])));
			}else if(arquivo[i][0].equals("M")) {
				mapa.conecta(new Oficina(arquivo[i][1], Integer.parseInt(arquivo[i][2]),
						Integer.parseInt(arquivo[i][3]), Integer.parseInt(arquivo[i][4])));
			}
		}
	}
}
