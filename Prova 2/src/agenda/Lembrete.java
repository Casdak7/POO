package agenda;

import java.io.Serializable;
import java.util.Comparator;

import dataTempo.Periodo;

public class Lembrete extends ItemAgenda implements Serializable{
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
	
	@Override
	public String toString() {
		StringBuilder newString = new StringBuilder();
		newString.append("Lembrete\n----------------\n");
		newString.append(super.toString());
		newString.append("Minutos para Alerta: ").append(this.getMinutosAlerta()).append("\n");
		return newString.toString();
	}
}

/**
* Compara os Lembretes por ordem natural de minutos para o alerta.
* 
* @author Cassio Fernandes
* @version 1.0 
*/
class ComparaLembrete implements Comparator<Lembrete> {
	@Override
 	public int compare(Lembrete l1, Lembrete l2) {
   	return l1.getMinutosAlerta() - l2.getMinutosAlerta();
 	}
}
