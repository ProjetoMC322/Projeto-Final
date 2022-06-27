package pt.labfinal;
import java.awt.*;
import javax.swing.*;

public class GUIMercadoPanel extends JPanel{

	private static final long serialVersionUID = 7L;
	static final int SCREEN_WIDTH = 650;
	static final int SCREEN_HEIGHT = 650;
	private Inventario inventario;
	private Mercado mercado;
	private int mode;
	
	
	GUIMercadoPanel(Inventario inventario, Mercado mercado, int mode){
		this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
		this.setBackground(Color.white);
		this.setFocusable(true);
		this.inventario = inventario;
		this.mercado = mercado;
		this.mode = mode;
	}
	
	public void draw(Graphics g) {
		
		int i = 30, aux = 0;
		if(mode == 0) {
			g.drawString("Bem vindo! O que gostaria hoje?", 250, i);
			i += 50;
			g.drawString("Aperte 1 para comprar armas", 200, i);
			i += 50;
			g.drawString("Aperte 2 para comprar varas", 200, i);
			i += 50;
			g.drawString("Aperte 3 para vender peixes", 200, i);
			i += 50;
			g.drawString("Aperte 4 para comprar municao", 200, i);
			i += 50;
			g.drawString("Aperte m para sair", 200, i);
			i += 50;
			g.drawString("Seu dinheiro: " + inventario.getDinheiro(), 300, i);
			i += 100;
		}else if(mode == 1) {
			Arma armas[] = mercado.getArmas();
			while(armas[aux] != null) {
				g.drawString("Aperte " + aux + " para comprar: " + armas[aux].getNome() + " com dano: " + armas[aux].getDano() + " e municao maxima de: "
						+ armas[aux].getMunicaoMax() + " pelo preco de: " + armas[aux].getPreco(), 30, i);
				
				i += 20;
				g.drawImage(new ImageIcon(armas[aux].getImage()).getImage(), 60,  i, null);
				i += 70;
				aux++;
			}
			g.drawString("Aperte m para sair", 200, i);
			i += 50;
		}else if(mode == 2) {
			Vara varas[] = mercado.getVaras();
			while(varas[aux] != null) {
				g.drawString("Aperte " + aux + " para comprar: " + varas[aux].getNome() + " com durabilidade: "
						+ varas[aux].getDurabilidadeMax() + " pelo preco de: " + varas[aux].getPreco(), 30, i);
				
				i += 20;
				g.drawImage(new ImageIcon(varas[aux].getImage()).getImage(), 60,  i, null);
				i += 70;
				aux++;
			}
			g.drawString("Aperte m para sair", 200, i);
			i += 50;
		}else if(mode == 3) {
			Peixe peixes[] = inventario.getPeixes();
			while(peixes[aux] != null && aux < 6) {
				g.drawString("Aperte " + aux + "para vender: " + peixes[aux].getNome() + " pelo preco de "
						+ peixes[aux].getPreco() , 30, i);
				
				i += 20;
				g.drawImage(new ImageIcon(peixes[aux].getImage()).getImage(), 60,  i, null);
				i += 70;
				aux++;
			}
			g.drawString("Aperte m para sair", 200, i);
			i += 50; 
		}
	}
	
		
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	
		
}