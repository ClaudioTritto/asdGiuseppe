package com.giuseppebrb.asd.exams.Lab20150203.datastructure;

import java.util.Iterator;
import java.util.LinkedList;

public class HashDict<S> implements Dictionary<S> {
	private LinkedList<Pair<S>> S[];
	
	public HashDict(int n){
		S = new LinkedList[n];
	}
	
	private int h(Comparable k){
		return Math.abs(k.hashCode()) % S.length;
	}

	@Override
	public Iterator<Comparable> iterator() {
		return new HashDictIterator(S);
	}

	@Override
	public void insert(S e, Comparable k) {
		int index = h(k);
		if(S[index] == null)
			S[index] = new LinkedList<>();
		S[index].add(new Pair<S>(e, k));
		
	}

	@Override
	public void delete(Comparable k) {
		int index = h(k);
		if(S[index] == null)
			throw new ItemNotFoundException();
		for(Pair<S> pair : S[index])
			if(pair.key.equals(k))
				S[index].remove(pair);
		
	}

	@Override
	public S search(Comparable k) {
		int index = h(k);
		for(Pair<S> pair : S[index])
			if(pair.key.equals(k))
				return pair.item;
		return null;
	}
	
	private class HashDictIterator implements Iterator<Comparable>{
		private LinkedList<Pair<S>> S[];
		private int index = 0, pos = 0;
		
		public HashDictIterator(LinkedList<Pair<S>> S[]) {
			this.S = S;
		}

		@Override
		public boolean hasNext() {
			if (index >= S.length)
                return false;
			while (S[index] == null || S[index].size() == 0) {
                index++;

                if (index >= S.length) {
                    return false;
                }
            }
			
			return true;
		}

		@Override
		public Comparable next() {
			Comparable e = S[index].get(pos).key;
			if(pos >= S[index].size()-1){
				pos = 0;
				index++;
			}else
				pos++;
			return e;
		}
		
	}
	
	private class Pair<S>{
		S item;
		Comparable key;
		public Pair(S item, Comparable k){
			this.item = item;
			key = k;
		}
	}
	
	public static void main(String[] args){
		HashDict<String> hash = new HashDict<>(6);
		hash.insert("uno", 1);
		hash.insert("uno", 1);
		hash.insert("due", 2);
		hash.insert("uno", 3);
		
		for(Comparable<String> s : hash){
			System.out.println(s);
		}
	}

}
