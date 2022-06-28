package pt.labfinal.exceptions.acao;

public class SemAtivoException extends AcaoException{
	
	private static final long serialVersionUID = 1L;

	public SemAtivoException() {
		super();
	}

    public SemAtivoException(String message) {
        super(message);
    }
}


