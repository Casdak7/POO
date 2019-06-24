package agenda;

import java.io.Serializable;
import java.util.Comparator;

import dataTempo.Periodo;

public class Evento extends ItemAgenda implements Comparable<Evento>, Serializable{
	private String local;
	
	public Evento(String local, String titulo, Periodo periodo) {
		super.setTitulo(titulo);
		super.setPeriodo(periodo);
		setLocal(local);
	}
	
	public Evento(String local, String titulo, String descricao, Periodo periodo) {
		super.setTitulo(titulo);
		super.setDescricao(descricao);
		super.setPeriodo(periodo);
		setLocal(local);
	}
	
	
	public Evento(String local, Periodo periodo) {
		super.setTitulo("Sem Titulo");
		super.setPeriodo(periodo);
		setLocal(local);
	}

	public String getLocal() {
		return local;
	}

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