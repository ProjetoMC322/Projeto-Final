package pt.labfinal.exceptions.acao;

public class SemVaraException extends SemAtivoException{
	
	private static final long serialVersionUID = 1L;

	public SemVaraException() {
		super();
	}

    public SemVaraException(String message) {
        super(message);
    }
}
