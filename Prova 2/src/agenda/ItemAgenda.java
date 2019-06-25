package agenda;

import java.io.Serializable;
import java.util.Comparator;

import dataTempo.Data;
import dataTempo.Periodo;

/**
 * Classe abstrata que representa um unico item na agenda, com titulo, descrição e um periodo
 * @author Cassio
 * @version 1.0 (junho-2019)
 */
public abstract class ItemAgenda implements Serializable{
	
	private String titulo;
	private String descricao;
	private Periodo periodo;
	
	/**
	 * @return String titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	
	/**
	 * Define o titulo
	 * @param titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	/**
	 * @return String descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	
	/**
	 * Define o descricao
	 * @param descricao
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	/**
	 * @return Periodo periodo
	 */
	public Periodo getPeriodo() {
		return periodo;
	}
	
	/**
	 * Define o periodo
	 * @param periodo
	 */
	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}
	
	@Override
	public String toString() {
		StringBuilder newString = new StringBuilder();
		newString.append("Titulo: ").append(this.getTitulo()).append("\n");
		newString.append("Data de Inicio: ").append(this.getPeriodo().getData_inicio().toString()).append("\n");
		newString.append("Horario de Inicio: ").append(this.getPeriodo().getHorario_inicio().toString()).append("\n");
		newString.append("Data de Fim: ").append(this.getPeriodo().getData_fim().toString()).append("\n");
		newString.append("Horario de Fim: ").append(this.getPeriodo().getHorario_fim().toString()).append("\n");
		newString.append("Descricao: ").append(this.getDescricao()).append("\n");
		return newString.toString();
	}
	
	
}

/**
 * Fornece um método para ser usado na ordenação de várias instâncias da classe
 * ItemAgenda pela ordenacao natural das datas de inicio.
 * <p>
 * Esta ordenação é realizada pelo método estático sort da classe Collections
 *
 * @author Cassio Fernandes
 * @version 1.0 (junho-2019)
 *
 */
class ComparaItem implements Comparator<ItemAgenda> {
  	public int compare(ItemAgenda i1, ItemAgenda i2) {
        	return i1.getPeriodo().getData_inicio().compareTo(i2.getPeriodo().getData_inicio());
  	}
}