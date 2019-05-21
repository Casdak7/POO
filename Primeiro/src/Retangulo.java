
public class Retangulo {
	private Ponto esquerdoSuperior;
	private Ponto direitoInferior;
	
	
	public Retangulo(double x1, double y1, double x2, double y2) throws Exception{
		this.setEsquerdoSuperior(new Ponto(x1,y1));
		this.setDireitoInferior(new Ponto(x2,y2));
	}
	
	public Retangulo(Ponto esquerdoSuperior, Ponto direitoInferior){
		this.setEsquerdoSuperior(esquerdoSuperior);
		this.setDireitoInferior(direitoInferior);
	}
	
	public Retangulo() throws Exception{
		this.setEsquerdoSuperior(new Ponto());
		this.setDireitoInferior(new Ponto());
	}
	
	public Ponto getEsquerdoSuperior() {
		return esquerdoSuperior;
	}
	
	public void setEsquerdoSuperior(Ponto esquerdoSuperior) {
		this.esquerdoSuperior = esquerdoSuperior;
	}
	
	public Ponto getDireitoInferior() {
		return direitoInferior;
	}
	
	public void setDireitoInferior(Ponto direitoInferior) {
		this.direitoInferior = direitoInferior;
	}
	
	public String toString() {
		StringBuilder newString = new StringBuilder();
		
		newString.append(esquerdoSuperior.toString()).append(" - ").append(direitoInferior.toString());
		
		return newString.toString();
	}
	
	public double calculaLadoX(){
		return (this.getDireitoInferior().getX()  - this.getEsquerdoSuperior().getX());
	}
	
	public double calculaLadoY(){
		return (this.getEsquerdoSuperior().getY() - this.getDireitoInferior().getY());
	}
	
	public double calculaArea() {
		return (this.calculaLadoX() * this.calculaLadoY());
	}
	
	public double calculaPerimetro() {
		return 2 * (this.calculaLadoX() + this.calculaLadoY());
	}
	
	public boolean equals(Retangulo retangulo) {
		if(this.getEsquerdoSuperior().equals(retangulo.getEsquerdoSuperior()) && this.getDireitoInferior().equals(retangulo.getDireitoInferior()))
			return true;
		
		return false;
	}
	
	public boolean equalsArea(Retangulo retangulo) {
		if(this.calculaArea() == retangulo.calculaArea())
			return true;
		
		return false;
	}
	
	public int compareTo(Retangulo retangulo) {
		if(this.calculaArea() > retangulo.calculaArea())
			return 1;
		else if(this.equals(retangulo))
			return 0;
		else
			return -1;
	}
	
}
