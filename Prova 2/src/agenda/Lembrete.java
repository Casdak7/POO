package agenda;

import dataTempo.Periodo;

public class Lembrete extends ItemAgenda{
	private int minutosAlerta = 0;
	
	public Lembrete(int minutosAlerta, String titulo, Periodo periodo) throws Exception {
		super.setTitulo(titulo);
		super.setPeriodo(periodo);
		setMinutosAlerta(minutosAlerta);
	}
	
	public Lembrete(int minutosAlerta, String titulo, String descricao, Periodo periodo) throws Exception {
		super.setTitulo(titulo);
		super.setDescricao(descricao);
		super.setPeriodo(periodo);
		setMinutosAlerta(minutosAlerta);
	}
	
	public Lembrete(String titulo, String descricao, Periodo periodo) throws Exception {
		super.setTitulo(titulo);
		super.setDescricao(descricao);
		super.setPeriodo(periodo);
	}
	
	public Lembrete(String titulo, Periodo periodo) throws Exception {
		super.setTitulo(titulo);
		super.setPeriodo(periodo);
	}

	public int getMinutosAlerta() {
		return minutosAlerta;
	}

	public void setMinutosAlerta(int minutosAlerta) throws Exception{
		if(minutosAlerta >= 0)
			this.minutosAlerta = minutosAlerta;
		else
			throw new Exception("Nao pode ser negativo!");
	}	
}
