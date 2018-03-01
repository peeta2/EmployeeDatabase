package cz.peeta2.employeedatabase;

public class WrongArgumentException  extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4L;

	public WrongArgumentException(String location) {
        super("Wrong argument in '" + location + "' ! Please check documentation.");
    }

	public WrongArgumentException() {
		super("Wrong command!  Please check documentation.");
	}
}