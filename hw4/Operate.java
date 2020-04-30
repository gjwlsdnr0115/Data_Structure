package median;

import java.util.Queue;

public class Operate {
	private String write = "";
	private MedianHeap mh;
	private Queue<String> inputs;
	private int operations;
	
	public Operate(MedianHeap mh, Queue<String> inputs, int operations) {
		this.inputs = inputs;
		this.mh = mh;
		this.operations = operations;
	}
	
	public void insert() {
		int key = Integer.parseInt(inputs.poll());		//input element key
		String value = inputs.poll();		//input element value
		Element e = new Element(key, value);
		mh.insertElement(e);		
	}
	
	public void delete() {
		Element e = mh.deleteMedian();		//get median element
		String value = e.getValue();
		write += value;		//write value
		write += " ";
	}
	
	public String process() {
		for(int i=0; i<operations; i++) {	//for number of operations
			String s = inputs.poll();
			if(s.equals("i")) {
				insert();
			}
			else {
				delete();
			}
		}
		write += "\n";
		return write;
	}
}
