package exceptions;

public class CamaExtraPresenteException extends Exception {
	public CamaExtraPresenteException() {
		super("Este quarto ja possui uma cama extra.");
	}
}
