package com.giuseppebrb.asd.exams.Lab20160411.model;

public class Opera {
	private String author;
	private int acquisitionYear;
	private String type;
	
	public Opera(String author, int acquisitionYear, String type) {
		this.author = author;
		this.acquisitionYear = acquisitionYear;
		this.type = type;
	}

	public String getAuthor() {
		return author;
	}

	public int getAcquisitionYear() {
		return acquisitionYear;
	}

	public String getType() {
		return type;
	}
	
	public String toString(){
		String value = "";
		value += author + " " + acquisitionYear + " " + type;
		return value;
	}
}
