
public class PacienteDeClinica extends Pessoa {

	private String planoDeSaude;
	
	PacienteDeClinica(String nome, String identidade, Data dataNascimento, String planoDeSaude) {
		super(nome, identidade, dataNascimento);
		this.setPlanoDeSaude(planoDeSaude);
	}

	public String getPlanoDeSaude() {
		return this.planoDeSaude;
	}

	public void setPlanoDeSaude(String planoDeSaude) {
		this.planoDeSaude = planoDeSaude;
	}
	
	public String toString() {
		StringBuilder newString = new StringBuilder();
		newString.append(super.toString()).append("\nPlano de Saude: ").append(this.planoDeSaude);
		return newString.toString();
	}
}
