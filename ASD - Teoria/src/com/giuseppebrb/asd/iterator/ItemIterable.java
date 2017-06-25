package com.giuseppebrb.asd.iterator;

import java.util.Iterator;

/**
 * Questa classe mostra la strutturazione di un oggetto ex-novo che implemnta un
 * proprio iteratore.
 * 
 * @author Giuseppe Barbato
 *
 * @param <T>
 */
public class ItemIterable<T> implements Iterable<T> {

	@Override
	public Iterator<T> iterator() {
		return new ItemIterator<T>();
	}

	private class ItemIterator<E> implements Iterator<E> {

		@Override
		public boolean hasNext() {
			return false;
		}

		@Override
		public E next() {
			return null;
		}

	}

}
