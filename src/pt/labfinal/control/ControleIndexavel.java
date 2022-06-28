package pt.labfinal.control;

import pt.labfinal.model.mapa.componente.Inventario;
import pt.labfinal.view.GUIMar;

public abstract class ControleIndexavel implements Controle{
	protected int modo;
	protected Inventario inventario;
	protected Leitor leitor;
	
	public ControleIndexavel(Inventario inventario){
		this.modo = 0;
		this.inventario = inventario;
		this.leitor = Leitor.getInstance();
	}
	
	public boolean interpreta(String comandos, GUIMar gRef) {
		return true;
	}
}
