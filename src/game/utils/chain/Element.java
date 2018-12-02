package game.utils.chain;

class Element<T> {
	T t;
	Element<T> previous;
	Element<T> next;
	
	Element(T t) {
		this.t = t;
	}		
}