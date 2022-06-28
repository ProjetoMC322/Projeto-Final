package pt.labfinal.view;
import java.awt.*;
import javax.swing.*;

import pt.labfinal.model.mapa.Mapa;

public class GUIMarPanel extends JPanel{

	private static final long serialVersionUID = 6L;
	private int SCREEN_WIDTH = 650;
	private int SCREEN_HEIGHT = 650;
	private int UNIT_SIZE = 65;
	private Mapa mapa = Mapa.getInstance();
	
	public GUIMarPanel(){
		
		this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
		this.setBackground(Color.getHSBColor(mapa.pegaCorH(), mapa.pegaCorS(), mapa.pegaCorB()));
		this.setFocusable(true);
		
	}
	
	public void draw(Graphics g) {
		this.setBackground(Color.getHSBColor(mapa.pegaCorH(), mapa.pegaCorS(), mapa.pegaCorB()));
		
		for(int i=0;i<(SCREEN_HEIGHT/UNIT_SIZE)+1;i++) {
			g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
			g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
		}
		for(int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				g.drawImage(new ImageIcon(mapa.mostraImagem(i, j)).getImage(), j*UNIT_SIZE,  i*UNIT_SIZE, null);
						
			}
		}
	}
	
		
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	
		
}

