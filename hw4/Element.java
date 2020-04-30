package median;

public class Element implements Comparable<Element>{
	private int key;
	private String value;
	
	public Element(int key, String value) {
		this.key = key;
		this.value = value;
	}
	
	public int getKey() {
		return key;
	}
	public String getValue() {
		return value;
	}
	
	@Override
	public int compareTo(Element e) {		//compare key, smaller key first
		if(this.key < e.key) {
			return -1;
		}
		else if(this.key > e.key) {
			return 1;
		}
		return 0;
	}
}
