package intlist;

public class Node {
	protected String element;
	protected Node next;
	public Node(String i, Node n) {
		element = i;
		next = n;
	}
	public String get_element() {return element;}
	public Node get_next() {return next;}
	public void set_element(String i) {element = i;}
	public void set_next(Node n) {next = n;}
}
