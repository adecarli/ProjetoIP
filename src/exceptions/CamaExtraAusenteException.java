package exceptions;

public class CamaExtraAusenteException extends Exception {
	public CamaExtraAusenteException() {
		super("Este quarto nao possui cama extra.");
	}
}
