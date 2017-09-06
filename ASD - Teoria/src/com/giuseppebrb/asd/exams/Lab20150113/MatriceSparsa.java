package com.giuseppebrb.asd.exams.Lab20150113;

import java.util.ArrayList;
import java.util.Iterator;

public class MatriceSparsa<T> implements Iterable<T> {
	
	protected ArrayList<Record<T>> [] valori;
	private T defaultElement;
	
	public MatriceSparsa(int n, int m, T defaultElement){
		this.defaultElement = defaultElement;
		if(n == 0 || m == 0)
			throw new MatriceSparsaCreationException("Una delle due dimensioni inserite � uguale a 0");
		valori = new ArrayList[n];
		for(int i=0; i < n; i++){
			valori[i] = new ArrayList<>();
			for(int j=0; j < m; j++){
				valori[i].add(new Record<T>(defaultElement, j));
			}
		}
	}
	
	public void cambiaValore(int n, int m, T e){
		if(n >= valori.length || m >= valori[0].size())
			throw new IndexOutOfBoundsException();
		valori[n].add(m, new Record<T>(e, m));
	}
	
	public T valore(int n, int m){
		if(n >= valori.length || m >= valori[0].size())
			throw new IndexOutOfBoundsException();
		return valori[n].get(m).valore;
	}
	
	public int numRighe(){
		return valori.length;
	}
	
	public int numCol(){
		return valori[0].size();
	}
	
	public int numValoriSignificativi(){
		int count = 0;
		for(int i=0; i < valori.length; i++){
			for(int j=0; j < valori[0].size()-1; j++){
				if(valori[i].get(j).valore != defaultElement)
					count++;
			}
		}
		return count;
	}

	@Override
	public Iterator<T> iterator() {
		return new MatriceSparsaIterator(valori);
	}
	
	private class Record<E>{
		E valore;
		int colonna;
		
		public Record(E valore, int colonna){
			this.valore = valore;
			this.colonna = colonna;
		}
	}
	
	private class MatriceSparsaIterator implements Iterator<T>{
		private ArrayList<Record<T>> [] valori;
		private int currentRow, currentCol;
		
		public MatriceSparsaIterator(ArrayList<Record<T>> [] valori){
			this.valori = valori;
			currentRow = 0;
			currentCol = 0;
		}

		@Override
		public boolean hasNext() {
			if(currentRow < valori.length && currentCol < valori[0].size())
				return true;
			return false;
		}

		@Override
		public T next() {
			T elem = valori[currentRow].get(currentCol).valore;
			if(currentCol < valori[0].size())
				currentCol++;
			else{
				currentCol = 0;
				currentRow++;
			}
			return elem;
		}
		
	}
	
	public static void main(String[] args){
		MatriceSparsa<Integer> matrice =new MatriceSparsa<>(4, 6, 0);
		System.out.println("Righe: " + matrice.numRighe());
		System.out.println("Col: " + matrice.numCol());
		
		matrice.cambiaValore(3, 5, 800);
		matrice.cambiaValore(2, 5, 90);
		matrice.cambiaValore(0, 2, 10);
		System.out.println("Valori non nulli: " + matrice.numValoriSignificativi());
		System.out.println("Cella 3x5: " + matrice.valore(3, 5));
		System.out.println("Cella 0x2: " + matrice.valore(0, 2));
	}

}
