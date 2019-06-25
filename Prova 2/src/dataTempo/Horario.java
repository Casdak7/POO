package dataTempo;

import java.io.Serializable;

/**
 * Classe que armazena horarios em hora, minuto e segundo.
 * @author Cassio Fernandes
 * @version 1.0 (junho-2019)
 */
public class Horario implements Serializable{
	private int hora;
	private int minuto;
	private int segundo;
	
	/**
	 * Cria um novo horario padrão com hora, minuto e segundo em 0
	 * 
	 */
	public Horario() {
		this.hora = 0;
		this.minuto = 0;
		this.segundo = 0;
	}
	
	/**
	 * Instancia um novo horario dada uma String
	 * @param horario - String do tipo hh:mm:ss
	 * @throws Exception
	 */
	public Horario(String horario) throws Exception {
		this.setHorario(horario);
	}
	
	/**
	 * Instancia um novo horario
	 * @param hora
	 * @param minuto
	 * @param segundo
	 * @throws Exception
	 */
	public Horario(int hora, int minuto, int segundo) throws Exception {
		setHorario(hora, minuto, segundo);
	}
	
	/**
	 * Retorna a hora
	 * @return int
	 */
	public int getHora() {
		return hora;
	}
	
	/**
	 * Define a hora
	 * @param hora
	 * @throws Exception
	 */
	public void setHora(int hora) throws Exception {
		if(hora >= 0 && hora <=23)
			this.hora = hora;
		else
			throw new Exception("Hora Invalida!");
	}
	
	/**
	 * Retorna os minutos
	 * @return int
	 */
	public int getMinuto() {
		return minuto;
	}
	
	/**
	 * Define os minutos
	 * @param minuto
	 * @throws Exception
	 */
	public void setMinuto(int minuto) throws Exception {
		if(minuto >= 0 && minuto <=59)
			this.minuto = minuto;
		else
			throw new Exception("Minuto Invalido!");
	}
	
	/**
	 * Retorna os segundos
	 * @return int
	 */
	public int getSegundo() {
		return segundo;
	}
	
	/**
	 * Define os segundos
	 * @param segundo
	 * @throws Exception
	 */
	public void setSegundo(int segundo) throws Exception {
		if(segundo >= 0 && segundo <=59)
			this.segundo = segundo;
		else
			throw new Exception("Segundo Invalido!");
	}
	
	/**
	 * Define o Horario 
	 * @param hora
	 * @param minuto
	 * @param segundo
	 * @throws Exception
	 */
	public void setHorario(int hora, int minuto, int segundo) throws Exception{
		setHora(hora);
		setMinuto(minuto);
		setSegundo(segundo);
	}
	
	/**
	 * Define o Horario dada uma String do tipo hh:mm:ss
	 * @param horario
	 * @throws Exception
	 */
	public void setHorario(String horario) throws Exception{
		String[] strHorario = horario.split(":");
		int hora, minuto, segundo;
		hora = Integer.parseInt(strHorario[0]);
		minuto = Integer.parseInt(strHorario[1]);
		segundo = Integer.parseInt(strHorario[2]);
		
		this.setHorario(hora,minuto,segundo);
	}
	
	@Override
	/**
	 * Retorna uma String com os campos do horario no tipo hora:minuto:segundo
	 * @return String
	 */
	public String toString() {
		StringBuilder newString = new StringBuilder();
		newString.append(getHora()).append(':').append(getMinuto()).append(':').append(getSegundo());
		return newString.toString();
		}
	
}
