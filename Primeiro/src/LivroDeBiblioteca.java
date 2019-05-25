
public class LivroDeBiblioteca extends Livro implements ItemDaBiblioteca {
	private enum Status{
		EMPRESTADO, ATRASADO, DISPONIVEL,  EMMANUTENCAO

	};
	private Status statusEmprestimo;
	private String localizacao;
	private String descricao;
	
	public LivroDeBiblioteca(String titulo, String autor, int numeroPaginas, int anoEdicao, Status statusEmprestimo, String localizacao, String descricao) throws Exception {
		super(titulo, autor, numeroPaginas, anoEdicao);
		this.setStatusEmprestimo(statusEmprestimo);
		this.setLocalizacao(localizacao);
		this.setDescricao(descricao);
	}
	
	public Status getStatusEmprestimo() {
		return statusEmprestimo;
	}
	
	public void setStatusEmprestimo(Status statusEmprestimo) {
		this.statusEmprestimo = statusEmprestimo;
	}
	
	public String getLocalizacao() {
		return localizacao;
	}
	
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public boolean isEmprestado() {
		if(this.getStatusEmprestimo() == Status.EMPRESTADO || this.getStatusEmprestimo() == Status.ATRASADO)
			return true;
		return false;
	}

	@Override
	public void empresta() {
		if(this.getStatusEmprestimo() == Status.DISPONIVEL) {
			this.setStatusEmprestimo(Status.EMPRESTADO);
		}
	}

	@Override
	public void devolve() {
		if(this.getStatusEmprestimo() != Status.DISPONIVEL) {
			this.setStatusEmprestimo(Status.DISPONIVEL);
		}
		
	}

	@Override
	public String localiza() {
		return this.getLocalizacao();
	}

	@Override
	public String apresentaDescricao() {
		return this.getDescricao();
	}
	
	@Override
	public String toString() {
		StringBuilder newString = new StringBuilder();
		newString.append(super.toString()).append(" - ").append(this.getStatusEmprestimo()).append(" - ").append(this.getLocalizacao()).append(" - ").append(this.getDescricao());
		return newString.toString();
	}
	
}
