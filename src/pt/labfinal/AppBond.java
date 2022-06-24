package pt.labfinal;

public class AppBond {

	public static void main(String[] args) {
		String itens[][] = Toolkit.retrieveItems();
		String componentes[][] = Toolkit.retrieveComponents();
		System.out.println(itens.length);
		Montador montador = new Montador();
		Mapa mapa = Mapa.getInstance();
		montador.montaMapa(componentes, itens);
		Controle controlador = new Controle();
		InterfaceGrafica i = InterfaceGrafica.getInstance();
		i.mostraJanelinha();
		controlador.leTeclado();
	}

}
