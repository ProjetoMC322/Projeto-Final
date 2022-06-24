package pt.labfinal;

import javax.swing.JFrame;

		
public class InterfaceGrafica {
	private static final InterfaceGrafica instance = new InterfaceGrafica ();
	private InterfaceGrafica(){}
	
	public static InterfaceGrafica getInstance(){
        return instance;
    }
	public static String DIRETORIO =
	         InterfaceGrafica.class.getResource(".").getPath();
	   
	
	public void mostraJanelinha() {
		new Imagem(DIRETORIO + "007-aposentadoria.png");
	}
}
