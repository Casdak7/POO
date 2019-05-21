import java.util.Scanner;

public class Funcionario extends Pessoa {

	private Data dataAdmissao;
	private float salario;
	
	Funcionario(String nome, String identidade, Data dataNascimento, Data dataAdmissao, float salario) {
		super(nome, identidade, dataNascimento);
		this.setDataAdmissao(dataAdmissao);
		this.setSalario(salario);
	}
	
	public Data getDataAdmissao() {
		return dataAdmissao;
	}
	
	public void setDataAdmissao(Data dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}
	
	public String toString() {
		StringBuilder newString = new StringBuilder();
		newString.append(super.toString()).append("\nData de Admissao: ").append(this.dataAdmissao.toString()).append("\nSalario: ").append(this.salario);
		return newString.toString();
	}
	
	public void reajustarSalario(float taxa) {
		float newSalario = this.salario + (this.salario * taxa);
		
		this.setSalario(newSalario);
	}
	
	@Override
	public float calculaLimiteEmprestimo() {
		return this.getSalario();
	}
	
	public static void uso() {
		int i = 0;
		boolean exit = false;
		int control;
		
		Pessoa []registros = new Pessoa[50];
		
		Scanner input = new Scanner(System.in);
		
		while(!exit) {
			System.out.println("1 - Entrar com dados de um novo funcionario");
			System.out.println("2 - Alterar a taxa de reajuste de salario");
			System.out.println("3 - Listar funcionarios, seus salarios e limites de emprestimos");
			System.out.print("Digite um Commando: ");
			control = input.nextInt();
			switch(control) {
			case 1:
				if(i < 50) {
					System.out.println("1 - Funcinario");
					System.out.println("2 - Chefe");
					System.out.println("3 - Diretor");
					System.out.println("0 - Voltar");
					System.out.print("Digite um Commando: ");
					control = input.nextInt();
					switch(control) {
					case 1:
						System.out.print("Digite o Nome: ");
						
						System.out.print("Digite a Data de Nascimento: ");
						
						System.out.print("Digite a Data de Admissao: ");
						
						System.out.print("Digite a Identidade: ");
						
						System.out.print("Digite o Salario: ");
						break;
					case 2:
						break;
					case 3:
						break;
					default:
						break;
					}
				} else {
					System.out.println("Limite de 50 registros atingido!");
				}
				break;
			case 2:
				break;
			case 3:
				break;
			case -1:
				break;
			default:
				System.out.println("Valor Invalido!");
			}
		}
		
		input.close();
	}
}
