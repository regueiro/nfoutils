package es.regueiro.nfoutils.internal.exceptions;

/**
 * An exception for use when the provided folder location is invalid 
 */
public class InvalidFolderException extends Exception {

	private static final long serialVersionUID = -86519996727462473L;

	public InvalidFolderException(String string) {
		super(string);
	}
}
