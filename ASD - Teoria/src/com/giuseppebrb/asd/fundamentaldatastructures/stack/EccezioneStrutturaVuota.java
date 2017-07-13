package com.giuseppebrb.asd.fundamentaldatastructures.stack;

import com.giuseppebrb.asd.fundamentaldatastructures.dictionary.EccezioneChiaveNonTrovata;

/**
 * Created by giuse on 13/07/2017.
 */
public class EccezioneStrutturaVuota extends RuntimeException {
    public EccezioneStrutturaVuota(){
        super();
    }

    public EccezioneStrutturaVuota(String message){
        super(message);
    }
}
