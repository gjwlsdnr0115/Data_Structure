package intlist;

public class Operation {
	private IntegerList i1;
	private IntegerList i2;
	public String write = "";
	public Operation(IntegerList i1, IntegerList i2) {
		this.i1 = i1;
		this.i2 = i2;
	}
	
	// converting string into an integer
	public long get_int(IntegerList il) { //used type long in case of long numbers
		Node p = il.head;
		String num = "";
		num += p.get_element();
		p = p.next;
		while(p != null) {
			if(p.get_element().length() == 1) {
				num += "00";
				num += p.get_element();
				p = p.next;
			}
			else if(p.get_element().length() == 2) {
				num += "0";
				num += p.get_element();
				p = p.next;
			}
			else {
				num += p.get_element();
				p = p.next;
			}
		}
		long num_int = Long.parseLong(num);
		return num_int;
	}
	
	public String multiply() {
		long num1 = get_int(i1);
		long num2 = get_int(i2);
		long result = num1 * num2;
		
		return Long.toString(result);
	}
	
	public String divide() {
		long num1 = get_int(i1);
		long num2 = get_int(i2);
		long result = num1 / num2;
		
		return Long.toString(result);
	}
	
	public String remainder() {
		long num1 = get_int(i1);
		long num2 = get_int(i2);
		long result = num1 % num2;
		
		return Long.toString(result);
	}
	public void operate() {
		write += multiply();
		write += " ";
		write += divide();
		write += " ";
		write += remainder();
		write += "\n";
	}
}
