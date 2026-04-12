package allumettes;

//levee quand un joueur essaie de tricher
public class OperationInterditeException extends RuntimeException {
	public OperationInterditeException(String message) {
		super(message);
	}

}