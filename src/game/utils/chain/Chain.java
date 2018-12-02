package game.utils.chain;

import java.util.Iterator;

public class Chain<T> implements Iterable<T>{
	Element<T> last;
	
	public T getLast() {
		if (last == null)
			return null;
		
		return last.t;
	}
	
	public void add(T t) {
		Element<T> newElement = new Element<T>(t);
		
		if (last == null)
			last = newElement;
		else {
			last.next = newElement;
			newElement.previous = last;
			last = newElement;
		}		
	}
	
	public void remove(T t) {
		removeElement(findElementFromEnd(t));	
	}
	
	private Element<T> findElementFromEnd(T t) {
		for (T tmpT : this)
			if (tmpT == t)
				return iteratorInstance.getLastCheckedElement();
		return null;
	}		
	
	private void removeElement(Element<T> element) {
		if (element == null)
			return;
		
		if (element.previous != null)
			element.previous.next = element.next;
		
		if (element.next != null)
			element.next.previous = element.previous;
		else
			last = element.previous;
	}
	
	@Override	
	public String toString() {
		String result = "";
		
		for (T t : this)
			result = t.toString() + " " + result;

		return result;
	}
	
	private ChainIterator<T> iteratorInstance = new ChainIterator<T>(this);
	
	@Override
	public Iterator<T> iterator() {		
		return iteratorInstance.reset();
	}
	
	@SuppressWarnings("unused")
	private Element<T> findElementFromEndFast(T t) {
		Element<T> inspected = last;
		
		while (!(inspected == null || inspected.t == t)) 
			inspected = inspected.previous;		
		
		return inspected;	
	}		
}
