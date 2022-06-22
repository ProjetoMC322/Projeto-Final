package pt.labfinal;

import java.util.Scanner;

public class Oficina implements Componente{
	private String nome;
	private int x, y, z, cura, precoCura, melhoria, precoMelhoria;
	//imagem
	Oficina(String nome, int x, int y, int z, int cura, int precoCura, int melhoria, int precoMelhoria){
		this.nome = nome;
		this.x = x;
		this.y = y;
		this.z = z;
		this.cura = cura;
		this.precoCura = precoCura;
		this.melhoria = melhoria;
		this.precoMelhoria = precoMelhoria;
	}
	
	public int getX() {
		return x;
	};
	
	public int getY() {
		return y;
	};
	public int getZ() {
		return z;
	};
	public void setX(int novo) {
		this.x = novo;
	};
	public void setY(int novo) {
		this.y = novo;
	}
	public void setZ(int novo) {
		this.z = novo;
	};
	
	public String getNome() {
		return nome;
	}
	
	public void andar(String movimento, Mapa mapa) {
		return;
	}
	
	public void atirar(){
		return;
	}
	
	public void alteraHP(int novo) {
		return;
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
