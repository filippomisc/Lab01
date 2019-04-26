package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Parole {
	
	private String parola;
	private Map<String , String> parole;
//	private List<String> lista;
	
	public Parole() {
		
	this.parole=new TreeMap<>();
	}
	
	public void addParola(String p) {
		parole.put(p, p);
		
		
	}
	
	public List<String> getElenco() {
		Collection<String> result = this.parole.values();
		return (List<String>) result;
	}
	
	public void reset() {

		this.parole.clear();
	}

}
