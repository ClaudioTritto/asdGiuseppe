package com.giuseppebrb.asd.exams.Lab20160225.datastructure;

public interface ListaIndicizzata<T> {
	public boolean isEmpty(int i);
	public void addElement(T e, int i);
	public T getElement(int i);
	public int numberElements();
}
