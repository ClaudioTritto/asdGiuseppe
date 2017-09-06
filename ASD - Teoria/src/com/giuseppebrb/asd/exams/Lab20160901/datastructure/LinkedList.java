package com.giuseppebrb.asd.exams.Lab20160901.datastructure;

import java.util.Iterator;

public class LinkedList<S> implements AddOnlyList<S> {
	private Record testa, coda;

	@Override
	public Iterator<S> iterator() {
		return new LinkedListIterator(testa);
	}

	@Override
	public void add(S e) {
		Record entry = new Record(e);
		if(testa == null){
			testa = coda = entry;
		}else {
			if(testa == coda){
				coda = entry;
				testa.next = coda;
			}else {
				coda.next = entry;
				coda = entry;
			}
		}
		
	}
	
	private class Record {
		Record next;
		S item;
		public Record(S item){
			this.item = item;
		}
	}
	
	private class LinkedListIterator implements Iterator<S>{
		private Record cursor;
		
		public LinkedListIterator(Record testa) {
			cursor = testa;
		}

		@Override
		public boolean hasNext() {
			return cursor != null;
		}

		@Override
		public S next() {
			S item = cursor.item;
			cursor = cursor.next;
			return item;
		}
	}
	
	public static void main(String[] args) {
		LinkedList<String> test = new LinkedList<>();
		test.add("This");
		test.add("is");
		test.add("a");
		test.add("test!");
		for(String s: test)
			System.out.println(s);
	}

}
