package com.giuseppebrb.asd.exams.Lab20150331.datastructure;

public interface BDT<E> extends Iterable<E> {
	public boolean foglia();
	public E decisione();
	public E predicato();
	public BDT<E> sin(BDT<E> albero);
	public BDT<E> des (BDT<E> albero);
}
