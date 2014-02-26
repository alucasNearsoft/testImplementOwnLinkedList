import java.util.Iterator;

class Nodo<Item> {
	private Item data;
	private Nodo<Item> next;
	
	public Nodo(Item data) {
		this.data = data;
		setNext(null);
	}
	
	public void setNext(Nodo<Item> next) {
		this.next = next;
	}
	
	public Nodo<Item> getNext() {
		return next;
	}
	
	public Item getData() {
		return data;
	}
}

class LinkedList<Item> implements Iterable<Nodo<Item>> {

	private Nodo<Item> front;
	
	public LinkedList(Item data) {
		front = new Nodo<>(data);
	}
	
	public void addNodo (Item data) {
		Nodo<Item> tempNodo = new Nodo<>(data);
		tempNodo.setNext(front);
		front = tempNodo;
	}
	
	public String toString() {
		Nodo<Item> tempNodo = front;
		StringBuilder output = new StringBuilder();
		while ( tempNodo != null ) {
			output.append(tempNodo.getData()).append(" ");
			tempNodo = tempNodo.getNext();
		}
		return output.toString();
	}
	
	@Override
	public Iterator<Nodo<Item>> iterator() {
		return new ListIterator();
	}

	// Inner class defining iterator objects for this linked list
	protected class ListIterator implements Iterator<Nodo<Item>> {
		private Nodo<Item> iterNodo;
		// Constructor
		public ListIterator() {
			// Code to initialize the iterator...
			iterNodo = front;
		}
		// Method to test whether more elements are available
		public boolean hasNext() {
			// Code to determine if there are more elements...
			return iterNodo != null;
		}
		// Method to return the next available object from the linked list
		public Nodo<Item> next() {
			// Code to return the next element...
			Nodo<Item> aux = iterNodo;
			if(aux == null) {
				throw new java.util.NoSuchElementException();
			}
			iterNodo = iterNodo.getNext();
			return aux;
		}
		
		// Any other members needed for ListIterator<T>...
		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
	}
}

public class MyLinkedList {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<String> testLinkList = new LinkedList<>("1");
		testLinkList.addNodo("2");
		testLinkList.addNodo("3");
		testLinkList.addNodo("4");
		
		Iterator<Nodo<String>> it = testLinkList.iterator();
		while (it.hasNext()) {
			System.out.print(it.next().getData() + " ");
		}
		
		System.out.println();
		for (Nodo<String> node : testLinkList) {
			System.out.print(node.getData() + " ");
		}
	}
}
