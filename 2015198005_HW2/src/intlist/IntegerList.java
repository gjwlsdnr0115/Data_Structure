package intlist;

public class IntegerList {
	protected Node head;
	protected int size;
	public IntegerList() {
		head = null;
		size = 0;
	}
	public int size() {return size;}
	public boolean is_empty() {return (size == 0);}
	
	
	public void insert_front(String num) {
		if(num.length() == 3) {
			if(num.charAt(0) == '0') {
				if(num.charAt(1) == '0') {
					head = new Node(num.substring(2), head);
					size++;
				}
				else {
					head = new Node(num.substring(1), head);
					size++;
				}
			}
			else {
				head = new Node(num, head);
				size++;
			}
		}
		else { // the first node might have less than 3 characters
			head = new Node(num, head);
			size++;
		}
	}
	
	// inserting input number from the back
	public void insert_num(String num) {
		int length = num.length();
		int it = length / 3 + 1;
		String num_c = num + 'a';
		for (int i = 0; i < it; i++) {
			if (length - 3 < 0 ) {
				String sub = num_c.substring(0, length);
				insert_front(sub);
			}
			else {
				String sub = num_c.substring(length - 3, length);
				insert_front(sub);
				length -= 3;
			}
		}
	}
	
	/*
	public String get_string() {
		Node p = head;
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
		return num;
	}
	*/
}
