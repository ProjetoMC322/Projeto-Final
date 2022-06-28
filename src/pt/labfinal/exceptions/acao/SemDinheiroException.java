package pt.labfinal.exceptions.acao;

public class SemDinheiroException extends AcaoException{
	
	private static final long serialVersionUID = 1L;

	public SemDinheiroException() {
		super();
	}

    public SemDinheiroException(String message) {
        super(message);
    }
}