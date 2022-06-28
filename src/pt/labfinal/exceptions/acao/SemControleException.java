package pt.labfinal.exceptions.acao;

public class SemControleException extends AcaoException{
	
	private static final long serialVersionUID = 1L;

	public SemControleException() {
		super();
	}

    public SemControleException(String message) {
        super(message);
    }
}