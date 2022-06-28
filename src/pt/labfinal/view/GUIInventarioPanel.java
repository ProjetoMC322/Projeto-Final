package pt.labfinal.view;
import java.awt.*;
import javax.swing.*;

import pt.labfinal.model.item.Peixe;
import pt.labfinal.model.item.arma.Arma;
import pt.labfinal.model.item.vara.Vara;
import pt.labfinal.model.mapa.componente.Inventario;

public class GUIInventarioPanel extends JPanel{

	private static final long serialVersionUID = 9L;
	static final int SCREEN_WIDTH = 650;
	static final int SCREEN_HEIGHT = 650;
	private Inventario inventario;
	private int mode;
	
	
	public GUIInventarioPanel(Inventario inventario, int mode){
		this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
		this.setBackground(Color.gray);
		this.setFocusable(true);
		this.inventario = inventario;
		this.mode = mode;
	}
	
	public void draw(Graphics g) {
		
		int i = 30, aux = 0;
		if(mode == 0) {
			g.drawString("Este eh seu inventario", 250, i);
			i += 50;
			g.drawString("Aperte 1 para equipar armas", 200, i);
			i += 50;
			g.drawString("Aperte 2 para equipar varas", 200, i);
			i += 50;
			g.drawString("Aperte 3 para ver os peixes", 200, i);
			i += 50;
			g.drawString("Aperte m para sair", 200, i);
			i += 50;
			g.drawString("Seu dinheiro: " + inventario.getDinheiro(), 300, i);
			i += 100;
		}else if(mode == 1) {
			Arma armas[] = inventario.getArmas();
			while(armas[aux] != null) {
				g.drawString("Arma " + aux + ": " + armas[aux].getNome() + " com dano: " + armas[aux].getDano() + " e municao maxima de: "
						+ armas[aux].getMunicaoMax() + " com o preco de: " + armas[aux].getPreco(), 30, i);
				
				i += 20;
				g.drawImage(new ImageIcon(armas[aux].getImage()).getImage(), 60,  i, null);
				i += 70;
				aux++;
			}
			g.drawString("Aperte m para sair", 200, i);
			i += 50;
		}else if(mode == 2) {
			Vara varas[] = inventario.getVaras();
			while(varas[aux] != null) {
				g.drawString("Vara " + aux + ": " + varas[aux].getNome() + " com durabilidade: "
						+ varas[aux].getDurabilidadeMax() + " com o preco de: " + varas[aux].getPreco(), 30, i);
				
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
				g.drawString("Peixe" + aux + ": " + peixes[aux].getNome() + " com o preco de "
						+ peixes[aux].getPreco() , 30, i);
				
				i += 20;
				g.drawImage(new ImageIcon(peixes[aux].getImage()).getImage(), 60,  i, null);
				i += 70;
				aux++;
			}
			g.drawString("Aperte qualquer botao para sair", 200, i);
			i += 50; 
		}
	}
	
		
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	
		
}