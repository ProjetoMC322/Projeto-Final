package pt.labfinal.control.resposta;

public class PosicaoInvalidaException extends RespostaException{
	
	private static final long serialVersionUID = 1L;

	public PosicaoInvalidaException() {
		super();
	}

    public PosicaoInvalidaException(String message) {
        super(message);
    }
}