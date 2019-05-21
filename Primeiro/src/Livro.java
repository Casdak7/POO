
public class Livro {
	private String titulo;
	private String autor;
	private int numeroPaginas;
	private int anoEdicao;
	
	public Livro(String titulo, String autor, int numeroPaginas, int anoEdicao) {
		this.setTitulo(titulo);
		this.setAutor(autor);
		this.setNumeroPaginas(numeroPaginas);
		this.setAnoEdicao(anoEdicao);
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public int getNumeroPaginas() {
		return numeroPaginas;
	}
	
	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}
	
	public int getAnoEdicao() {
		return anoEdicao;
	}
	
	public void setAnoEdicao(int anoEdicao) {
		this.anoEdicao = anoEdicao;
	}
	
	@Override
	public String toString() {
		StringBuilder newString = new StringBuilder();
		newString.append(this.getTitulo()).append(" - ").append(this.getAutor()).append(" - ").append(this.getNumeroPaginas()).append(" - ").append(this.getAnoEdicao());
		return newString.toString();
	}
}
