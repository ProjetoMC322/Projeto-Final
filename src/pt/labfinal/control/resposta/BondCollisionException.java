package pt.labfinal.control.resposta;

public class BondCollisionException extends RespostaException{
	
	private static final long serialVersionUID = 1L;

	public BondCollisionException() {
		super();
	}

    public BondCollisionException(String message) {
        super(message);
    }
}