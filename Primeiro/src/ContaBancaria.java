import java.util.Scanner;

public class ContaBancaria {
	private String nomeCorrentista;
	private float saldo;
	private static float taxa_juros;
	
	
	ContaBancaria() throws Exception{
		this.setNomeCorrentista("");
		this.setSaldo(0);
	}

	ContaBancaria(String nome) throws Exception{
		this.setNomeCorrentista(nome);
		this.setSaldo(0);
	}
	
	ContaBancaria(String nome, float saldo) throws Exception{
		this.setNomeCorrentista(nome);
		this.setSaldo(saldo);
	}
	
	public String getNomeCorrentista() {
		return nomeCorrentista;
	}
	
	public void setNomeCorrentista(String nomeCorrentista) {
		this.nomeCorrentista = nomeCorrentista;
	}
	
	public float getSaldo() {
		return saldo;
	}
	
	public void setSaldo(float saldo) throws Exception {
		if(saldo >= 0)
			this.saldo = saldo;
		else
			throw new Exception("Saldo negativo n�o � v�lido!");
	}
	
	public static float getTaxaJuros() {
		return taxa_juros;
	}
	
	public static void setTaxaJuros(float taxa_juros) {
		ContaBancaria.taxa_juros = taxa_juros;
	}
	
	public void corrigirSaldoComTaxa() throws Exception {
		float newSaldo = this.saldo + (this.saldo * ContaBancaria.taxa_juros);
		
		this.setSaldo(newSaldo);
	}
	
	public String toString() {
		return this.nomeCorrentista + ";" + this.saldo + ";" + ContaBancaria.taxa_juros + ";";
	}
	
	public boolean equals(ContaBancaria conta) {
		if(this.nomeCorrentista == conta.nomeCorrentista && this.saldo == conta.saldo)
			return true;
		
		return false;
	}
	
	public int comparesTo(ContaBancaria conta) {
		if(this.saldo > conta.saldo) 
			return 1;
		else if(this.saldo == conta.saldo)
			return 0;
		else
			return -1;
		
	}
	
	public static void executar() {
		//Enquanto nao quiser sair do loop, nao sai
		boolean exit = false;
		
		//Variaveis que receberao os inputs para a cricacao da conta bancaria
		String inputName;
		float inputSaldo;
		
		int inputCommand;
		float inputTaxa;
		
		Scanner input = new Scanner(System.in);
		
		//Variaveis para construir novas contas
		ContaBancaria contas[] = new ContaBancaria[2];
		
		//Loop de input
		for(int i = 0; i < 2; i++) {
			System.out.println("Digite o nome do correntista " + i +":");
			inputName = input.next();
			System.out.println("Digite o saldo da conta " + i +":");
			inputSaldo = input.nextFloat();
			System.out.println("----------------------------------------------------------------");
			
			try {
				contas[i] = new ContaBancaria(inputName, inputSaldo);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Digite Novamente!");
				i--;
			}
		}
			
		System.out.println(contas[0].toString());
		System.out.println(contas[1].toString());
		
		while(!exit) {
			System.out.println("----------------------------------------------------------------");
			System.out.println("Menu de Acoes:\n1-Definir Taxa de Juros \n2-Corrigir saldo de uma conta \n3-Exibir Contas \n9-Sair");
			inputCommand = input.nextInt();
			
			switch(inputCommand) {
			case 1:
				System.out.println("Digite a nova taxa de Juros:");
				inputTaxa = input.nextFloat();
				ContaBancaria.setTaxaJuros(inputTaxa);
				break;
			case 2:
				System.out.println("Escolha a conta para ter seu saldo corrigido:");
				for(int i = 0; i < 2; i++) {
					System.out.println(i + "- " + contas[i].toString());
				}
				inputCommand = input.nextInt();
				
				try {
					contas[inputCommand].corrigirSaldoComTaxa();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				System.out.println("Contas cadastradas:");
				for(int i = 0; i < 2; i++) {
					System.out.println(i + "- " + contas[i].toString());
				}
				break;
			case 9:
				System.out.println("Saindo do Programa...");
				exit = true;
				break;
			}
		}
		
		input.close();
		System.exit(0);
	}
}
