
public class Email {
	private String descricaoEmail;
	
	public Email(String email) throws Exception {
		this.setDescricaoEmail(email);
	}
	
	public Email(){
		
	}
	
	
	public String getDescricaoEmail() {
		return descricaoEmail;
	}

	public void setDescricaoEmail(String descricaoEmail) throws Exception {
		if(descricaoEmail.contains("@"))
			this.descricaoEmail = descricaoEmail;
		else
			throw new Exception("Email valido requer @!");
	}
	
	@Override
	public String toString() {
		StringBuilder newString = new StringBuilder();
		newString.append("Email: ").append(this.getDescricaoEmail());
		return newString.toString();
	}
	
	public boolean equals(Email email) {
		if(this.getDescricaoEmail().equals(email.getDescricaoEmail()))
			return true;
		return false;
	}
}
