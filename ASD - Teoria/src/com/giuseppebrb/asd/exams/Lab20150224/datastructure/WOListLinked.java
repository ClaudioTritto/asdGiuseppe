package com.giuseppebrb.asd.exams.Lab20150224.datastructure;

import java.util.Iterator;

public class WOListLinked implements ListaOrdinata {
	
	private Couple<Comparable> head;
	private int n;
	
	public WOListLinked() {
		n = 0;
	}

	@Override
	public Iterator iterator() {
		return new WOListLinkedIterator<>(head);
	}

	@Override
	public void insert(Comparable e) {
		Couple<Comparable> entry = new Couple<Comparable>(e);
		if(n == 0)
			head = entry;
		else{
			if(entry.elem.compareTo(head.elem) > 0){
				entry.next = head;
				head = entry;
			}else{
				for(Couple<Comparable> pos = head; pos.next != null; pos = pos.next){
					if(pos.next == null){
						pos.next = entry;
						break;
					} else if(entry.elem.compareTo(pos.next.elem) > 0){
						entry.next = pos.next;
						pos.next = entry;
						break;
					}
				}
			}
		}
		n++;
	}

	@Override
	public int numElementi() {
		return n;
	}
	
	private class Couple<T>{
		T elem;
		Couple<T> next;
		
		public Couple(T elem) {
			this.elem = elem;
			next = null;
		}
	}
	
	private class WOListLinkedIterator<T> implements Iterator<T>{
		private Couple<T> head;
		
		public WOListLinkedIterator(Couple<T> head) {
			this.head = head;
		}
		
		@Override
		public boolean hasNext() {
			return head.next != null;
		}

		@Override
		public T next() {
			T elem = head.elem;
			head = head.next;
			return elem;
		}
		
	}
	
	
	public static void main(String [] args){
		WOListLinked list = new WOListLinked();
		list.insert("1");
		list.insert("2");
		list.insert("3");
		list.insert("4");
		list.insert("5");
		System.out.println("Num. elementi:" + list.numElementi());
		for(Object e : list)
			System.out.println(e.toString());
	}

}
