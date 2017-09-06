package com.giuseppebrb.asd.exams.Lab20150702.model;

import com.giuseppebrb.asd.exams.Lab20150702.datastructure.AddOnlyLinkedList;
import com.giuseppebrb.asd.exams.Lab20150702.datastructure.AddOnlyList;
import com.giuseppebrb.asd.exams.Lab20150702.datastructure.ArrayDoubling;
import com.giuseppebrb.asd.exams.Lab20150702.datastructure.Dictionary;

public class Referendum {
	protected Dictionary<Voto> referendum;
	private AddOnlyLinkedList<Cittadino> listaCittadini;
	private AddOnlyLinkedList<Cittadino> votanti;
	private boolean isOpen;
	private int bianche, si, no, nulle;
	
	public Referendum() {
		referendum = new ArrayDoubling<>();
		listaCittadini = new AddOnlyLinkedList<>();
		votanti = new AddOnlyLinkedList<>();
		isOpen = false;
		bianche = 0;
		si = 0;
		no = 0;
		nulle = 0;
	}
	
	public void addCittadino(Cittadino cittadino){
		listaCittadini.add(cittadino);
	}
	
	public AddOnlyList<Cittadino> registrati(){
		return listaCittadini;
	}
	
	public void apriReferendum(){
		isOpen = true;
	}
	
	public void vota(Cittadino cittadino, Voto v){
		if(isOpen == true){
			for(Cittadino cit : listaCittadini)
				if(cit.compareTo(cittadino) == 0){
					referendum.insert(v, cittadino);
					votanti.add(cittadino);
					if(v == v.BIANCA)
						bianche++;
					else if(v == v.NULLA)
						nulle++;
					else if(v == v.SI)
						si++;
					else if(v == v.NO)
						no++;
				}
		}
	}
	
	public void chiudiReferendum(){
		isOpen = false;
	}
	
	public AddOnlyList<Cittadino> votanti(){
		return votanti;
	}
	
	public int votiSi(){
		return si;
	}
	
	public int votiNo(){
		return no;
	}
	
	public int votiNulli(){
		return nulle;
	}
	
	public int votiBianche(){
		return bianche;
	}
}
