package pt.labfinal;
import java.awt.*;
import javax.swing.*;

public class GUIOficinaPanel extends JPanel{

	private static final long serialVersionUID = 8L;
	static final int SCREEN_WIDTH = 650;
	static final int SCREEN_HEIGHT = 650;
	private Oficina oficina;
	private Bond bond;
	
	
	GUIOficinaPanel(Oficina oficina){
		this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
		this.setBackground(Color.white);
		this.setFocusable(true);
		this.oficina = oficina;
		bond = Bond.getInstance();
	}
	
	public void draw(Graphics g) {
		
		int i = 30;
		
		g.drawString("Bem vindo! O que gostaria hoje?", 250, i);
		i += 50;
		g.drawString("Aperte 1 para consertar seu barco:", 200, i);
		i += 50;
		g.drawString("Conserto: Recupere " + oficina.getCura() + " de vida por " + oficina.getPrecoCura(), 200, i);
		i += 50;
		g.drawString("Aperte 2 para aprimorar seu barco", 200, i);
		i += 50;
		g.drawString("Aprimoramento: melhore sua vida em " + oficina.getMelhoria() + " por " + oficina.getPrecoMelhoria(), 200, i);
		i += 50;
		g.drawString("Seu dinheiro: " + bond.getDinheiro(), 300, i);
		i += 100;
		g.drawString("Aperte m para sair", 200, i);
		i += 50; 
		
	}
	
		
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	
		
}