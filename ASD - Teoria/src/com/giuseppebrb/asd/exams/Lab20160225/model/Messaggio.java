package com.giuseppebrb.asd.exams.Lab20160225.model;

import com.giuseppebrb.asd.exams.Lab20160225.datastructure.ListaIndicizzata;
import com.giuseppebrb.asd.exams.Lab20160225.datastructure.ListaIndicizzataRD;

public class Messaggio {
	private ListaIndicizzata<Datagramma> messaggio = new ListaIndicizzataRD<>();
	private int ultimo = -1;
	
	public void addDatagramma(Datagramma datagramma){
		messaggio.addElement(datagramma, datagramma.getIdentificativo());
	}
	
	public boolean completo(){
		boolean result = false;
		int found=0, i=0;
		while(found < messaggio.numberElements()){
			while(messaggio.isEmpty(i))
				i++;
			if(messaggio.getElement(i).isUltimo()){
				result = true;
				break;
			}
			i++;
			found++;
		}
		return result;
	}
	
	public boolean esisteDatagramma(int i){
		 return messaggio.isEmpty(i);
	}
	
	public Datagramma datagramma(int i){
		return messaggio.getElement(i);
	}
	
	public String toString(){
		String dati = "";
		int found=0, i=0;
		while(found < messaggio.numberElements()){
			while(messaggio.isEmpty(i))
				i++;
			dati += messaggio.getElement(i).getDati();
			i++;
			found++;
		}
		return dati;
	}
}
