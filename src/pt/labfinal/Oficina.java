package pt.labfinal;

import java.util.Scanner;

public class Oficina extends Componente{
	private int cura, precoCura, melhoria, precoMelhoria;
	//imagem
	Oficina(String nome, int x, int y, int z, int cura, int precoCura, int melhoria, int precoMelhoria, String imagem){
		super(nome, x, y, z, imagem);
		this.cura = cura;
		this.precoCura = precoCura;
		this.melhoria = melhoria;
		this.precoMelhoria = precoMelhoria;
	}
	
	public void entra(Bond b) {
		String comando = leTeclado();
		if(comando.equalsIgnoreCase("m")) {
			return;
		}
		if(comando.equalsIgnoreCase("1")) {
			if(b.getDinheiro() > precoCura) {
				b.alteraHP(cura);
				b.gastaDinheiro(precoCura);
				entra(b);
			}else {
				//te falta grana
				entra(b);
			}
			entra(b);
		}else if(comando.equalsIgnoreCase("2")) {
			if(b.getDinheiro() > precoMelhoria) {
				b.melhoraHP(melhoria);
				b.gastaDinheiro(precoMelhoria);
				entra(b);
			}else {
				//te falta grana
				entra(b);
			}
			entra(b);
		}else {
			entra(b);
			//manda que o mano ta arrastando
		}
	}
	
	public String leTeclado() {
		Scanner keyboard = new Scanner(System.in);
		String command = keyboard.nextLine();
		keyboard.close();
		return command;
	}
}
