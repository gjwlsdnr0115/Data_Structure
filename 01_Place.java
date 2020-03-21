package cwpuzzle;

public class Place {
	private int r;
	private int c;
	
	public Place(int r, int c) {
		this.r = r;
		this.c = c;
	}
	
	public Place(Place pl) {
		this.r = pl.get_row();
		this.c = pl.get_col();

	}
	
	public int get_row() {
		return r;
	}
	
	public int get_col() {
		return c;
	}
}
