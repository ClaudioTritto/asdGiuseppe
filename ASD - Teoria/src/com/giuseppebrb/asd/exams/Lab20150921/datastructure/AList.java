package com.giuseppebrb.asd.exams.Lab20150921.datastructure;

public class AList implements ListaSemplice {
	private Record head, tail, cursor;
	
	public AList() {
		head = null;
		tail = null;
		cursor = head;
	}
	
	private class Record{
		Object item;
		Record next, prev;
		
		public Record(Object item) {
			this.item = item;
		}
	}

	@Override
	public void add(Object e) {
		Record entry = new Record(e);
		if(head == null){
			head = tail = entry;
			cursor = head;
		} else{
			if(head == tail){
				entry.prev = head;
				tail = entry;
				head.next = tail;
			} else {
				entry.prev = tail;
				tail.next = entry;
				tail = entry;
			}
		}
	}

	@Override
	public void reset() {
		cursor = head;
	}

	@Override
	public Object next() {
		Object elem = cursor.item;
		cursor = cursor.next;
		return elem;
	}

	@Override
	public boolean hasNext() {
		return cursor != null;
	}
	
	public static void main(String[] args) {
		AList list = new AList();
		list.add("Questa");
		list.add("�");
		list.add("una");
		list.add("prova!");
		
		while(list.hasNext())
			System.out.println(list.next());
	}

}
