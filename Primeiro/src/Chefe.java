
public class Chefe extends Funcionario {

	private String departamento;
	
	Chefe(String nome, String identidade, Data dataNascimento, Data dataAdmissao, float salario, String departamento) {
		super(nome, identidade, dataNascimento, dataAdmissao, salario);
		this.setDepartamento(departamento);
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	public String toString() {
		StringBuilder newString = new StringBuilder();
		newString.append(super.toString()).append("\nDepartamento: ").append(this.departamento);
		return newString.toString();
	}
	
	@Override
	public float calculaLimiteEmprestimo() {
		return (super.calculaLimiteEmprestimo() * 2);
	}
}
