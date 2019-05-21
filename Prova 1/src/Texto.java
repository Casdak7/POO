
public class Texto {
	private String texto;
	private int tamanhoFonte;
	
	public Texto(String texto, int tamanhoFonte) {
		this.setTexto(texto);
		this.setTamanhoFonte(tamanhoFonte);
	}
	
	public Texto(String texto) {
		this.setTexto(texto);
		this.setTamanhoFonte(12);
	}
	
	public Texto() {
		this.setTexto("Digite aqui");
		this.setTamanhoFonte(12);
	}
	
	public String getTexto() {
		return texto;
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public int getTamanhoFonte() {
		return tamanhoFonte;
	}
	
	public void setTamanhoFonte(int tamanhoFonte) {
		this.tamanhoFonte = tamanhoFonte;
	}
	
	@Override
	public boolean equals(Object objeto) {
		Texto texto = (Texto) objeto;
		if(this.texto != texto.getTexto())
			return false;
		
		if(this.tamanhoFonte != texto.getTamanhoFonte())
			return false;
		
		return true;
	}
	
	public int compareTo(Texto texto) {
		if(this.texto.length() < texto.texto.length())
			return -1;
		else if(this.texto.length() == texto.texto.length())
			return 0;
		else
			return 1;
	}
	
	@Override
	public String toString() {
		StringBuilder newString = new StringBuilder();
		newString.append(this.getTexto()).append("(").append(this.getTamanhoFonte()).append(")");
		return newString.toString();
	}
}
