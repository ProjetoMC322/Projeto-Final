package pt.labfinal;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Imagem extends JFrame{
	private static final long serialVersionUID = 1278136335268310294L;
	private JButton ok = new JButton("Ok");
	private JButton cancelar = new JButton("Cancelar");


	   public Imagem(String arquivoImagem) {
	      super();
	      setDefaultCloseOperation(EXIT_ON_CLOSE);
	      visual(arquivoImagem);
	   }
	    
	   public void visual(String arquivoImagem) {
	      setSize(1000, 1000);
	      Container contentPane = getContentPane();
	      contentPane.setLayout(new GridBagLayout());
	      ImageIcon imagem = new ImageIcon(arquivoImagem);
	      JLabel campoImagem = new JLabel(imagem);
	      JPanel painel = new JPanel();
	      painel.setBounds(100, 100, 600, 300);
	      painel.setBackground(Color.blue);
	      contentPane.add(painel);
	      contentPane.add(campoImagem, BorderLayout.CENTER);
	      contentPane.add(ok, BorderLayout.NORTH);
	      contentPane.add(cancelar, BorderLayout.EAST);
	      setVisible(true);
	   }
}
