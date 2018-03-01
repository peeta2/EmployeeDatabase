package cz.peeta2.employeedatabase.model;

public class Room {
	private String name;
	
	private int area;
	
	public Room(String name, int area) {
		this.name = name;
		this.area = area;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}
}
