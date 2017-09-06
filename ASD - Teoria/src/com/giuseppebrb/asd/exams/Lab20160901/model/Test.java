package com.giuseppebrb.asd.exams.Lab20160901.model;

public class Test {
	public static void main(String[] args) {
		ItemReccomender test = new ItemReccomender(20);
		test.printSessions();
		
		System.out.println("Co-occorrenze tra prodotti");
		for (Prodotto p : test.elencoProdotti)
            for (Prodotto po: test.elencoProdotti)
                if (p != po){
                    System.out.println("Cooccorenza per " + p.getNome() + " e " + po.getNome() + " :"+ test.acquistiAssociati(p, po));
                }
	}
}
