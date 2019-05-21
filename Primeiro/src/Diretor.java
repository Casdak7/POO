
public class Diretor extends Chefe {

	private Data dataPromocao;
	
	Diretor(String nome, String identidade, Data dataNascimento, Data dataAdmissao, float salario,
			String departamento, Data dataPromocao) {
		super(nome, identidade, dataNascimento, dataAdmissao, salario, departamento);
		this.setDataPromocao(dataPromocao);
	}

	public Data getDataPromocao() {
		return this.dataPromocao;
	}

	public void setDataPromocao(Data dataPromocao) {
		this.dataPromocao = dataPromocao;
	}
	
	@Override
	public float calculaLimiteEmprestimo() {
		return (super.calculaLimiteEmprestimo() * 1.5f);
	}
}
