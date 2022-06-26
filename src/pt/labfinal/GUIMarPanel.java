package pt.labfinal;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GUIMarPanel extends JPanel implements ActionListener{

	static final int SCREEN_WIDTH = 800;
	static final int SCREEN_HEIGHT = 800;
	static final int UNIT_SIZE = 80;
	static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/(UNIT_SIZE*UNIT_SIZE);
	static final int DELAY = 175;
	boolean running = false;
	Timer timer;
	Mapa mapa = Mapa.getInstance();
	
	GUIMarPanel(){
		
		this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
		this.setBackground(Color.getHSBColor(mapa.pegaCorH(), mapa.pegaCorS(), mapa.pegaCorB()));
		this.setFocusable(true);
		this.addKeyListener(Leitor.getInstance());
		startGame();
	}
	
	public void startGame() {
		running = true;
		timer = new Timer(DELAY,this);
		timer.start();
	}
	
	
	public void draw(Graphics g) {
		System.out.println("chegou");
		if(running) {
			for(int i=0;i<SCREEN_HEIGHT/UNIT_SIZE;i++) {
				g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
				g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
			}
			for(int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if(mapa.mostraImagem(i, j).equals("dinghyLarge1.png")) {
						System.out.println("etes");
						continue;
					}
					g.drawImage(new ImageIcon(mapa.mostraImagem(i, j)).getImage(), j*UNIT_SIZE,  i*UNIT_SIZE, null);
							
				}
			}
		}
		else {
			gameOver(g);
		}
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	public static void gameOver(Graphics g) {
		//Score
		g.setColor(Color.red);
		g.setFont( new Font("Ink Free",Font.BOLD, 40));
		//Game Over text
		System.out.println("eu sai do jogo!!!");
	}
	
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
		
}

