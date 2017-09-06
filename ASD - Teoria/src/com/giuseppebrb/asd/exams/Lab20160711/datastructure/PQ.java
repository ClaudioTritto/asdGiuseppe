package com.giuseppebrb.asd.exams.Lab20160711.datastructure;

public interface PQ<Item> extends Iterable<Item> {
	public boolean isNew();
	public void insert(Item i, int priority);
	public Item first();
	public void delFirst();
	public void changePriority(Item i, int priority);
	public int getPriority(Item i);
	public int size();
}
