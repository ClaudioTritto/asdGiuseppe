package com.giuseppebrb.asd.exams.Lab20160225.datastructure;

public class ListaIndicizzataRD<T> implements ListaIndicizzata<T>{
	private T[] list = (T[]) new Object[1];
	private int n = 0;

	@Override
	public boolean isEmpty(int i) {
		if(i >= list.length)
			return true;
		return list[i] == null;
	}

	@Override
	public void addElement(T e, int i) {
		if(!isEmpty(i))
			throw new ItemAlreadyPresent("Errore durante inserimento");
		if(i >= list.length){
			T[] temp = (T[]) new Object[i+1];
			System.arraycopy(list, 0, temp, 0, list.length);
			list = temp;
		}
		list[i] = e;
		n++;
		
		if(n == list.length){
			T[] temp = (T[]) new Object[list.length * 2];
			System.arraycopy(list, 0, temp, 0, list.length);
			list = temp;
		}
	}

	@Override
	public T getElement(int i) {
		if(isEmpty(i))
			throw new UndefinedElementException();
		return list[i];
	}

	@Override
	public int numberElements() {
		return n;
	}

}
