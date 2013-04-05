/**
 * The Class NoStudentException.
 * By Andrew Borghesani
 */
public class NoStudentException extends Exception {
	
	/**
	 * Instantiates a new no student exception.
	 */
	public NoStudentException(){
		super("No such Student exists in the list");
	}
}
