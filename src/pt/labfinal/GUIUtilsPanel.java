package pt.labfinal;
import java.awt.*;
import javax.swing.*;

public class GUIUtilsPanel extends JPanel{

	private static final long serialVersionUID = 7L;
	static final int SCREEN_WIDTH = 650;
	static final int SCREEN_HEIGHT = 650;
	private Resposta resposta;
	private Inimigo inimigos[];
	public static Peixe ultimaPescaria;
	private Bond bond;
	
	
	GUIUtilsPanel(){
		this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
		this.setBackground(Color.white);
		this.setFocusable(true);
		resposta = Resposta.getInstance();
		bond = Bond.getInstance();
	}
	
	public void draw(Graphics g) {
		
		int i = 30, aux = 0;
		g.drawString("Bond", 30, i);
		i += 20;
		g.drawString("Vida: " + bond.getHP() + "/" + bond.getHPMax(), 30, i);
		i += 20;
		g.drawString("Dihneiro: " + bond.getDinheiro(), 30, i);
		i += 20;
		g.drawString("Inimigos", SCREEN_WIDTH, i);
		i += 20;
		while(inimigos[aux] != null) {
			g.drawString(inimigos[aux].getNome() + " com hp: " + inimigos[aux].getHP() + "/" + inimigos[aux].getHPMax(), 30, i);
			aux++;
			i += 20;
		}

		/*for(int i=0;i<(SCREEN_HEIGHT/UNIT_SIZE)+1;i++) {
			g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
			g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
		}
		for(int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if(mapa.mostraImagem(i, j).equals("dinghyLarge1.png")) {
					//System.out.println("etes");
					continue;
				}
				g.drawImage(new ImageIcon(mapa.mostraImagem(i, j)).getImage(), j*UNIT_SIZE,  i*UNIT_SIZE, null);
						
			}
		}*/
	}
	
		
	
	public void paintComponent(Graphics g) {
		this.inimigos = resposta.getInimigos();
		super.paintComponent(g);
		draw(g);
	}
	
		
}

