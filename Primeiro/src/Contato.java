//Deve haver uma agregacao e nao uma heranca
public class Contato {
	private String nome;
	private Email email;
	
	Contato(String nome, String email) throws Exception{
		this.setNome(nome);
		this.setEmail(new Email(email));
	}
	
	Contato(String nome, Email email){
		this.setNome(nome);
		this.setEmail(email);
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Email getEmail() {
		return email;
	}
	
	public void setEmail(Email email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		StringBuilder newString = new StringBuilder();
		newString.append("Nome: ").append(this.getNome()).append("\n").append("Email: ").append(this.getEmail().getDescricaoEmail());
		return newString.toString();
	}
}
