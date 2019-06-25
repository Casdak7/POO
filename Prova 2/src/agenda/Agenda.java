package agenda;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import dataTempo.Data;
import dataTempo.Periodo;

/**
 * Classe que representa uma agenda e possui uma lista de ItemAgenda.
 * <p>
 * Possui metodos de manipulação da agenda, de ordenação dos itens da agenda e tambem de gravação e leitura em arquivos.
 * @author Cassio
 * @version 1.0 (junho-2019)
 */
public class Agenda implements Serializable{
	private LinkedList<ItemAgenda> colecaoItensAgenda;
	static String INPUT_OUTPUT_DIR = "C:\\Users\\Cassio\\eclipse-workspace\\POO\\Prova 2\\src\\arquivos\\";
	
	/**
	 * Cria nova Agenda com uma lista vazia
	 */
	public Agenda() {
		colecaoItensAgenda = new LinkedList<ItemAgenda>();
	}
	
	/**
	 * Retorna a lista de Itens da agenda em ordem de data de inicio
	 * @return 
	 */
	public LinkedList<ItemAgenda> getItensAgenda() {
		Collections.sort((List) this.colecaoItensAgenda, new ComparaItem());
		return this.colecaoItensAgenda;
	}
	
	@Override
	/**
	 * Retorna uma listagem dos itens da agenda em uma String
	 */
	public String toString() {
		int k = 1;
		StringBuilder newString = new StringBuilder();
		Iterator<ItemAgenda> i = colecaoItensAgenda.iterator();
		ItemAgenda item;
//		System.out.println(i.toString());
		newString.append("Agenda: \n");
		while(i.hasNext()) {
			item = i.next();
			newString.append(k + "- ").append(item.toString()).append("------------------\n");
			k++;
		}
		return newString.toString();
	}
	
	/**
	 * Insere um novo Item na lista de Itens da Agenda
	 * @param item
	 */
	public void insere(ItemAgenda item) {
		this.colecaoItensAgenda.add(item);
	}
	
	/**
	 * Retorna um objeto Agenda com uma lista dos itens de agenda de um determinado periodo
	 * @param periodo
	 * @return Agenda 
	 */
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
	
	/**
	 * Retorna um objeto Agenda com uma lista de Metas ordenadas de forma crescente por prioridade
	 * @return Agenda
	 */
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
	
	/**
	 * Retorna um objeto Agenda com uma lista de Eventos ordenadas alfabeticamente pelos seus respectivos locais
	 * @return Agenda
	 */
	public Agenda getEventosPorLocal(){
		Iterator<ItemAgenda> i = colecaoItensAgenda.iterator();
		Agenda newAgenda = new Agenda();
		ItemAgenda item;
		while(i.hasNext()) {
			item = i.next();
			if(item.getClass() == Evento.class) {				
				newAgenda.getItensAgenda().add(item);
			}
		}
		
		Collections.sort((List)newAgenda.getItensAgenda(), new ComparaEvento());
		
		return newAgenda;
	}
	
	/**
	 * Retorna um objeto Agenda com uma lista de Lembretes ordenadas pelos minutos para o alerta
	 * @return
	 */
	public Agenda getLembretesPorMinutos(){
		Iterator<ItemAgenda> i = colecaoItensAgenda.iterator();
		Agenda newAgenda = new Agenda();
		ItemAgenda item;
		while(i.hasNext()) {
			item = i.next();
			if(item.getClass() == Lembrete.class) {				
				newAgenda.getItensAgenda().add(item);
			}
		}
		
		Collections.sort((List)newAgenda.getItensAgenda(), new ComparaLembrete());
		
		return newAgenda;
	}
	
	/**
	 * Grava a Agenda em um arquivo cujo nome seja passado como parâmetro e esteja no diretorio da constante INPUT_OUTPUT_DIR
	 * @param nomeArquivo
	 * @throws IOException
	 */
	public void gravarEmArquivo(String nomeArquivo) throws IOException {
		FileOutputStream fout = new FileOutputStream(INPUT_OUTPUT_DIR + nomeArquivo);
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(this);
		fout.close();
		oos.close();
	}
	
	/**
	 * Lê e retorna a Agenda que está em um arquivo cujo nome seja passado como parâmetro e esteja no diretorio da constante INPUT_OUTPUT_DIR
	 * @param nomeArquivo
	 * @return Agenda
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Agenda lerArquivo(String nomeArquivo) throws IOException, ClassNotFoundException {
		FileInputStream fin = new FileInputStream(INPUT_OUTPUT_DIR + nomeArquivo);
		ObjectInputStream ois = new ObjectInputStream(fin);
		Agenda newAgenda = (Agenda) ois.readObject();
		fin.close();
		ois.close();
		return newAgenda;
	}
}
