package pt.labfinal;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionListener;


public class GUIMar extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 3L;
	private static JPanel leftPanel, rightPanel;
	private Mapa mapa = Mapa.getInstance();
	private static GUIMar instance = null;
	Timer timer;
	boolean running = false;
	static final int DELAY = 175;
	
	public GUIMar() {
		//criando frame
		setTitle("007: Aposentadoria");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1400,700);
		setVisible(true);
		instance = this;
		ControleBond cb = ControleBond.getInstance();
		cb.iniciaControle();
		Leitor l = Leitor.getInstance();
		l.conectaControle(cb);
		this.addKeyListener(Leitor.getInstance());
		leftPanel = new GUIMarPanel();
		rightPanel = new GUIUtilsPanel();
		add(leftPanel, BorderLayout.LINE_START);
		add(rightPanel, BorderLayout.LINE_END);
		startGame();
	}
	
	public static GUIMar getInstance(){
        return instance;
    }
	
	public void startGame() {
		running = true;
		timer = new Timer(DELAY,this);
		timer.start();
	}

	public void setPanelActive(char i, JPanel toActivate) {
		if(i == 'l') {
			remove(leftPanel);
			leftPanel = toActivate;
			add(leftPanel);
		}else if(i == 'r') {
			remove(rightPanel);
			rightPanel = toActivate;
			add(rightPanel);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		leftPanel.repaint();
		rightPanel.repaint();
	}
		
}
