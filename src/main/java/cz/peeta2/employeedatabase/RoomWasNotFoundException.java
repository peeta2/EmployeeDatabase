package cz.peeta2.employeedatabase;

public class RoomWasNotFoundException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 3L;

	public RoomWasNotFoundException(String roomName) {
        super("Room " + roomName + " was not found!");
    }
}