package office;

public class Read {
	protected boolean reading;
	protected String document;
	protected int count;
	
	public Read() {
		reading = false;
		document = null;
		count = 0;
	}
	public boolean isReading() {
		return reading;
	}
	public String getDocument() {
		return document;
	}
	public int getCount() {
		return count;
	}
}
