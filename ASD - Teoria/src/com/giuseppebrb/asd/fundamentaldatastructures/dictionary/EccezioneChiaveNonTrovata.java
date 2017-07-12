package com.giuseppebrb.asd.fundamentaldatastructures.dictionary;

/**
 * Created by giuse on 12/07/2017.
 */
public class EccezioneChiaveNonTrovata extends RuntimeException {
    public EccezioneChiaveNonTrovata(){
        super();
    }

    public EccezioneChiaveNonTrovata(String message){
        super(message);
    }
}
