package Lab20160118.model;

import Lab20160118.datastructure.IndexedAL;
import Lab20160118.datastructure.IndexedList;

public class Whatsup implements Comparable<Whatsup> {
	private IndexedList<Pacchetto> comunicazione = new IndexedAL<>();
	
	public void addPacchetto(Pacchetto p){
		comunicazione.addItem(p, p.getIdentificativo());
	}
	
	public boolean complete(){
		for(Pacchetto p : comunicazione)
			if(p.isUltimo() == true)
				return true;
		return false;
	}
	
	public String toString(){
		String message = "";
		for(Pacchetto p : comunicazione)
			message += p.getDati();
		return message;
	}

	@Override
	public int compareTo(Whatsup o) {
		String thisMessage = this.toString();
		String other = o.toString();
		return thisMessage.compareTo(other);
	}
	
	public static void main(String[] args) {
		Whatsup test = new Whatsup();
		test.addPacchetto(new Pacchetto("IO", "Ale", 30, "una ", false));
		test.addPacchetto(new Pacchetto("IO", "Ale", 10, "Questa ", false));
		test.addPacchetto(new Pacchetto("IO", "Ale", 40, "prova!", true));
		test.addPacchetto(new Pacchetto("IO", "Ale", 20, "è ", false));
		System.out.println("Is complete?: " + test.complete());
		System.out.println(test.toString());
	}

}
