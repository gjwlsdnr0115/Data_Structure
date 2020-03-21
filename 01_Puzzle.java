package cwpuzzle;

public class Puzzle {
	public char[][] grid_words;
	public int[][] grid_counts;
	
	public Puzzle(char[][] grid_words) {
		this.grid_words = grid_words;
		grid_counts = new int[grid_words.length][grid_words[0].length];
	}
}
