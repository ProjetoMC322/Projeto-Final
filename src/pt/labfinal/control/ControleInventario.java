package pt.labfinal.control;

import pt.labfinal.model.mapa.componente.Inventario;
import pt.labfinal.view.GUIInventarioPanel;
import pt.labfinal.view.GUIMar;
import pt.labfinal.view.GUIMarPanel;

public class ControleInventario extends ControleIndexavel{
	
	public ControleInventario(Inventario inventario){
		super(inventario);
	}
	
	public boolean interpreta(String comandos, GUIMar gRef) {
		if(modo == 0) {
			if(comandos.substring(0, 1).matches("-?\\d+")) {
				modo = Integer.parseInt(comandos.substring(0, 1));
				if(modo > 3) {
					modo = 0;
					gRef.setPanelActive('l', new GUIInventarioPanel(inventario, 0));
					return true;
				}
				if(modo == 3) {
					
					gRef.setPanelActive('l', new GUIInventarioPanel(inventario, modo));
					return true;
				}
				gRef.setPanelActive('l', new GUIInventarioPanel(inventario, modo));
				return true;
			}else {
				System.out.println("voltando para controle bond");
				gRef.setPanelActive('l', new GUIMarPanel());
				leitor.desconectaControle();
				leitor.conectaControle(ControleBond.getInstance());
				return true;
			}
			//try-except no lugar do regex
		}else if(modo == 1) {
			if(comandos.substring(0, 1).matches("-?\\d+")) {
				inventario.equipaArma(Integer.parseInt(comandos.substring(0, 1)));
				return true;
			}else {
				modo = 0;
				gRef.setPanelActive('l', new GUIInventarioPanel(inventario, 0));
				return true;
			}
		}else if(modo == 2) {
			if(comandos.substring(0, 1).matches("-?\\d+")) {
				inventario.equipaVara(Integer.parseInt(comandos.substring(0, 1)));
				return true;
			}else {
				modo = 0;
				gRef.setPanelActive('l', new GUIInventarioPanel(inventario, 0));
				return true;
			}
		}else if(modo == 3) {
			gRef.setPanelActive('l', new GUIInventarioPanel(inventario, 0));
			modo = 0;
			return true;
		}
		gRef.setPanelActive('l', new GUIInventarioPanel(inventario, 0));
		modo = 0;
		return true;

	}

}
