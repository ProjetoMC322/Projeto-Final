package pt.labfinal.control;

import pt.labfinal.model.mapa.componente.Bond;
import pt.labfinal.model.mapa.componente.Inventario;
import pt.labfinal.model.mapa.componente.Oficina;
import pt.labfinal.view.GUIMar;
import pt.labfinal.view.GUIMarPanel;

public class ControleOficina extends ControleIndexavel{
	
	private Oficina oficina;
	public ControleOficina(Inventario inventario, Oficina oficina){
		super(inventario);
		this.oficina = oficina;
	}
	
	
	public boolean interpreta(String comandos, GUIMar gRef) {
		if(comandos.substring(0, 1).matches("-?\\d+")) {
			if(Integer.parseInt(comandos.substring(0, 1)) == 1) {
				oficina.cura(Bond.getInstance());
			}else if(Integer.parseInt(comandos.substring(0, 1)) == 2) {
				oficina.melhora(Bond.getInstance());
			}
			return true;
		}
		gRef.setPanelActive('l', new GUIMarPanel());
		leitor.desconectaControle();
		leitor.conectaControle(ControleBond.getInstance());
		return true;
	}

}
