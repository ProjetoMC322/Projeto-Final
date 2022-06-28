package pt.labfinal.view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import pt.labfinal.control.ControleBond;
import pt.labfinal.control.Leitor;

import java.awt.event.ActionListener;


public class GUIMar extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 3L;
	private JPanel leftPanel, rightPanel;
	Timer timer;
	boolean running = false;
	static final int DELAY = 175;
	
	public GUIMar() {
		//criando frame
		setTitle("007: Aposentadoria");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1400,700);
		setVisible(true);
		ControleBond cb = ControleBond.getInstance();
		cb.iniciaControle();
		Leitor l = Leitor.getInstance();
		l.conectaControle(cb);
		l.addGUIReference(this);
		this.addKeyListener(Leitor.getInstance());
		leftPanel = new GUIMarPanel();
		rightPanel = new GUIUtilsPanel();
		add(leftPanel, BorderLayout.LINE_START);
		add(rightPanel, BorderLayout.CENTER);
		startGame();
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
			add(leftPanel, BorderLayout.LINE_START);
			revalidate();
			
		}else if(i == 'r') {
			remove(rightPanel);
			rightPanel = toActivate;
			add(rightPanel, BorderLayout.CENTER);
			
			revalidate();
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		leftPanel.repaint();
		rightPanel.repaint();
	}
		
}
