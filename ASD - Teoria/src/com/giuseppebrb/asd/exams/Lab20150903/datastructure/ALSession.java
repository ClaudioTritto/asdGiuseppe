package com.giuseppebrb.asd.exams.Lab20150903.datastructure;

import com.giuseppebrb.asd.exams.Lab20150903.model.Item;

public class ALSession extends AbSession {
	
	public ALSession(){
		super.items = new ArrList<>();
	}
	
	public void addItem(Item e){
		super.items.add(e);
	}
	
	public ArrList<Item> getItems(){
		return (ArrList<Item>) super.items;
	}
}
