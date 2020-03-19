import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;


public class Hw1 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader;
		BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/andybr10/Desktop/2015198005.txt"));
		
		try {
			reader = new BufferedReader(new FileReader("/Users/andybr10/Desktop/input.txt"));
			
			int test_cases = Integer.parseInt(reader.readLine());
			String line;
			line = reader.readLine();
			String[] rcw = line.split(" ");
			
			int g_row = Integer.parseInt(rcw[0]);
			int g_col = Integer.parseInt(rcw[1]);
			int word_num = Integer.parseInt(rcw[2]);
			
			char[][] cw = new char[g_row][g_col];
			String[] words = new String[word_num];
			
			for(int i=0; i < g_row; i++){
				line = reader.readLine();
                for(int j=0 ;j< g_col; j++)
                	cw[i][j]=line.charAt(j);
            }
			line = reader.readLine();
			words = line.split(" ");
			
			/*
			for(int i=0; i < g_row; i++){
                for(int j=0 ;j< g_col; j++)
                	System.out.print(cw[i][j]);
                	System.out.println();
            }
            
			for(int i=0; i < word_num; i++)
				System.out.print(words[i]);
			*/
			
		}
		
		catch (IOException e) {
			
		}
		finally {
			writer.close();
		}
		
	}
}
