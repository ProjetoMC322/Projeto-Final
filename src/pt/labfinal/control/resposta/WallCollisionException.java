package pt.labfinal.control.resposta;

public class WallCollisionException extends RespostaException{
	
	private static final long serialVersionUID = 1L;

	public WallCollisionException() {
		super();
	}

    public WallCollisionException(String message) {
        super(message);
    }
}