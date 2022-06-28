package pt.labfinal.exceptions.acao;

public class AcaoException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public AcaoException() {
		super();
	}

    public AcaoException(String message) {
        super(message);
    }
}
