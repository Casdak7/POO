package agenda;

import dataTempo.Periodo;

public abstract class ItemAgenda {
	
	private String titulo;
	private String descricao;
	private Periodo periodo;
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}
	
	@Override
	public String toString() {
		StringBuilder newString = new StringBuilder();
		newString.append("Titulo: ").append(this.getTitulo()).append("\n");
		newString.append("Data de Inicio: ").append(this.getPeriodo().getData_inicio().toString()).append("\n");
		newString.append("Data de Fim: ").append(this.getPeriodo().getData_fim().toString()).append("\n");
		newString.append("Descricao: ").append(this.getDescricao()).append("\n");
		return newString.toString();
	}
	
	
}
