
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
}
