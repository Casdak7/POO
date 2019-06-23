package dataTempo;

public class Horario {
	private int hora;
	private int minuto;
	private int segundo;
	
	public Horario() {
		this.hora = 0;
		this.minuto = 0;
		this.segundo = 0;
	}
	
	public Horario(String horario) throws Exception {
		this.setHorario(horario);
	}
	
	public Horario(int hora, int minuto, int segundo) throws Exception {
		setHorario(hora, minuto, segundo);
	}
	
	public int getHora() {
		return hora;
	}
	
	public void setHora(int hora) throws Exception {
		if(hora >= 0 && hora <=23)
			this.hora = hora;
		else
			throw new Exception("Hora Invalida!");
	}

	public int getMinuto() {
		return minuto;
	}

	public void setMinuto(int minuto) throws Exception {
		if(minuto >= 0 && minuto <=59)
			this.minuto = minuto;
		else
			throw new Exception("Minuto Invalido!");
	}

	public int getSegundo() {
		return segundo;
	}

	public void setSegundo(int segundo) throws Exception {
		if(segundo >= 0 && segundo <=59)
			this.segundo = segundo;
		else
			throw new Exception("Segundo Invalido!");
	}
	
	public void setHorario(int hora, int minuto, int segundo) throws Exception{
		setHora(hora);
		setMinuto(minuto);
		setSegundo(segundo);
	}
	
	public void setHorario(String horario) throws Exception{
		String[] strHorario = horario.split(":");
		int hora, minuto, segundo;
		hora = Integer.parseInt(strHorario[0]);
		minuto = Integer.parseInt(strHorario[1]);
		segundo = Integer.parseInt(strHorario[2]);
		
		this.setHorario(hora,minuto,segundo);
	}
	
	@Override
	public String toString() {
		StringBuilder newString = new StringBuilder();
		newString.append(getHora()).append(';').append(getMinuto()).append(';').append(getSegundo()).append(';');
		return newString.toString();
		}
	
}
