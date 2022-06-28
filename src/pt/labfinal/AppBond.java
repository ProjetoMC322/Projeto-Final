package pt.labfinal;

import pt.labfinal.control.ControleBond;
import pt.labfinal.model.Montador;
import pt.labfinal.model.Toolkit;
import pt.labfinal.view.GUIMar;

public class AppBond {

	public static void main(String[] args) {
		String itens[][] = Toolkit.retrieveItems();
		String componentes[][] = Toolkit.retrieveComponents();
		Montador montador = new Montador();
		montador.montaMapa(componentes, itens);
		ControleBond cb = ControleBond.getInstance();
		new GUIMar();
	}

}
