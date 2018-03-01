package cz.peeta2.employeedatabase;

public class RoomAlreadyExistsException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RoomAlreadyExistsException(String roomName) {
        super("Room " + roomName + " already exists!");
    }
}