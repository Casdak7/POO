package agenda;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeMap;

import dataTempo.Data;

public class Agenda implements Serializable{
	private LinkedList<ItemAgenda> colecaoItensAgenda;
	
	public Agenda() {
		colecaoItensAgenda = new LinkedList<ItemAgenda>();
	}
	
	@Override
	public String toString() {
		StringBuilder newString = new StringBuilder();
		Iterator<ItemAgenda> i = colecaoItensAgenda.iterator();
		ItemAgenda item;
		System.out.println(i.toString());
		newString.append("Agenda: \n");
		while(i.hasNext()) {
			item = i.next();
			
			newString.append(item.getPeriodo().getData_inicio().toString()).append(" - ").append(item.getTitulo()).append("\n");
		}
		return newString.toString();
	}
	
	public void insere(ItemAgenda item) {
		this.colecaoItensAgenda.add(item);
	}
	
}
