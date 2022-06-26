package pt.labfinal;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Imagem extends JLabel{
	
	private static final long serialVersionUID = 2L;
	
	public Imagem(String link){
		//super(new ImageIcon(Imagem.class.getResource(".").getPath() + link));
		super(new ImageIcon(link));
		//temos que ver como pegar esse caminho do jeito certo
		//System.out.println(Imagem.class.getResource(".").getPath() + link);
	}
}
