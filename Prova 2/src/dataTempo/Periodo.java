package dataTempo;

public class Periodo {
	private Data data_inicio, data_fim;
	private Horario horario_inicio, horario_fim;
	
	public Periodo(Data data_inicio, Horario horario_inicio, Data data_fim, Horario horario_fim) {
		this.setData_inicio(data_inicio);
		this.setData_fim(data_fim);
		this.setHorario_inicio(horario_inicio);
		this.setHorario_fim(horario_fim);
	}

	public Data getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(Data data_inicio) {
		this.data_inicio = data_inicio;
	}
	
	public void setData_inicio(int dia, int mes, int ano) throws Exception {
		Data newData = new Data(dia, mes, ano);
		this.data_inicio = newData;
	}
	
	public Data getData_fim() {
		return data_fim;
	}
	
	public void setData_fim(Data data_fim) {
		this.data_fim = data_fim;
	}
	
	public void setData_fim(int dia, int mes, int ano) throws Exception {
		Data newData = new Data(dia, mes, ano);
		this.data_fim = newData;
	}

	public Horario getHorario_inicio() {
		return horario_inicio;
	}

	public void setHorario_inicio(Horario horario_inicio) {
		this.horario_inicio = horario_inicio;
	}
	
	public void setHorario_inicio(int hora, int minuto, int segundo) throws Exception {
		Horario newHorario = new Horario(hora, minuto, segundo);
		this.horario_inicio = newHorario;
	}

	public Horario getHorario_fim() {
		return horario_fim;
	}

	public void setHorario_fim(Horario horario_fim) {
		this.horario_fim = horario_fim;
	}
	
	public void setHorario_fim(int hora, int minuto, int segundo) throws Exception {
		Horario newHorario = new Horario(hora, minuto, segundo);
		this.horario_fim = newHorario;
	}
	
	public void setPeriodo(Data data_inicio, Horario horario_inicio, Data data_fim, Horario horario_fim) {
		setData_inicio(data_inicio);
		setData_fim(data_fim);
		setHorario_inicio(horario_inicio);
		setHorario_fim(horario_fim);
	}
	
	@Override
	public String toString() {
		StringBuilder newString = new StringBuilder();
		newString.append(data_inicio.toString()).append(horario_inicio.toString()).append(data_fim.toString()).append(horario_fim.toString());
		return newString.toString();
	}
}
