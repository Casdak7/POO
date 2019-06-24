package agenda;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import dataTempo.Data;
import dataTempo.Periodo;

public class Agenda implements Serializable{
	private LinkedList<ItemAgenda> colecaoItensAgenda;
	
	public Agenda() {
		colecaoItensAgenda = new LinkedList<ItemAgenda>();
	}
	
	public LinkedList<ItemAgenda> getItensAgenda() {
		return this.colecaoItensAgenda;
	}
	
	@Override
	public String toString() {
		int k = 1;
		StringBuilder newString = new StringBuilder();
		Iterator<ItemAgenda> i = colecaoItensAgenda.iterator();
		ItemAgenda item;
//		System.out.println(i.toString());
		newString.append("Agenda: \n");
		while(i.hasNext()) {
			item = i.next();
			newString.append(k + "- ").append(item.toString()).append("-----------------\n");
			k++;
		}
		return newString.toString();
	}
	
	public void insere(ItemAgenda item) {
		this.colecaoItensAgenda.add(item);
	}
	
	public Agenda getItensPorPeriodo(Periodo periodo) {
		Iterator<ItemAgenda> i = colecaoItensAgenda.iterator();
		Agenda newAgenda = new Agenda();
		ItemAgenda item;
		while(i.hasNext()) {
			item = i.next();
			if(item.getPeriodo().getData_inicio().compareTo(periodo.getData_inicio()) == 1 && item.getPeriodo().getData_inicio().compareTo(periodo.getData_fim()) == -1) {
				newAgenda.getItensAgenda().add(item);
			}
		}
		return newAgenda;
	}

	public Agenda getMetasPorPrioridade() {
		Iterator<ItemAgenda> i = colecaoItensAgenda.iterator();
		Agenda newAgenda = new Agenda();
		ItemAgenda item;
		while(i.hasNext()) {
			item = i.next();
			if(item.getClass() == Meta.class) {				
				newAgenda.getItensAgenda().add(item);
			}
		}
		
		Collections.sort((List)newAgenda.getItensAgenda(), new ComparaMeta());
		
		return newAgenda;
	}
	
}
