package pt.labfinal.view;
import java.awt.*;
import java.util.Objects;

import javax.swing.*;

import pt.labfinal.model.item.Item;
import pt.labfinal.model.item.Peixe;
import pt.labfinal.model.item.arma.Arma;
import pt.labfinal.model.item.vara.Vara;
import pt.labfinal.model.mapa.Resposta;
import pt.labfinal.model.mapa.componente.Bond;
import pt.labfinal.model.mapa.componente.inimigo.Inimigo;

public class GUIUtilsPanel extends JPanel{

	private static final long serialVersionUID = 7L;
	static final int SCREEN_WIDTH = 650;
	static final int SCREEN_HEIGHT = 650;
	private Resposta resposta;
	private Inimigo inimigos[];
	public static Peixe ultimaPescaria;
	private Bond bond;
	
	
	public GUIUtilsPanel(){
		this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
		this.setBackground(Color.white);
		this.setFocusable(true);
		resposta = Resposta.getInstance();
		bond = Bond.getInstance();
	}
	
	public void draw(Graphics g) {
		
		int i = 30, aux = 0;
		g.drawString("Bond", 300, i);
		i += 20;
		g.drawString("Vida: " + bond.getHP() + "/" + bond.getHPMax(), 30, i);
		i += 20;
		g.drawString("Dinheiro: " + bond.getDinheiro(), 30, i);
		i += 20;
		g.drawString("Arma equipada: " + bond.getArmaAtiva().getNome(), 30, i);
		i += 20;
		g.drawImage(new ImageIcon(Objects.requireNonNull(Item.class.getResource(bond.getArmaAtiva().getImage()))).getImage(), 40,  i, null);
		i += 70;
		g.drawString("Municao: " + bond.getArmaAtiva().getMunicaoAtual() + "/" + 
									bond.getArmaAtiva().getMunicaoMax() , 30, i);
		i += 20;
		g.drawString("Vara equipada: " + bond.getVaraAtiva().getNome(), 30, i);
		i += 20;
		g.drawImage(new ImageIcon(Objects.requireNonNull(Item.class.getResource(bond.getVaraAtiva().getImage()))).getImage(), 40,  i, null);
		i += 70;
		g.drawString("Durabilidade: " + bond.getVaraAtiva().getDurabilidadeAtual() + "/" + 
									bond.getVaraAtiva().getDurabilidadeMax() , 30, i);
		i += 20;
		g.drawString("Inimigos", 300, i);
		i += 20;
		
		while(inimigos[aux] != null) {
			g.drawString(inimigos[aux].getNome() + " com hp: " + inimigos[aux].getHP() + "/" + inimigos[aux].getHPMax(), 30, i);
			aux++;
			i += 20;
		}
		
		if(ultimaPescaria != null) {
			g.drawString("Resultado da ultima pescaria:", 300, i);
			i += 20;
			g.drawImage(new ImageIcon(Objects.requireNonNull(Item.class.getResource(ultimaPescaria.getImage()))).getImage(), 40,  i, null);
			i += 70;
			g.drawString(ultimaPescaria.getNome() + " Preco: " + ultimaPescaria.getPreco(), 30, i);
		}

	}
	
		
	
	public void paintComponent(Graphics g) {
		this.inimigos = resposta.getInimigos();
		super.paintComponent(g);
		draw(g);
	}
		
}
