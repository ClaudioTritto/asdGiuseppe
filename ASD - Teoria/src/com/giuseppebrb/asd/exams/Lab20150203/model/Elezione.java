package com.giuseppebrb.asd.exams.Lab20150203.model;

import java.util.ArrayList;
import java.util.List;

import com.giuseppebrb.asd.exams.Lab20150203.datastructure.Dictionary;
import com.giuseppebrb.asd.exams.Lab20150203.datastructure.HashDict;

public class Elezione {
	private int voters, nulle, bianche;
	protected Dictionary<Integer> listeElettorali;
	
	public Elezione(int voters){
		this.voters = voters;
		listeElettorali = new HashDict<>(voters);
		nulle=0;
		bianche=0;
	}
	
	public void aggiungiLista(ListaElettorale l){
		listeElettorali.insert(0, l);
	}
	
	public void scrutinaVoto(Voto v){
		if (!v.nullo() && !v.bianca()){
			ListaElettorale l = v.voto();
			int voti = listeElettorali.search(l);
			if(voti > 0)
				listeElettorali.delete(l);
			listeElettorali.insert(voti++, l);
		}
		if(v.nullo())
			nulle++;
		if(v.bianca())
			bianche++;
	}
	
	public int numVoti(ListaElettorale l){
		return listeElettorali.search(l);
	}
	
	public int bianche(){
		return bianche;
	}
	
	public int nulle(){
		return nulle;
	}
	
	public List<Comparable> elencoOrdinato(){
		List<Comparable> lista = new ArrayList<>();
		for(Comparable c : listeElettorali)
			lista.add(c);
		return lista;
			
	}

}
