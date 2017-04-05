package com.giuseppebrb.asd;

import com.giuseppebrb.asd.esempiAuto.Automobile;
import com.giuseppebrb.asd.esempiAuto.MezzoDiTrasporto;
import com.giuseppebrb.asd.esempiAuto.Smart;
import com.giuseppebrb.asd.list.List;
import com.giuseppebrb.asd.list.Lista;

/**
 * In questa classe verranno presentati esempi per ogni tipo di
 * <b>Polimorfismo</b> secondo la classificazione di <i>Cardelli</i> e di
 * <i>Wegner</i>. <br>
 * Per il Polimorfismo Universale:
 * <li>Polimorfismo Parametrico</li>
 * <li>Polimorfismo di Inclusione</li> <br>
 * Per il Polimorfismo Ad Hoc:
 * <li>Overloading</li>
 * <li>Coercizione</li>
 * 
 * @author Giuseppe Barbato
 *
 */
public class Polimorfismo {

	public static void main(String[] args) {

		/** POLIMORFISMO UNIVERSALE */

		// Parametrico -> Garantisce Riusabilit� //
		List<String> lista = new Lista<>(); // Il polimorfismo parametrico
											// indica l'utilizzo di CLASSI
											// GENERALIZZATE. In oltre il
											// polimorfismo parametrico
											// garantisce Riusabilit� del
											// codice.

		// Inclusione -> Garantisce Riusabilit� ed Estendibilit� //
		MezzoDiTrasporto mDT = new Automobile(); // Ad un oggetto istanziato
													// attravverso una
													// interfaccia, possiamo
													// sostituirne un altro
													// qualsiasi che implementi
													// comunque la stessa
													// interfaccia. (Liskov
													// Substitution Principle)

		Automobile a = new Smart(); // definendo l'oggetto in questa maniera non
									// posso accedere al metodo
									// isMacchinaDelCazzo()
									// definito nella classe Smart ma solo ai
									// metodi definiti in automobile

		Smart s = new Smart(); // in questa maniera posso accedere sia ai metodi
								// di Smart che di Automobile

		/** POLIMORFISMO AD HOC */

		// Overloading//
		double esempioOverloading = 13 + 4; // in questo caso il simbolo + usa
											// come parametri due interi
		esempioOverloading = 13 + 13.4; // in questo caso il simbolo + usa come
										// parametri un intero e una virgola
										// mobile.
		String esempioOverloadingStringhe = "Questo � " + "overloading"; // in
																			// questo
																			// caso
																			// il
																			// simbolo
																			// +
																			// usa
																			// come
																			// parametri
																			// due
																			// Stringhe
		// In sintesi, si parla di OVERLOADING (o nel caso dei metodi di
		// overriding) quando una stessa notazione, in questo caso il simbolo +,
		// pu� essere usata in constesti diversi e con parametri formali diversi

		// Coercizione//
		Integer i = 13;
		int n = i; // in questo caso abbiamo COERCIZIONE poich� la conversione �
					// implicita

		int altroEsempio = (int) (13 + 14.789); // in questo caso la conversione
												// � esplicita e si parla di
												// CASTING.
	}

}
