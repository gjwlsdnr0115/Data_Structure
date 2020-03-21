package cwpuzzle;

public class Word {
	private String word;
	private boolean used;
	
	public Word(String word) {
		this.word = word;
		used = false;
	}
	
	public String get_word() {
		return word;
	}
	public boolean is_used() {
		return used;
	}
	public void set_used(boolean used) {
		this.used= used;
	}
}
