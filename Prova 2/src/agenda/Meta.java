package agenda;

import dataTempo.Periodo;

public class Meta extends ItemAgenda {
	private String prioridade;
	
	public Meta(String local, String titulo, Periodo periodo) {
		super.getTitulo() = titulo;
		super.getPeriodo() = periodo;
		setPrioridade(prioridade);
	}
	
	public Meta(String local, String titulo, String descricao, Periodo periodo) {
		super.getTitulo() = titulo;
		super.getDescricao() = descricao;
		super.getPeriodo() = periodo;
		setPrioridade(prioridade);
	}
	
	
	public Meta(String local, Periodo periodo) {
		super.getTitulo() = getTitulo();
		super.getPeriodo() = periodo;
		setPrioridade(prioridade);
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

}
