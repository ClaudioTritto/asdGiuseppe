package com.giuseppebrb.asd.exams.Lab20150702.datastructure;

import java.util.Iterator;

public class ArrayDoubling<S> implements Dictionary<S> {
	private Pair<S, Comparable> s [] = new Pair[1];
	private int n = 0;
	
	private class Pair<V, K>{
		V elem;
		K key;
		public Pair(V elem, K key){
			this.elem = elem;
			this.key = key;
		}
	}

	@Override
	public Iterator<Comparable> iterator() {
		return new ArrayDoublingIterator(s, n);
	}

	@Override
	public void insert(S e, Comparable k) {
		Pair<S, Comparable> entry = new Pair<>(e, k);
		if(n == s.length){
			Pair<S, Comparable> temp [] = new Pair[2 * s.length];
			System.arraycopy(s, 0, temp, 0, n);
			s = temp;
		}
		s[n] = entry;
		n++;
	}

	@Override
	public void delete(Comparable k) {
		int i;
		for(i=0; i < s.length; i++){
			if(s[i].key.compareTo(k) == 0){
				break;
			}
		}
		if(i == s.length)
			throw new ChiaveNonValida();
		n--;
		s[i] = s[n];
		if(n > 1 && n == s.length / 4){
			Pair<S, Comparable> temp [] = new Pair[s.length / 2];
			System.arraycopy(s, 0, temp, 0, n);
			s = temp;
		}
	}

	@Override
	public S search(Comparable k) {
		for(int i=0; i < n; i++){
			if(s[i].key.compareTo(k) == 0)
				return s[i].elem;
		}
		return null;
	}
	
	private class ArrayDoublingIterator implements Iterator<Comparable>{
		private Pair<S, Comparable> s [] = new Pair[1];
		private int pos, n = 0;
		
		public ArrayDoublingIterator(Pair<S, Comparable> s [], int n) {
			this.s = s;
			this.n = n;
			pos = 0;
		}

		@Override
		public boolean hasNext() {
			return pos < n;
		}

		@Override
		public Comparable next() {
			Comparable k = s[pos].key;
			pos++;
			return k;
		}
		
	}
	
	public static void main(String[] args){
		ArrayDoubling<String> lista = new ArrayDoubling<>();
		lista.insert("Questa", 1);
		lista.insert("�", 2);
		lista.insert("Una prova", 3);
		System.out.println("Elemento posizione 2: " + lista.search(2));
		
		for(Comparable k : lista)
			System.out.println(k);
	}

}
