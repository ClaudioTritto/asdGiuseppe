package com.giuseppebrb.asd.exams.Lab20160411.model;

public class Test {
	public static void main(String[] args) {
		Museo test = new Museo();
		test.addOp("La Gioconda", new Opera("Leonardo da Vinci", 1804, "Dipinto a olio su tavola di pioppo"));
		test.addOp("Madonna del Lucherino", new Opera("Albercht Durer", 1915, "Dipinto a olio su tavola di pioppo"));
		test.addOp("Venere di Milo", new Opera("Alessandro di Antiochia", 1820, "Scultura di marmo"));
		test.addOp("David", new Opera("Michelangelo Buonarroti", 1850, "Scultura di marmo"));
		test.addOp("Mos�", new Opera("Michelangelo Buonarroti", 1850, "Scultura di marmo"));
		
		System.out.println("Museo vuoto: " + test.museoVuoto());
		System.out.println("----- Opere Attualmente -----");
		/**
		 * Non � chiaro dalla traccia come questa parte debba essere svolta
		 */
		System.out.println("La Gioconda " + test.opera("La Gioconda").toString());
		System.out.println("Madonna del Lucherino " + test.opera("Madonna del Lucherino").toString());
		System.out.println("Venere di Milo " + test.opera("Venere di Milo").toString());
		System.out.println("David " + test.opera("David").toString());
		System.out.println("Mos� " + test.opera("Mos�").toString());
		
		test.prestito("La Gioconda", "Esposizione Universale di Parigi");
		test.prestito("Mos�", "Esposizione Universale di Parigi");
		System.out.println("\nPrestate:");
		for(Opera o : test.prestiti("Esposizione Universale di Parigi"))
			System.out.println(o.toString());
		test.restituzione("La Gioconda", null);
		test.restituzione("Mos�", null);
	}
}
