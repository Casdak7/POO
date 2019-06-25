package agenda;

import java.io.Serializable;
import java.util.Comparator;

import dataTempo.Periodo;

/**
 * Classe que representa um evento, implementa ItemAgenda e possui um campo para armazenar o local do evento
 * @author Cassio
 * @version 1.0 (junho-2019)
 */
public class Evento extends ItemAgenda implements Comparable<Evento>, Serializable{
	private String local;
	
	/**
	 * Cria um novo Evento sem descriçãp
	 * @param local
	 * @param titulo
	 * @param periodo
	 */
	public Evento(String local, String titulo, Periodo periodo) {
		super.setTitulo(titulo);
		super.setPeriodo(periodo);
		setLocal(local);
	}
	
	/**
	 * Cria um novo Evento
	 * @param local
	 * @param titulo
	 * @param periodo
	 */
	public Evento(String local, String titulo, String descricao, Periodo periodo) {
		super.setTitulo(titulo);
		super.setDescricao(descricao);
		super.setPeriodo(periodo);
		setLocal(local);
	}
	
	/**
	 * Cria um novo Evento sem descrição e sem titulo
	 * @param local
	 * @param titulo
	 * @param periodo
	 */
	public Evento(String local, Periodo periodo) {
		super.setTitulo("Sem Titulo");
		super.setPeriodo(periodo);
		setLocal(local);
	}
	
	/**
	 * Retorn o local
	 * @return String
	 */
	public String getLocal() {
		return local;
	}
	
	/**
	 * Define o local
	 * @param local
	 */
	public void setLocal(String local) {
		this.local = local;
	}
	
	@Override
	public String toString() {
		StringBuilder newString = new StringBuilder();
		newString.append("Evento\n----------------\n");
		newString.append(super.toString());
		newString.append("Local: ").append(this.getLocal()).append("\n");
		return newString.toString();
	}

	@Override
	public int compareTo(Evento o) {
		// TODO Auto-generated method stub
		return 0;
	}

}

/**
* Compara os Eventos por ordem alfabetica de local.
* 
* @author Cassio Fernandes
* @version 1.0 
*/
class ComparaEvento implements Comparator<Evento> {
	@Override
 	public int compare(Evento m1, Evento m2) {
   	return m1.getLocal().compareToIgnoreCase(m2.getLocal());
 	}
}