package pt.labfinal;

public class AppBond {

	public static void main(String[] args) {
		String itens[][] = Toolkit.retrieveItems();
		String componentes[][] = Toolkit.retrieveComponents();
		Montador montador = new Montador();
		Mapa mapa = Mapa.getInstance();
		montador.montaMapa(componentes, itens);
		Leitor leitor = Leitor.getInstance();
		ControleBond cb = ControleBond.getInstance();
		new GUIMar();
		cb.iniciaControle();
		leitor.conectaControle(cb);
		leitor.leTeclado();
	}

}
