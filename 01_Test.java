package cwpuzzle;

public class Test {
	private Word[] word_list;
	private Box[] box_list;
	private Puzzle p;
	public String write = "";
	
	public Test(Puzzle p, Word[] word_list, Box[] box_list) {
		this.p = p;
		this.word_list= word_list;
		this.box_list = box_list;
	}
	
	public void insert_word(Puzzle p, Word w, Box b) {
		if(good_word(p, w, b)) {
			if(b.get_direction() == "h" ) {
				for(int i=0; i < b.get_length(); i++) {
					int start_r = b.get_start().get_row();
					int start_c = b.get_start().get_col();
					p.grid_words[start_r][start_c + i] = w.get_word().charAt(i);
					p.grid_counts[start_r][start_c + i]++;
				}
				w.set_used(true);
			}
			if(b.get_direction() == "v" ) {
				for(int i=0; i < b.get_length(); i++) {
					int start_r = b.get_start().get_row();
					int start_c = b.get_start().get_col();
					p.grid_words[start_r + i][start_c] = w.get_word().charAt(i);
					p.grid_counts[start_r + i][start_c]++;
				}
				w.set_used(true);
			}
			
		}
		else {
			System.out.print("Word does not fit!");
		}
	}
	
	public void delete_word(Puzzle p, Word w, Box b) {
		if(b.get_direction() == "h" ) {
			for(int i=0; i < b.get_length(); i++) {
				int start_r = b.get_start().get_row();
				int start_c = b.get_start().get_col();
				if(p.grid_counts[start_r][start_c + i] >= 2) {
					p.grid_counts[start_r][start_c + i]--;
				}
				else {
					p.grid_words[start_r][start_c + i] = '.';
					p.grid_counts[start_r][start_c + i]--;
				}
			}
		}
		if(b.get_direction() == "v" ) {
			for(int i=0; i < b.get_length(); i++) {
				int start_r = b.get_start().get_row();
				int start_c = b.get_start().get_col();
				if(p.grid_counts[start_r + i][start_c] >= 2) {
					p.grid_counts[start_r + i][start_c]--;
				}
				else {
					p.grid_words[start_r + i][start_c] = '.';
					p.grid_counts[start_r + i][start_c]--;
				}
			}
		}
		w.set_used(false);
	}
	
	
	public boolean good_horizontal(Puzzle p, Word w, Box b) {
		if(w.get_word().length() == b.get_length() && w.is_used() == false) {
			for(int i=0; i < b.get_length(); i++) {
				int start_r = b.get_start().get_row();
				int start_c = b.get_start().get_col();
				if(p.grid_words[start_r][start_c + i] != w.get_word().charAt(i) && p.grid_words[start_r][start_c + i] != '.') {
					return false;
				}
			}
			return true;
		}
		else {
			return false;
		}
	}
	public boolean good_vertical(Puzzle p, Word w, Box b) {
		if(w.get_word().length() == b.get_length() && w.is_used() == false) {
			for(int i=0; i < b.get_length(); i++) {
				int start_r = b.get_start().get_row();
				int start_c = b.get_start().get_col();
				if(p.grid_words[start_r + i][start_c] != w.get_word().charAt(i) && p.grid_words[start_r + i][start_c] != '.') {
					return false;
				}
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean good_word(Puzzle p, Word w, Box b) {
		if (b.get_direction() == "h") {
			return good_horizontal(p, w, b);
		}
		else {
			return good_vertical(p, w, b);
		}
	}
	
	public boolean make_puzzle(int n) {
		if(n == word_list.length) {
			return true;
		}
		for(int i=0; i < word_list.length; i++) {
			if(good_word(p, word_list[i], box_list[n])) {
				insert_word(p, word_list[i], box_list[n]);
				if(make_puzzle(n+1)) {
					return true;
				}
				delete_word(p, word_list[i], box_list[n]);
			}
		}
		return false;
	}
	
	
	public void print_puzzle() {
		if(make_puzzle(0)) {
			for(int i=0; i < p.grid_words.length; i++) {
				for(int j=0; j < p.grid_words[0].length; j++) {
					write += p.grid_words[i][j];
				}
				write += "\n";
			}
		}
		else {
			write += "Puzzle can't be made";
		}
	}
	
	/*
	public void print_puzzle2() {
		for(int i=0; i < p.grid_counts.length; i++) {
			for(int j=0; j < p.grid_counts[0].length; j++) {
				System.out.print(p.grid_counts[i][j]);
			}
			System.out.println();
		}
	}
	public void print_words() {
		for(int i=0; i < word_list.length; i++) {
			System.out.print(word_list[i].get_word());
			System.out.println();
		}
	}
	*/
}
