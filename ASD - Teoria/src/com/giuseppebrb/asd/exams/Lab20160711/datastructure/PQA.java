package com.giuseppebrb.asd.exams.Lab20160711.datastructure;

import java.util.Iterator;

public class PQA<Item> implements PQ<Item> {
	protected Record coda;
	private int n=0;
	
	private class Record{
		public Item elem;
		public int priority;
		public Record next;
		public Record(Item elem, int priority) {
			this.elem = elem;
			this.priority = priority;
			next = null;
		}
	}

	@Override
	public Iterator<Item> iterator() {
		return new PQAIterator(coda);
	}

	@Override
	public boolean isNew() {
		return n == 0;
	}

	@Override
	public void insert(Item i, int priority) {
		Record entry = new Record(i, priority);
		if(coda == null)
			coda = entry;
		else{
			if(priority < coda.priority){
				entry.next = coda;
				coda = entry;
			} else {
				Record cursor = coda;
				while(cursor.next != null){
					if(cursor.next.priority > priority){
						entry.next = cursor.next;
						cursor.next = entry;
						break;
					}
					cursor = cursor.next;
				}
			}
		}
		n++;
	}

	@Override
	public Item first() {
		if(coda == null)
			throw new StrutturaVuotaException("Struttura vuota");
		return coda.elem;
	}

	@Override
	public void delFirst() {
		if(coda == null)
			throw new StrutturaVuotaException("Struttura vuota");
		coda = coda.next;
		n--;
	}

	@Override
	public void changePriority(Item i, int priority) {
		boolean found = false;
		if(coda == null)
			throw new StrutturaVuotaException("Struttura vuota");
		for(Record pos = coda; pos != null; pos = pos.next){
			if(pos.next.equals(i)){
				pos.next = pos.next.next;
				found = true;
				break;
			}
		}
		if(found == false)
			throw new ItemNotFound("Elemento non trovato");
		insert(i, priority);
	}

	@Override
	public int getPriority(Item i) {
		boolean found = false;
		int result = -1;
		if(coda == null)
			throw new StrutturaVuotaException("Struttura vuota");
		Record cursor = coda;
		while(cursor != null){
			if(cursor.equals(i)){
				result = cursor.priority;
				found = true;
				break;
			}
			cursor = cursor.next;
		}
		
		if(found == false)
			throw new ItemNotFound("Elemento non trovato");
		return result;
	}

	@Override
	public int size() {
		return n;
	}
	
	private class PQAIterator implements Iterator<Item>{
		private Record cursor;
		
		public PQAIterator(Record coda) {
			this.cursor = coda;
		}

		@Override
		public boolean hasNext() {
			return cursor != null;
		}

		@Override
		public Item next() {
			Item i = cursor.elem;
			cursor = cursor.next;
			return i;
		}
	}
	
	public static void main(String[] args) {
		PQA<String> test = new PQA<>();
		String [] dict = {"Uno", "Due", "Tre", "Quattro", "Cinque"};
		test.insert(dict[4], 5);
		test.insert(dict[2], 3);
		test.insert(dict[0], 1);
		test.insert(dict[1], 2);
		test.insert(dict[3], 4);
		System.out.println("Numero " + test.size());
		for(String s : test)
			System.out.println(s);
		
	}

}
