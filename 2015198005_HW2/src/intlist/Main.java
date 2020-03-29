package intlist;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



import java.io.BufferedReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader;
		FileWriter writer = new FileWriter("C:\\hw2\\2015198005.txt");
		try {
			reader = new BufferedReader(new FileReader("C:\\hw2\\input.txt"));
			int test_cases = Integer.parseInt(reader.readLine());
			
			// repeat following for all test cases
			for(int r=0; r < test_cases; r++) {
				String line;
				line = reader.readLine();
				String[] numbers = line.split(" ");
				
				String number1 = numbers[0];
				String number2 = numbers[1];
				
				IntegerList n1 = new IntegerList();
				IntegerList n2 = new IntegerList();
				
				n1.insert_num(number1);
				n2.insert_num(number2);
				
				
				Operation o = new Operation(n1, n2);
				o.operate();
				writer.write(o.write);
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
