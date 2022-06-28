package pt.labfinal.control;

import pt.labfinal.exceptions.acao.AcaoException;
import pt.labfinal.view.GUIMar;

public interface Controle {
	
	public boolean interpreta(String comandos, GUIMar gRef);	
	
}
