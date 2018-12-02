package game.utils.chain;

import java.util.Iterator;

class ChainIterator<T> implements Iterator<T>{
	private Chain<T> chain;
	private Element<T> next, lastChecked;
	
	public ChainIterator(Chain<T> chain) {
		this.chain = chain;
	}

	@Override
	public boolean hasNext() {			
		return (next != null);
	}

	@Override
	public T next() {
		lastChecked = next;
		T result = lastChecked.t;	
		
		next = next.previous;
		
		return result;
	}
	
	public ChainIterator<T> reset() {
		this.next = chain.last;
		return this;
	}
	
	public Element<T> getLastCheckedElement() {		
		return lastChecked;
	}
}