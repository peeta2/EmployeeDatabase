package cz.peeta2.employeedatabase;

public class RoomIsNotOfficeException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	public RoomIsNotOfficeException(String roomName) {
        super("Room with name " + roomName + " exists, but is not an Office!");
    }
}