package cwpuzzle;

public class Box {
	private Place start;
	private String direction;
	private int length;
	
	public Box(Place start, String direction, int length) {
		this.start = start;
		this.direction = direction;
		this.length = length;
	}
	
	public Place get_start() {
		return start;
	}
	public String get_direction() {
		return direction;
	}
	public int get_length() {
		return length;
	}
}
