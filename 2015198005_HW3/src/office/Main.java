package office;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader;
		FileWriter writer = new FileWriter("C:\\hw3\\2015198005.txt");
		try {
			reader = new BufferedReader(new FileReader("C:\\hw3\\input.txt"));
			
			Inbox inbox = new Inbox();
			QueueList q1 = new QueueList();
			QueueList q2 = new QueueList();
			QueueList q3 = new QueueList();
			
			Action a = new Action(inbox, q1, q2, q3);
			
			String line;
			while((line = reader.readLine()) != null) {
				String[] s = line.split(" ");
				
				if(s[0].equals("enter")) {
					a.enter();
				}
				else if(s[0].equals("submit")) {
					a.submit(s[1], Integer.parseInt(s[2]));
				}
				else if(s[0].equals("print")) {
					a.print();
				}
				else if(s[0].equals("withdraw")) {
					a.withdraw(s[1]);
				}
				else if(s[0].equals("sort")) {
					a.sort();
				}
				else if (s[0].equals("read")) {
					a.read();
				}
				
				else {
					a.leave();
				}
				
			}
			
			writer.write(a.write);
			
		}
		
		catch (IOException e) {
			
		}
		finally {
			writer.close();
		}
	}

}
