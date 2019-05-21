
public class Pessoa {
	private String nome;
	private String identidade;
	private Data dataNascimento;
	
	public Pessoa(String nome, String identidade, Data dataNascimento){
		this.setNome(nome);
		this.setIdentidade(identidade);
		this.setDataNascimento(dataNascimento);
	}
	
	public Pessoa(String nome, String identidade, int dia, int mes, int ano) throws Exception{
		new Pessoa(nome, identidade, new Data(dia, mes, ano));
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getIdentidade() {
		return identidade;
	}
	
	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}
	
	public Data getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Data dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String toString() {
		StringBuilder newString = new StringBuilder();
		newString.append("Nome: ").append(this.nome).append("\nIdentidade: ").append(this.identidade).append("\nData de Nascimento: ").append(dataNascimento.toString());
		return newString.toString();
	}
	
	public float calculaLimiteEmprestimo() {
		return 1000;
	}
}
