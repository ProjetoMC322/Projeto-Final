package pt.labfinal;
import java.util.Scanner;


public class Controle {
	Bond bond;
	Mapa mapa;
		
	
	Controle(){
		this.bond = Bond.getInstance();
		this.mapa = Mapa.getInstance();
	}
	
	public void leComandos(String comandos) {
		for(int i = 0; i < comandos.length(); i++) {
			if (bond.getHP() > 0) {
				if (comandos.substring(i, i+1).equalsIgnoreCase("w") ||
					comandos.substring(i, i+1).equalsIgnoreCase("a") ||	
					comandos.substring(i, i+1).equalsIgnoreCase("s") ||
					comandos.substring(i, i+1).equalsIgnoreCase("d") ) {
						bond.andar(mapa, comandos.substring(i, i + 1)); 
				}
				else if (comandos.substring(i, i+1).equalsIgnoreCase("i") ||
						comandos.substring(i, i+1).equalsIgnoreCase("j") ||	
						comandos.substring(i, i+1).equalsIgnoreCase("k") ||
						comandos.substring(i, i+1).equalsIgnoreCase("l")) {
							bond.atirar(mapa, comandos.substring(i, i+1));
				}
				else if (comandos.substring(i, i+1).equalsIgnoreCase("p")) {
					bond.pescar(mapa);
				}
				else if (comandos.substring(i, i+1).equalsIgnoreCase("u")) {
					//inventario
				}
				else if (comandos.substring(i, i+1).equalsIgnoreCase("m")) {
					//entra no mercado/oficina 
				}else if (comandos.substring(i, i+1).equalsIgnoreCase("1")) {
					//sethp -1
					//break
				} 
				else {
					System.out.println("Tecla invalida!");
				}
				
			}else{
				break;
				//perdeu playboy
			}
		}
	}
	
	public void leTeclado() {
		Scanner keyboard = new Scanner(System.in);
		String command = keyboard.nextLine();
		leComandos(command);
		keyboard.close();
	
	}
}
