package com.giuseppebrb.asd.exams.Lab20160208.datastructure;

import java.util.Iterator;

public class IndexedAL<T> implements IndexedList<T>{
	private T [] list = (T[]) new Object[1];
	private int n;
	
	public IndexedAL() {
		n = 0;
	}

	@Override
	public Iterator<T> iterator() {
		return new IndexedALIterator(list, n);
	}

	@Override
	public boolean isEmpty(int i) {
		if(i >= list.length)
			return true;
		if(list[i] != null)
			return false;
		return true;
	}

	@Override
	public void addItem(T e, int i) {
		if(!isEmpty(i))
			throw new ItemAlreadyPresent("Errore durante l'inserimento dell'elemento");
		
		if(i >= list.length){
			T [] temp = (T[]) new Object[i+1];
			System.arraycopy(list, 0, temp, 0, list.length);
			list = temp;
		}
		list[i] = e;
		n++;
		
		if(n == list.length){
			T [] temp = (T[]) new Object[list.length * 2];
			System.arraycopy(list, 0, temp, 0, list.length);
			list = temp;
		}
	}

	@Override
	public void delItem(int i) {
		if(isEmpty(i))
			throw new ItemNotPresent("Errore durante la cancellazione");
		list[i] = null;
		n--;
		if(n == list.length/4){
			T [] temp = (T[]) new Object[list.length/ 2];
			System.arraycopy(list, 0, temp, 0, list.length);
			list = temp;
		}
	}

	@Override
	public T getItem(int i) {
		if(isEmpty(i))
			throw new ItemNotPresent("Errore durante il retrieving");
		return list[i];
	}

	@Override
	public int numberItems() {
		return n;
	}
	
	private class IndexedALIterator implements Iterator<T>{
		private T [] list;
		private int items, pos, scanned;
		public IndexedALIterator(T[] list, int items) {
			this.list = list;
			this.items = items;
			pos = 0;
			scanned = 0;
		}
		@Override
		public boolean hasNext() {
			return scanned < items;
		}

		@Override
		public T next() {
			while(list[pos] == null)
				pos++;
			T item = list[pos];
			pos++;
			scanned++;
			return item;
		}
	}
	
	public static void main(String[] args) {
		IndexedAL<String> test = new IndexedAL<>();
		test.addItem("Questa", 20);
		test.addItem("�", 21);
		test.addItem("una", 35);
		test.addItem("prova", 50);
		test.addItem("cazzo", 51);
		test.delItem(51);
		System.out.println("Numero elementi: " + test.numberItems());
		for(String s : test)
			System.out.println(s);
	}
}
