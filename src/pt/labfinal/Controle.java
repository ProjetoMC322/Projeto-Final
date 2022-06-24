package pt.labfinal;
import java.util.Scanner;


public class Controle {
	Bond bond;
	Mapa mapa;
	Resposta resposta;

	
	Controle(){
		this.bond = Bond.getInstance();
		this.resposta = Resposta.getInstance();
		this.mapa = Mapa.getInstance();
		bond.adicionaArma(new Arma("nome", 100, 100, 100, "image"));
		bond.adicionaVara(new Vara("nome", 100, 100, "image"));
	}
	
	public void leComandos(String comandos) {
		
		for(int i = 0; i < comandos.length(); i++) {
			if (!(bond.verificaGanhou() || bond.verificaPerdeu())) {
				System.out.println("cmaadna 0");
				if (comandos.substring(i, i+1).equalsIgnoreCase("w") ||
					comandos.substring(i, i+1).equalsIgnoreCase("a") ||	
					comandos.substring(i, i+1).equalsIgnoreCase("s") ||
					comandos.substring(i, i+1).equalsIgnoreCase("d") ) {
						bond.andar(comandos.substring(i, i + 1), mapa); 
				}
				else if (comandos.substring(i, i+1).equalsIgnoreCase("i") ||
						comandos.substring(i, i+1).equalsIgnoreCase("j") ||	
						comandos.substring(i, i+1).equalsIgnoreCase("k") ||
						comandos.substring(i, i+1).equalsIgnoreCase("l")) {
							bond.atirar(mapa, comandos.substring(i, i+1));
				}
				else if (comandos.substring(i, i+1).equalsIgnoreCase("p")) {
					System.out.println("camada1");
					bond.pescar(mapa);
				}
				else if (comandos.substring(i, i+1).equalsIgnoreCase("u")) {
					bond.equipar();
				}
				else if (comandos.substring(i, i+1).equalsIgnoreCase("m")) {
					bond.entra(mapa);
				}else if (comandos.substring(i, i+1).equalsIgnoreCase("1")) {
					//sethp -1
					//break
				} 
				else {
					System.out.println("Tecla invalida!");
				}
				resposta.tick();
			}else{
				break;
				//perdeu (ou ganhou) playboy
			}
		}
		leTeclado();
	}
	
	public void leTeclado() {
		Scanner keyboard = new Scanner(System.in);
		String command = keyboard.nextLine();
		System.out.println(command);
		leComandos(command);
		keyboard.close();
	
	}
}
