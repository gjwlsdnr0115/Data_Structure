package office;

public class QueueList {
	protected Node head;
	protected Node tail;
	protected int size;
	public QueueList() {
		head = null;
		tail = null;
		size = 0;
	}
	public int size() {return size;}
	public boolean isEmpty() {return size == 0;}
	public void add(Node newItem) {
		Node ptail = tail;
		tail = newItem;
		if(size == 0) {head = tail;}
		else {ptail.setNext(tail);}
		size++;
	}
	public Node remove() {
		Node temp = head;
		head = head.getNext();
		size--;
		if(size == 0) {tail = null;}
		return temp;
	}
	
	public String printQueue() {
		String s = "";
		if(isEmpty()) {
			s += "EMPTY\n";
		}
		else {
			// create stack data sturcture inbox in order to reverse queue order
			Inbox temp = new Inbox();
			Node p = head;
			while(p != null) {
				Node newItem = new Node(p.getElement(), p.getPriority(), temp.top);
				temp.push(newItem);
				p = p.next;
			}
			// print contents
			while(!temp.isEmpty()) {
				Node t = temp.pop();
				s += (t.getElement() + " ");
			}
			s += "<- front\n";

		}
		return s;
	}
}
