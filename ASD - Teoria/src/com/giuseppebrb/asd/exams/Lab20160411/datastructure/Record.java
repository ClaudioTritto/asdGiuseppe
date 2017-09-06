package com.giuseppebrb.asd.exams.Lab20160411.datastructure;

import com.giuseppebrb.asd.exams.Lab20160411.model.Opera;

public class Record {
	
	private Opera opera;
	private boolean landed;
	private String exposition;
	
	public Record(Opera opera, boolean landed) {
		this.opera = opera;
		this.landed = landed;
	}

	public Opera getOpera() {
		return opera;
	}

	public void setOpera(Opera opera) {
		this.opera = opera;
	}

	public boolean isLanded() {
		return landed;
	}

	public void setLanded(boolean landed) {
		this.landed = landed;
	}

	public String getExposition() {
		return exposition;
	}

	public void setExposition(String exposition) {
		this.exposition = exposition;
	}

}
