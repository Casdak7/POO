package agenda;

import dataTempo.Periodo;

public class Evento extends ItemAgenda {
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
}
