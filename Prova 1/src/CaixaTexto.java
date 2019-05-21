
public class CaixaTexto {
	private Texto texto;
	private double linha;
	private double coluna;
	
	public static final double MAX_LINHA_DEFAULT = 30;
	public static final double MAX_COLUNA_DEFAULT = 50;
	
	private static double maxLinha = MAX_LINHA_DEFAULT;
	private static double maxColuna = MAX_COLUNA_DEFAULT;
	
	public CaixaTexto(Texto texto, double linha, double coluna) throws Exception {
		this.setTexto(texto);
		this.setLinha(linha);
		this.setColuna(coluna);
	}
	
	public CaixaTexto(String texto, double linha, double coluna) throws Exception {
		this.setTexto(new Texto(texto));
		this.setLinha(linha);
		this.setColuna(coluna);
	}
	
	public CaixaTexto() throws Exception{
		this.setTexto(new Texto());
		this.setLinha(1);
		this.setColuna(1);
	}
	
	public Texto getTexto() {
		return texto;
	}
	
	public void setTexto(Texto texto) {
		this.texto = texto;
	}
	
	public double getLinha() {
		return linha;
	}
	
	public void setLinha(double linha) throws Exception {
		if(linha <= CaixaTexto.maxColuna && linha >= 0)
			this.linha = linha;
		else 
			throw new Exception();
	}
	
	public double getColuna() {
		return coluna;
	}
	
	public void setColuna(double coluna) throws Exception {
		if(coluna <= CaixaTexto.maxColuna && coluna >= 0)
			this.coluna = coluna;
		else 
			throw new Exception();
	}
	
	public static double getMaxLinha() {
		return maxLinha;
	}

	public static void setMaxLinha(double maxLinha) throws Exception{
		if(maxLinha >= 0)
			CaixaTexto.maxLinha = maxLinha;
		else
			throw new Exception();
	}

	public static double getMaxColuna() {
		return maxColuna;
	}

	public static void setMaxColuna(double maxColuna) throws Exception {
		if(maxColuna >= 0)
			CaixaTexto.maxColuna = maxColuna;
		else
			throw new Exception();
	}
	
	@Override
	public String toString() {
		StringBuilder newString = new StringBuilder();
		newString.append(this.getTexto().toString()).append(" - (").append(this.getLinha()).append(",").append(this.getColuna()).append(")");
		return newString.toString();
	}
}
