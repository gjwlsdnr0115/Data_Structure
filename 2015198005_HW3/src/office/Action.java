package office;

public class Action {
	private Inbox inbox;
	private QueueList q1;
	private QueueList q2;
	private QueueList q3;
	protected boolean entered;
	protected Read r;
	public String write = "";
	
	public Action(Inbox inbox, QueueList q1, QueueList q2, QueueList q3) {
		this.inbox = inbox;
		this.q1 = q1;
		this.q2 = q2;
		this.q3 = q3;
		entered = false;
		this.r = new Read(); 

		
	}
	
	public void enter() {
		entered = true;
		write += "ENTERED\n";
	}
	
	public void submit(String item, int p) {
		Node newItem = new Node(item, p, inbox.top);
		inbox.push(newItem);
		write += ("Submit: " + item + " Priority: " + p + "\n");
	}
	
	public void sort() {
		if(entered == false) {
			write += "Peter is not in the office\n";
		}
		else {
			if (inbox.isEmpty()) {
				write += "Inbox is empty\n";
			}
			else {
				r.reading = false;
				while(!inbox.isEmpty()) {
					Node n = inbox.pop();
					Node newItem = new Node(n.getElement(), n.getPriority(), null);
					if(newItem.getPriority() == 1) { q1.add(newItem); }
					else if(newItem.getPriority() == 2) { q2.add(newItem); }
					else { q3.add(newItem); }
				}
				write += "InBox Sorted\n";
			}
		}
	}
	
	public void withdrawInbox(String item) {
		Inbox temp = new Inbox();	// create temporary inbox
		Node t = inbox.top;
		// searching through inbox to find document
		while(t != null) {
			if(t.getElement().equals(item)) {	// if document found, continue to the next node
				t = t.next;
			}
			else {		// if document not found push it into the temporary inbox
				Node newItem = new Node(t.getElement(), t.getPriority(), temp.top);
				temp.push(newItem);
				t = t.next;
			}
		}
		
		// reverse temporary inbox to match order
		Node p = temp.top;
		Inbox reverse = new Inbox();
		while(p != null) {
			Node newItem = new Node(p.getElement(), p.getPriority(), reverse.top);
			reverse.push(newItem);
			p = p.next;
		}
		inbox = reverse;	// assign to inbox
	}
	
	public void withdrawQueue1(String item) {
		QueueList temp = new QueueList();		// create temporary queue
		Node t = q1.head;
		while(t != null) {
			if(t.getElement().equals(item)) {	// if document found, continue to the next node
				t = t.next;
			}
			else {			// if document not found push it into the temporary queue
				Node newItem = new Node(t.getElement(), t.getPriority(), null);
				temp.add(newItem);
				t = t.next;
			}
		}
		q1 = temp;		// assign to queue
		
	}
	public void withdrawQueue2(String item) {
		QueueList temp = new QueueList();
		Node t = q2.head;
		while(t != null) {
			if(t.getElement().equals(item)) {
				t = t.next;
			}
			else {
				Node newItem = new Node(t.getElement(), t.getPriority(), null);
				temp.add(newItem);
				t = t.next;
			}
		}
		q2 = temp;
		
	}
	public void withdrawQueue3(String item) {
		QueueList temp = new QueueList();
		Node t = q3.head;
		while(t != null) {
			if(t.getElement().equals(item)) {
				t = t.next;
			}
			else {
				Node newItem = new Node(t.getElement(), t.getPriority(), null);
				temp.add(newItem);
				t = t.next;
			}
		}
		q3 = temp;
		
	}
	
	
	public void withdraw(String item) {
		Node p = inbox.top;
		while(p != null) {
			if(p.getElement().equals(item)) {
				withdrawInbox(p.getElement());
				write += ("Document " + item + " removed from InBox\n");
				break;
			}
			p = p.next;
		}
		Node queue1 = q1.head;
		while(queue1 != null) {
			if(queue1.getElement().equals(item)) {
				withdrawQueue1(queue1.getElement());
				write += ("Document " + item + " removed from Queue 1\n");
				break;
			}
			queue1 = queue1.next;
		}
		Node queue2 = q2.head;
		while(queue2 != null) {
			if(queue2.getElement().equals(item)) {
				withdrawQueue2(queue2.getElement());
				write += ("Document " + item + " removed from Queue 2\n");
				break;
			}
			queue2 = queue2.next;
		}
		Node queue3 = q3.head;
		while(queue3 != null) {
			if(queue3.getElement().equals(item)) {
				withdrawQueue3(queue3.getElement());
				write += ("Document " + item + " removed from Queue 3\n");
				break;
			}
			queue3 = queue3.next;
		}
		if(p == null && queue1 == null && queue2 == null & queue3 == null) {	// if document was not found
			write += ("Document " + item + " not found\n");
		}
	}
	
	public void read() {
		if(entered == false) {
			write += "Peter in not in the office\n";
		}
		else {
			if(!q1.isEmpty()) {
				Node n = q1.remove();
				write += ("READ " + n.getElement() + "\n");
				r.reading = true;
				r.document = n.getElement();
				r.count++;
			}
			else if (!q2.isEmpty()) {
				Node n = q2.remove();
				write += ("READ " + n.getElement() + "\n");
				r.reading = true;
				r.document = n.getElement();
				r.count++;
			}
			else if (!q3.isEmpty()) {
				Node n = q3.remove();
				write += ("READ " + n.getElement() + "\n");
				r.reading = true;
				r.document = n.getElement();
				r.count++;
			}
			else {
				write += "There are no documents in the queue";
			}
		}
	}
	
	public void print() {
		write += "----------------------------------------\n";
		write += "|CURRENT OFFICE STATUS|\n";
		write += "----------------------------------------\n";
		
		if(r.reading == true) {
			write += ("Peter : READING " + r.getDocument() + "\n");
		}
		else {
			write += "Peter : IDLE\n";
		}
		
		write += "Inbox : ";
		write += inbox.printInbox();
		write += "Queue 1: ";
		write += q1.printQueue();
		write += "Queue 2: ";
		write += q2.printQueue();
		write += "Queue 3: ";
		write += q3.printQueue();
		
	}
	
	public void leave() {
		r.reading = false;
		write += "LEFTOffice\n";
		print();
		write += ("ReadCount: " + r.getCount() + "\n");
		entered = false;
	}
}
