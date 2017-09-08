package com.giuseppebrb.asd.exams.Lab20150203.model;

public class Voto {
	private ListaElettorale s;
	private boolean nullo;
	private boolean white;
	
	public Voto(){
		white = true;
		nullo = false;
	}
	
	public Voto(ListaElettorale s){
		white = false;
		if(s == null)
			nullo = true;
		else{
			this.s = s;
			nullo = false;
		}
		
	}
	
	public boolean nullo(){
		return nullo;
	}
	
	public boolean bianca(){
		return white;
	}
	
	public ListaElettorale voto(){
		if(!nullo && !white)
			return s;
		return null;
	}

}
