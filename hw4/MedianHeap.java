package median;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianHeap {
	private PriorityQueue<Element> bigger;		//queue with elements bigger than median
	private PriorityQueue<Element> smaller;		//queue with elements smaller than median
	private int median;		//median key
	
	public MedianHeap() {
		bigger = new PriorityQueue<Element>();		//minHeap
		smaller = new PriorityQueue<Element>(100, Collections.reverseOrder());	//maxHeap
		median = 0;
	}
	
	public int getMedianKey() {
		return median;
	}
	
	public void setMedianKey() {
		if(bigger.size() > smaller.size()) {
			median = bigger.peek().getKey();
		}
		else {
			median = smaller.peek().getKey();
		}
	}
	
	public void balancePQ() {
		if(bigger.size() - smaller.size() > 1) {
			Element e = bigger.poll();
			smaller.add(e);
		}
		else if(smaller.size() - bigger.size() > 1) {
			Element e = smaller.poll();
			bigger.add(e);
		}
	}
	
	public void insertElement(Element e) {
		if(bigger.size() == 0 && smaller.size() == 0) {		//if no elements, add to bigger
			bigger.add(e);
		}
		
		else if(bigger.size() > smaller.size()) {
			Element m = bigger.peek();		//median element
			if(m.getKey() > e.getKey()) {	//compare key
				smaller.add(e);
			}
			else {
				bigger.add(e);
			}
		}
		else {
			Element m = smaller.peek();
			if(m.getKey() > e.getKey()) {
				smaller.add(e);
			}
			else {
				bigger.add(e);
			}
		}
		balancePQ();		//balance queues
		setMedianKey();		//reset median key
	}
	public Element deleteMedian() {
		Element m;
		if(bigger.size() > smaller.size()) {
			m = bigger.poll();
		}
		else {		//if bigger.size() <= smaller.size()
			m = smaller.poll();
		}
		balancePQ();
		return m;
	}
	
	
}
