package dataTempo;

import java.io.Serializable;

/**
 * Classe que representa um périodo, com uma Data e Horario de Inicio e Uma Data e Horario de Fim
 * @author Cassio
 * @version 1.0 (junho-2019)
 */
public class Periodo implements Serializable {
	private Data data_inicio, data_fim;
	private Horario horario_inicio, horario_fim;
	
	/**
	 * Cria um novo Periodo dados as Datas e Horarios
	 * @param data_inicio
	 * @param horario_inicio
	 * @param data_fim
	 * @param horario_fim
	 */
	public Periodo(Data data_inicio, Horario horario_inicio, Data data_fim, Horario horario_fim) {
		this.setData_inicio(data_inicio);
		this.setData_fim(data_fim);
		this.setHorario_inicio(horario_inicio);
		this.setHorario_fim(horario_fim);
	}
	
	/**
	 * Retorna a Data de Inicio
	 * @return
	 */
	public Data getData_inicio() {
		return data_inicio;
	}
	
	/**
	 * Define a Data de Inicio dada uma Data
	 * @param data_inicio
	 */
	public void setData_inicio(Data data_inicio) {
		this.data_inicio = data_inicio;
	}
	
	/**
	 * Define a Data de Inicio dado o dia, mes e ano
	 * @param dia
	 * @param mes
	 * @param ano
	 * @throws Exception
	 */
	public void setData_inicio(int dia, int mes, int ano) throws Exception {
		Data newData = new Data(dia, mes, ano);
		this.data_inicio = newData;
	}
	
	/**
	 * Retorna a Data de Fim
	 * @return
	 */
	public Data getData_fim() {
		return data_fim;
	}
	
	/**
	 * Define a Data de Fim dada uma Data
	 * @param data_fim
	 */
	public void setData_fim(Data data_fim) {
		this.data_fim = data_fim;
	}
	
	/**
	 * Define a Data de Fim dado o dia, mes e ano
	 * @param dia
	 * @param mes
	 * @param ano
	 * @throws Exception
	 */
	public void setData_fim(int dia, int mes, int ano) throws Exception {
		Data newData = new Data(dia, mes, ano);
		this.data_fim = newData;
	}
	
	/**
	 * Retorna o Horario de Inicio
	 * @return
	 */
	public Horario getHorario_inicio() {
		return horario_inicio;
	}
	
	/**
	 * Define o Horario de Inicio
	 * @param horario_inicio
	 */
	public void setHorario_inicio(Horario horario_inicio) {
		this.horario_inicio = horario_inicio;
	}
	
	/**
	 * Define o Horario de Inicio dado a hora, minuto e segundo
	 * @param hora
	 * @param minuto
	 * @param segundo
	 * @throws Exception
	 */
	public void setHorario_inicio(int hora, int minuto, int segundo) throws Exception {
		Horario newHorario = new Horario(hora, minuto, segundo);
		this.horario_inicio = newHorario;
	}
	
	/**
	 * Retorna o Horario de Fim
	 * @return
	 */
	public Horario getHorario_fim() {
		return horario_fim;
	}
	
	/**
	 * Define o Horario de Fim
	 * @param horario_inicio
	 */
	public void setHorario_fim(Horario horario_fim) {
		this.horario_fim = horario_fim;
	}
	
	/**
	 * Define o Horario de Fim dado a hora, minuto e segundo
	 * @param hora
	 * @param minuto
	 * @param segundo
	 * @throws Exception
	 */
	public void setHorario_fim(int hora, int minuto, int segundo) throws Exception {
		Horario newHorario = new Horario(hora, minuto, segundo);
		this.horario_fim = newHorario;
	}
	
	/**
	 * Define o Periodo
	 * @param data_inicio
	 * @param horario_inicio
	 * @param data_fim
	 * @param horario_fim
	 */
	public void setPeriodo(Data data_inicio, Horario horario_inicio, Data data_fim, Horario horario_fim) {
		setData_inicio(data_inicio);
		setData_fim(data_fim);
		setHorario_inicio(horario_inicio);
		setHorario_fim(horario_fim);
	}

	@Override
	public String toString() {
		StringBuilder newString = new StringBuilder();
		newString.append(data_inicio.toString()).append(horario_inicio.toString()).append(data_fim.toString())
				.append(horario_fim.toString());
		return newString.toString();
	}
}
