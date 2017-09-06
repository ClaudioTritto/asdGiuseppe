package com.giuseppebrb.asd.exams.Lab20160411.datastructure;

import java.util.Iterator;

public class LinkedDict<K, V> implements Dictionary<K, V> {
	private Pair head=null, tail=null;
	private class Pair{
		K key;
		V value;
		Pair next;
		public Pair(K key, V value) {
			this.key = key;
			this.value = value;
			next = null;
		}
	}

	@Override
	public Iterator<K> iterator() {
		return new LinkedDictIterator(head);
	}

	@Override
	public void insert(K key, V value) {
		Pair entry = new Pair(key, value);
		if(head == null)
			head = tail = entry;
		else{
			if(head == tail){
				tail = entry;
				head.next = tail;
			} else {
				tail.next = entry;
				tail = entry;
			}
		}
	}

	@Override
	public void delete(K key) {
		
	}

	@Override
	public V search(K key) {
		boolean found = false;
		Pair puntatore = head;
		while(puntatore != null && found == false){
			if(puntatore.key.equals(key)){
				found = true;
				break;
			}
			puntatore = puntatore.next;
		}
		if(found == false)
			throw new ItemNotFoundException("Elemento non trovato");
		return puntatore.value;
	}
	
	private class LinkedDictIterator implements Iterator<K>{
		private Pair puntatore;
		
		public LinkedDictIterator(Pair puntatore) {
			this.puntatore = puntatore;
		}

		@Override
		public boolean hasNext() {
			return puntatore != null;
		}

		@Override
		public K next() {
			K item = puntatore.key;
			puntatore = puntatore.next;
			return item;
		}
		
	}
	
	public static void main(String[] args) {
		LinkedDict<String, String> test = new LinkedDict<>();
		test.insert("1", "One");
		test.insert("2", "Two");
		test.insert("3", "Three");
		test.insert("4", "Four");
		test.insert("5", "Five");
		
		System.out.println(test.search("5"));
		
		for(String s:test)
			System.out.println(s);
	}
}
