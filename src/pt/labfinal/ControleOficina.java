package pt.labfinal;

public class ControleOficina extends ControleIndexavel{
	
	private Oficina oficina;
	ControleOficina(Inventario inventario, Oficina oficina){
		super(inventario);
		this.oficina = oficina;
	}
	
	
	public boolean interpreta(String comandos) {
		if(comandos.substring(0, 1).matches("-?\\d+")) {
			if(Integer.parseInt(comandos.substring(0, 1)) == 1) {
				oficina.cura(Bond.getInstance());
			}else if(Integer.parseInt(comandos.substring(0, 1)) == 2) {
				oficina.melhora(Bond.getInstance());
			}
			return true;
		}
		leitor.desconectaControle();
		leitor.conectaControle(ControleBond.getInstance());
		return true;
	}

}