package com.giuseppebrb.asd.exams.Lab20160118.datastructure;

import java.util.Iterator;

public class IndexedAL<T> implements IndexedList<T> {
	private int n = 0;
	private T[] list = (T[]) new Object[1];

	@Override
	public Iterator<T> iterator() {
		return new IndexedALIterator(list, n);
	}

	@Override
	public boolean isEmpty(int i) {
		if(i>= list.length)
			throw new RuntimeException("Out Of Border");
		if(list[i] != null)
			return false;
		return true;
	}

	@Override
	public void addItem(T e, int i) {
		if(e == null)
			throw new RuntimeException("Cannot insert a null item");
		
		if(i >= list.length){
			T[] temp = (T[]) new Object[i+1];
			System.arraycopy(list, 0, temp, 0, list.length);
			list = temp;
		}
		
		if(n == list.length){
			T[] temp = (T[]) new Object[list.length * 2];
			System.arraycopy(list, 0, temp, 0, n);
			list = temp;
		}
		
		if(list[i] != null)
			throw new ItemAlreadyPresent();
		list[i] = e;
		n++;
		
	}

	@Override
	public void delItem(int i) {
		if(i>= list.length)
			throw new RuntimeException("Out Of Border");
		if(list[i] == null)
			throw new ItemNotPresent();
		
		list[i] = null;
		n--;
		
		if(n == list.length / 4){
			T[] temp = (T[]) new Object[list.length / 2];
			System.arraycopy(list, 0, temp, 0, n);
			list = temp;
		}
	}

	@Override
	public T getItem(int i) {
		if(i>= list.length)
			throw new RuntimeException("Out Of Border");
		if(list[i] == null)
			throw new ItemNotPresent();
		return list[i];
	}

	@Override
	public int numberItems() {
		return n;
	}
	
	private class IndexedALIterator implements Iterator<T>{
		private T[] list;
		private int n, scannedCounter, pos;
		public IndexedALIterator(T[] list, int n) {
			this.list = list;
			this.n = n;
			scannedCounter = pos = 0;
		}
		@Override
		public boolean hasNext() {
			return scannedCounter < n;
		}
		@Override
		public T next() {
			while(list[pos] == null)
				pos++;
			T elem = list[pos];
			scannedCounter++;
			pos++;
			return elem;
		}

		
	}
	
	public static void main(String[] args) {
		IndexedAL<String> test = new IndexedAL<>();
		test.addItem("Questa", 0);
		test.addItem("�", 10);
		test.addItem("una", 20);
		test.addItem("prova", 30);
		System.out.println(test.isEmpty(20));
		for(String s : test)
			System.out.println(s);
	}
}
