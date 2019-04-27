package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class Parole {
	
	private Map<String , String> parole;
	
	public Parole() {
		
	this.parole=new TreeMap<>();
	}
	
	public void addParola(String p) {
		parole.put(p, p);
		
		
	}
	
	public List<String> getElenco() {
		List<String> result =new ArrayList<>(this.parole.values());
		return result;
	}
	
	public void reset() {

		this.parole.clear();
	}
	
	public boolean delete (String p) {
		boolean result=false;
		if(this.parole.containsKey(p)) {
			this.parole.remove(p);
			result =true;
			
		}
		return result;
	}

}
