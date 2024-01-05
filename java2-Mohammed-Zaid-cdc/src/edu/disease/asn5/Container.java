package edu.disease.asn5;

import java.util.ArrayList;
import java.util.Arrays;

public class Container<T> {
	
	private ArrayList<T> items;
	
	public Container(T ...arg) {
		if(arg.length==0) {
			throw new IllegalArgumentException("Argument not supplied");
		}
		this.items = new ArrayList<T>(Arrays.asList(arg));
	}
	
	public int size() {
		
		return items.size();
	}
	
	public T get(int index) {
		if(index<0 || index>size()) {
			throw new IllegalArgumentException("Invalid index");
		}
		return items.get(index);
	}
	
	
}
