package agenda;

import java.io.Serializable;
import java.util.Comparator;

import dataTempo.Data;
import dataTempo.Periodo;

public class Meta extends ItemAgenda implements Comparable<Meta>, Serializable {
	private int prioridade;
	
	public Meta(int prioridade, String titulo, Periodo periodo) {
		super.setTitulo(titulo);
		super.setPeriodo(periodo);
		setPrioridade(prioridade);
	}
	
	public Meta(int prioridade, String titulo, String descricao, Periodo periodo) {
		super.setTitulo(titulo);
		super.setDescricao(descricao);
		super.setPeriodo(periodo);
		setPrioridade(prioridade);
	}
	
	
	public Meta(int prioridade, Periodo periodo) {
		super.setTitulo("Sem Titulo");
		super.setPeriodo(periodo);
		setPrioridade(prioridade);
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
	
	@Override
	public String toString() {
		StringBuilder newString = new StringBuilder();
		newString.append("Meta\n----------------\n");
		newString.append(super.toString());
		newString.append("Prioridade: ").append(this.getPrioridade()).append("\n");
		return newString.toString();
	}

	@Override
	public int compareTo(Meta o) {
		return this.getPrioridade() - o.getPrioridade();
	}

}

/**
 * Compara as Metas por ordem de prioridade.
 * 
 * @author Cassio Fernandes
 * @version 1.0 
 */
class ComparaMeta implements Comparator<Meta> {
	@Override
  	public int compare(Meta m1, Meta m2) {
    	return m1.getPrioridade() - m2.getPrioridade();
  	}
}
