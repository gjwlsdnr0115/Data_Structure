package office;


public class Inbox {
	protected Node top;
	protected int size;
	
	public Inbox() {
		top = null;
		size = 0;
	}
	
	public int size() { return size; }
	public boolean isEmpty() { return size == 0; }
	
	public void push(Node newItem) {
		top = newItem;
		size++;
	}
	public Node peek() {
		return top;
	}
	public Node pop() {
		Node item = top;
		top = top.getNext();
		size--;
		return item;
	}
	
	public String printInbox() {
		String s = "";
		if(isEmpty()) {
			s += "EMPTY\n";
		}
		else {
			// create reversed inbox in order to print them in the right order
			Inbox temp = new Inbox();
			Node p = top;
			while(p != null) {
				Node newItem = new Node(p.getElement(), p.getPriority(), temp.top);
				temp.push(newItem);
				p = p.next;
			}
			// print reversed inbox
			while(!temp.isEmpty()) {
				Node t = temp.pop();
				s += (t.getElement() + " ");
			}
			s += "<- top\n";

		}
		return s;
	}
}