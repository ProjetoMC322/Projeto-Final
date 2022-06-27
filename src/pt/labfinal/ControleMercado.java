package pt.labfinal;

public class ControleMercado extends ControleIndexavel{
	
	private Mercado mercado;
	
	ControleMercado(Inventario inventario, Mercado mercado){
		super(inventario);
		this.mercado = mercado;
	}
	
	public boolean interpreta(String comandos, GUIMar gRef) {
		if(modo == 0) {
			if(comandos.substring(0, 1).matches("-?\\d+")) {
				modo = Integer.parseInt(comandos.substring(0, 1));
				if(modo > 3) {
					mercado.compraMunicao(Bond.getInstance());
					modo = 0;
					return true;
				}
				gRef.setPanelActive('l', new GUIMercadoPanel(inventario, mercado, modo));
				return true;
			}else {
				gRef.setPanelActive('l', new GUIMarPanel());
				leitor.desconectaControle();
				leitor.conectaControle(ControleBond.getInstance());
				return true;
			}
			//try-except no lugar do regex
		}else if(modo == 1) {
			if(comandos.substring(0, 1).matches("-?\\d+")) {
				mercado.compraArma(Integer.parseInt(comandos.substring(0, 1)), Bond.getInstance());
				return true;
			}else {
				modo = 0;
				gRef.setPanelActive('l', new GUIMercadoPanel(inventario, mercado, modo));
				return true;
			}
		}else if(modo == 2) {
			if(comandos.substring(0, 1).matches("-?\\d+")) {
				mercado.compraVara(Integer.parseInt(comandos.substring(0, 1)), Bond.getInstance());
				return true;
			}else {
				modo = 0;
				gRef.setPanelActive('l', new GUIMercadoPanel(inventario, mercado, modo));
				return true;
			}
		}else if(modo == 3) {
			if(comandos.substring(0, 1).matches("-?\\d+")) {
				inventario.vendePeixe(Integer.parseInt(comandos.substring(0, 1)));
				return true;
			}else {
				modo = 0;
				gRef.setPanelActive('l', new GUIMercadoPanel(inventario, mercado, modo));
				return true;
			}
		}
		modo = 0;
		gRef.setPanelActive('l', new GUIMercadoPanel(inventario, mercado, modo));
		return true;

	}
}
