package com.giuseppebrb.asd.exams.Lab20150702.datastructure;

import java.util.Iterator;

public class AddOnlyLinkedList<S> implements AddOnlyList<S> {
	private Record head;
	private int n;
	
	public AddOnlyLinkedList() {
		head = null;
		n = 0;
	}

	@Override
	public Iterator<S> iterator() {
		return new AddOnlyLinkedListIterator(head);
	}

	@Override
	public void add(S e) {
		Record entry = new Record(e);
		if(head == null)
			head = entry;
		else{
			for(Record pos = head; pos != null; pos = pos.next){
				if(pos.next == null){
					entry.next= null;
					pos.next = entry;
					break;
				}
			}
		}
		n++;
	}

	@Override
	public int size() {
		return n;
	}
	
	private class Record{
		S item;
		Record next;
		
		public Record(S item){
			this.item = item;
			next = null;
		}
	}
	
	private class AddOnlyLinkedListIterator implements Iterator<S>{
		private Record puntatore;
		
		public AddOnlyLinkedListIterator(Record head) {
			this.puntatore = head;
		}

		@Override
		public boolean hasNext() {
			return puntatore != null;
		}

		@Override
		public S next() {
			S elem = puntatore.item;
			puntatore = puntatore.next;
			return elem;
		}	
	}
	
	public static void main(String [] args){
		AddOnlyLinkedList<String> l = new AddOnlyLinkedList<>();
		l.add("Questa");
		l.add("�");
		l.add("una");
		l.add("prova");
		System.out.println("Dimensione: " + l.size());
		for(String s : l)
			System.out.println(s);
	}

}
