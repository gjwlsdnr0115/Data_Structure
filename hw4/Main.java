package median;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader;
		FileWriter writer = new FileWriter("C:\\hw4\\2015198005.txt");
		try {
			reader = new BufferedReader(new FileReader("C:\\hw4\\input.txt"));
			
			String line;
			int test_num= 1;
			while((line=reader.readLine()) != null) {		//while there is input
				int operations = Integer.parseInt(line);		//input operations
				String s[];		//input string list
				Queue<String> inputs = new LinkedList<String>();	//input string queue
				line = reader.readLine();
				s = line.split(" ");
				for(int i=0; i<s.length; i++) {		//add input strings in queue
					inputs.add(s[i]);
				}
				MedianHeap mh = new MedianHeap();	//initialize median heap
				Operate o = new Operate(mh, inputs, operations);	//initialize operation
				String t_num = Integer.toString(test_num);	//test case number
				writer.write("#" + t_num + " ");	//write test case num
				String write = o.process();
				writer.write(write);		//write operation
				test_num++;	//increase test case num
			}
		}
		catch (IOException e) {
			
		}
		finally {
			writer.close();
		}
	}

}