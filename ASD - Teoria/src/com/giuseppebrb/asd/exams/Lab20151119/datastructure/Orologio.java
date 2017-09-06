package com.giuseppebrb.asd.exams.Lab20151119.datastructure;

import java.util.Iterator;

public class Orologio<S> implements CircQueue<S> {
	
	private Record<S> head, tail;
	private int n;
	
	public Orologio() {
		head = tail = null;
		n = 0;
	}

	@Override
	public Iterator<S> iterator() {
		return new OrologioIterator(head, tail, n);
	}

	@Override
	public void add(S e) {
		Record<S> entry = new Record<S>(e);
		if(head==null){
			head = tail = entry;
			head.next = tail;
			tail.next = head;
		}else{
			if(head == tail){
				entry.next = head;
				tail = entry;
				head.next = tail;
			} else {
				tail.next = entry;
				entry.next = head;
				tail = entry;
			}
		}
		n++;
	}

	@Override
	public S value() {
		if(head == null)
			throw new EmptyStructureException();
		return head.elem;
	}

	@Override
	public boolean isEmpty() {
		return n==0;
	}

	@Override
	public void rotateF() {
		if(head == null)
			throw new EmptyStructureException();
		head = head.next;
		tail = tail.next;
	}

	@Override
	public int size() {
		return n;
	}

	@Override
	public boolean equals(CircQueue<S> s) {
		boolean equal = false;
		if(this.size() == s.size())
			for(S elem : this)
				for(S item : s){
					if(elem == item)
						equal = true;
					if(equal == false)
						return false;
				}
		else
			return false;
							
		return true;
	}
	
	private class Record<S>{
		S elem;
		Record<S> next;
		public Record(S elem) {
			this.elem = elem;
		}
	}
	
	private class OrologioIterator implements Iterator<S>{
		private Record<S> head, tail;
		private int n, pos;
		
		public OrologioIterator(Record<S> head, Record<S> tail, int n) {
			this.head = head;
			this.tail = tail;
			this.n = n;
			pos = 0;
		}
		
		@Override
		public boolean hasNext() {
			return pos < n;
		}

		@Override
		public S next() {
			S elem = head.elem;
			head = head.next;
			pos++;
			return elem;
		}
	}
	
	public static void main(String[] args) {
		Orologio<String> test = new Orologio<>();
		test.add("1");
		test.add("2");
		test.add("3");
		test.add("4");
		
		Orologio<String> test1 = new Orologio<>();
		test1.add("1");
		test1.add("2");
		test1.add("3");
		test1.add("4");
		
		System.out.println("� vuoto: " + test.isEmpty());
		System.out.println("Dimensione: " + test.size());
		System.out.println("1� elemento: " + test.value());
		test.rotateF();
		System.out.println("2� elemento: " + test.value());
		
		System.out.println("Equals a test 1? " + test.equals(test1));
		
		System.out.println("Tutti gli elementi");
		for(String s : test)
			System.out.println(s);
	}

}
