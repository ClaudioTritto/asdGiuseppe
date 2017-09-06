package com.giuseppebrb.asd.exams.Lab20150113;

public class Test {
	private static MatriceSparsa<String> text;
	private static String [] dizionario = {"pane", "burro", "marmellata", "biscotti", "patatine", "aranciata", "cioccolata", "prosicutto", "formaggio"};
	
	public static void main(String[] args){
		text = new MatriceSparsa<>(9, 4, "0");
		
		text.cambiaValore(0, 0, dizionario[0]);
		text.cambiaValore(0, 1, dizionario[1]);
		text.cambiaValore(0, 2, dizionario[8]);
		
		text.cambiaValore(1, 0, dizionario[6]);
		text.cambiaValore(1, 1, dizionario[3]);
		text.cambiaValore(1, 2, dizionario[4]);
		
		text.cambiaValore(2, 0, dizionario[7]);
		text.cambiaValore(2, 1, dizionario[8]);
		text.cambiaValore(2, 2, dizionario[5]);
		
		text.cambiaValore(3, 0, dizionario[0]);
		text.cambiaValore(3, 1, dizionario[7]);
		text.cambiaValore(3, 2, dizionario[2]);
		text.cambiaValore(3, 3, dizionario[8]);
		text.cambiaValore(3, 4, dizionario[4]);
		
		for(int i = 0; i< text.numRighe(); i++){
			System.out.println("Carrello n:" + i);
			for(int j=0; j < text.numCol(); j++){
				System.out.println(text.valore(i, j));
				if(j == 3)
					break;
			}
		}
		
		for(int i=0; i < text.numRighe()-1; i++){
			for(int j=i+1; j < text.numRighe(); j++)
				System.out.println("Cooccorrenze tra carrello n:"+i + " e n:" + j + " = " + coocorrenze(i, j));
		}
	}
	
	private static int coocorrenze(int i, int j){
		int count = 0;
		for(int k=0; k < text.numCol(); k++){
			if(text.valore(i, k).compareTo(text.valore(j, k)) == 0)
				count++;
			if(k == 3)
				break;
		}
		return count;
	}

}
