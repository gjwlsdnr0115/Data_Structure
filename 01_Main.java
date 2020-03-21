package cwpuzzle;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader;
		FileWriter writer = new FileWriter("/Users/andybr10/Desktop/2015198005.txt");
		try {
			reader = new BufferedReader(new FileReader("/Users/andybr10/Desktop/input.txt"));			
			int test_cases = Integer.parseInt(reader.readLine());
			for(int r=0; r < test_cases; r++) {
				String line;
				line = reader.readLine();
				String[] rcw = line.split(" ");
				
				// crossword info input
				int g_row = Integer.parseInt(rcw[0]);
				int g_col = Integer.parseInt(rcw[1]);
				int word_num = Integer.parseInt(rcw[2]);
				
				Word[] word_list = new Word[word_num];
				String[] words = new String[word_num];
				char[][] cw = new char[g_row][g_col];			
				
				// crossword puzzle input
				for(int i=0; i < g_row; i++){
					line = reader.readLine();
	                for(int j=0 ;j< g_col; j++)
	                	cw[i][j]=line.charAt(j);
	            }
				Puzzle p = new Puzzle(cw);
				
				// words input
				line = reader.readLine();
				words = line.split(" ");
				for(int i=0; i < word_num; i++) {
					word_list[i] = new Word(words[i]);
				}
				// make box list
				Box[] box_list = new Box[word_num];
				int idx = 0;
				// horizontal box input
				for(int i=0; i < g_row; i++) {
					int count = 0;
					for(int j=0; j < g_col; j++) {
						if(cw[i][j] == '.') {
							if(j == g_col - 1 && count >= 1) {
								count++;
								Place pl = new Place(i, j - count + 1);
								Box b = new Box(pl, "h", count);
								box_list[idx] = b;
								count = 0;
								idx++;
							}
							else {
								count++;
							}
						}
						if(cw[i][j] == '#') {
							if(count >= 2) {
								Place pl = new Place(i, j - count);
								Box b = new Box(pl, "h", count);
								box_list[idx] = b;
								count = 0;
								idx++;
							}
							else {
								count = 0;
							}
						}
					}
				}
				// vertical box input
				for(int i=0; i < g_col; i++) {
					int count = 0;
					for(int j=0; j < g_row; j++) {
						if(cw[j][i] == '.') {
							if(j == g_row - 1 && count >= 1) {
								count++;
								Place pl = new Place(j - count + 1, i);
								Box b = new Box(pl, "v", count);
								box_list[idx] = b;
								count = 0;
								idx++;
							}
							else {
								count++;
							}
						}
						if(cw[j][i] == '#') {
							if(count >= 2) {
								Place pl = new Place(j - count, i);
								Box b = new Box(pl, "v", count);
								box_list[idx] = b;
								count = 0;
								idx++;
							}
							else {
								count = 0;
							}
						}
					}
				}
							
				
				Test t = new Test(p, word_list, box_list);
				t.print_puzzle();
				writer.write(t.write);
				writer.write("\n");
			}
		}
		
		catch (IOException e) {
			
		}
		finally {
			writer.close();
		}
	}

}
