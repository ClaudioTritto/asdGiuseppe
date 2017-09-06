package com.giuseppebrb.asd.exams.Lab20150903.datastructure;

import java.util.Iterator;

public class ArrList<S> implements AddOnlyList<S> {
	private S [] list = (S[]) new Object[1];
	private int n;
	
	public ArrList() {
		n = 0;
	}

	@Override
	public Iterator<S> iterator() {
		return new ArrListIterator(list, n);
	}

	@Override
	public void add(S e) {
		if(n == list.length){
			S [] temp = (S[]) new Object[2*list.length];
			System.arraycopy(list, 0, temp, 0, n);
			list = temp;
		}
		list[n] = e;
		n++;
	}
	
	private class ArrListIterator implements Iterator<S>{
		private S [] list = (S[]) new Object[1];
		private int n, pos;
		
		public ArrListIterator(S [] list, int n) {
			this.list = list;
			this.n = n;
			pos = 0;
		}

		@Override
		public boolean hasNext() {
			return pos < n;
		}

		@Override
		public S next() {
			S elem = list[pos];
			pos++;
			return elem;
		}
	}
	
	public static void main(String[] args) {
		ArrList<String> test = new ArrList<>();
		test.add("Questa");
		test.add("�");
		test.add("una");
		test.add("prova!");
		for(String s : test)
			System.out.println(s);
	}

}
