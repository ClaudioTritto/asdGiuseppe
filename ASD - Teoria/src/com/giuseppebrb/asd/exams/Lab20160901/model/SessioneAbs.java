package com.giuseppebrb.asd.exams.Lab20160901.model;

import com.giuseppebrb.asd.exams.Lab20160901.datastructure.AddOnlyList;

public abstract class SessioneAbs {
	protected AddOnlyList<Prodotto> prodotti;
	
	/**
	 *  I metodi che seguono non sono specificati dalla traccia
	 */
	
	public Prodotto getProdotto(String name){
		Prodotto result = null;
		for(Prodotto p: prodotti)
			if(p.getNome().equalsIgnoreCase(name))
				return p;
		return null;
	}
}
