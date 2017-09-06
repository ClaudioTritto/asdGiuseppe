package com.giuseppebrb.asd.exams.Lab20160411.datastructure;

import java.util.Iterator;

public class VectorList<S> implements AddOnlyList<S> {
	private int n=0;
	private S [] list = (S[]) new Object[1];

	@Override
	public Iterator<S> iterator() {
		return new VectorListIterator(list, n);
	}

	@Override
	public void add(S e) {
		if(n == list.length){
			S [] temp = (S[]) new Object[list.length * 2];
			System.arraycopy(list, 0, temp, 0, n);
			list = temp;
		}
		list[n] = e;
		n++;
	}
	
	private class VectorListIterator implements Iterator<S>{
		private int n, pos;
		private S [] list;
		
		public VectorListIterator(S [] list, int n) {
			this.n = n;
			this.list = list;
			pos = 0;
		}

		@Override
		public boolean hasNext() {
			return pos < n;
		}

		@Override
		public S next() {
			S item = list[pos];
			pos++;
			return item;
		}
	}
	
	public static void main(String[] args) {
		VectorList<String> test = new VectorList<>();
		test.add("This");
		test.add("is");
		test.add("a");
		test.add("test!");
		for(String s : test)
			System.out.println(s);
	}
	
}
