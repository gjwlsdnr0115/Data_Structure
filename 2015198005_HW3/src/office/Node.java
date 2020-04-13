package office;

public class Node {
	protected String element;
	protected Node next;
	protected int priority;
	public Node(String i, int p, Node n) {
		element = i;
		priority = p;
		next = n;
	}
	
	public String getElement() {return element;}
	public int getPriority() {return priority;}
	public Node getNext() {return next;}
	public void setElement(String i) {element = i;}
	public void setNext(Node n) {next = n;}
}
