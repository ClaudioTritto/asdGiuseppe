package com.giuseppebrb.asd.exams.Lab20150331.datastructure;

import java.util.Iterator;

public class BDTPF<E> implements BDT<E> {
	
	private E radice;
	private BDTPF<E> sin;
	private BDTPF<E> des;
	public BDTPF(E decision){
		radice = decision;
		sin = null;
		des = null;
	}
	
	public BDTPF(BDT<E> sin, E u, BDT<E> des) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean foglia() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E decisione() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E predicato() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BDT<E> sin(BDT<E> albero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BDT<E> des(BDT<E> albero) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private class BDTPFIterator implements Iterator<E>{

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

}
