
public class CaixaTextoSombra extends CaixaTexto {
	
	private String corSombra;
	
	public CaixaTextoSombra() throws Exception{
		super();
		this.setCorSombra("0");
	}
	
	public CaixaTextoSombra(Texto texto, double linha, double coluna, String corSombra) throws Exception{
		super(texto,linha,coluna);
		this.setCorSombra(corSombra);
	}

	public String getCorSombra() {
		return corSombra;
	}

	public void setCorSombra(String corSombra) {
		this.corSombra = corSombra;
	}
	
	@Override
	public String toString() {
		StringBuilder newString = new StringBuilder();
		newString.append(super.toString()).append(" - ").append(this.corSombra);
		return newString.toString();
	}
}
