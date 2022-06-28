package pt.labfinal.view;
import java.awt.*;
import javax.swing.*;

public class GUIGameOverPanel extends JPanel{

	private static final long serialVersionUID = 6L;
	private int SCREEN_WIDTH = 1300;
	private int SCREEN_HEIGHT = 650;
	private int mode;
	
	public GUIGameOverPanel(int mode){
		
		this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.mode = mode;
		
	}
	
	public void draw(Graphics g) {
		if(mode == 0) {
			g.setColor(Color.red);
			g.setFont( new Font("Ink Free",Font.BOLD, 75));
			FontMetrics metrics2 = getFontMetrics(g.getFont());
			g.drawString("Game Over: Bond naufragou!", (SCREEN_WIDTH - metrics2.stringWidth("Game Over: Bond naufragou!"))/2, SCREEN_HEIGHT/2);
		}else if(mode == 1) {
			g.setColor(Color.green);
			g.setFont( new Font("Ink Free",Font.BOLD, 75));
			FontMetrics metrics2 = getFontMetrics(g.getFont());
			g.drawString("Game Over: Godzilla Morto!", (SCREEN_WIDTH - metrics2.stringWidth("Game Over: Godzilla Morto!"))/2, SCREEN_HEIGHT/2);
		}else if(mode == 2) {
			g.setColor(Color.cyan);
			g.setFont( new Font("Ink Free",Font.BOLD, 75));
			FontMetrics metrics2 = getFontMetrics(g.getFont());
			g.drawString("Player saiu do jogo, volte sempre!", (SCREEN_WIDTH - metrics2.stringWidth("Player saiu do jogo, volte sempre!"))/2, SCREEN_HEIGHT/2);
		}
	
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	
		
}

