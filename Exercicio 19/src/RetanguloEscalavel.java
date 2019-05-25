
public class RetanguloEscalavel implements ObjetoGeometrico,Escalavel {
	private Ponto superiorEsquerdo, inferiorDireito;
	
	public RetanguloEscalavel(Ponto superiorEsquerdo, Ponto inferiorDireito) {
		this.setSuperiorEsquerdo(superiorEsquerdo);
		this.setInferiorDireito(inferiorDireito);
	}
	
	public Ponto getSuperiorEsquerdo() {
		return superiorEsquerdo;
	}
	
	public void setSuperiorEsquerdo(Ponto superiorEsquerdo) {
		this.superiorEsquerdo = superiorEsquerdo;
	}
	
	public void setSuperiorEsquerdo(double x, double y) throws Exception {
		this.superiorEsquerdo.setX(x);
		this.superiorEsquerdo.setY(y);
	}
	
	public Ponto getInferiorDireito() {
		return inferiorDireito;
	}
	
	public void setInferiorDireito(Ponto inferiorDireito) {
		this.inferiorDireito = inferiorDireito;
	}
	
	public void setInferiorDireito(double x, double y) throws Exception {
		this.inferiorDireito.setX(x);
		this.inferiorDireito.setY(y);
	}
	
	
	
	@Override
	public void amplia(double escala) {
		try {
			this.setInferiorDireito(this.getInferiorDireito().getX()*escala, this.getInferiorDireito().getY() * escala);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void espelha() {
		Ponto auxiliar = this.getInferiorDireito();
		
		this.setInferiorDireito(this.getSuperiorEsquerdo());
		this.setSuperiorEsquerdo(auxiliar);
	}

	@Override
	public Ponto centro() {
		double centroY = Math.pow(Math.pow(this.getSuperiorEsquerdo().getY(), 2) + Math.pow(this.getInferiorDireito().getY(), 2), 0.5);
		double centroX = Math.pow(Math.pow(this.getSuperiorEsquerdo().getX(), 2) + Math.pow(this.getInferiorDireito().getX(), 2), 0.5);
		Ponto centro = null;
		try {
			centro = new Ponto(centroX,centroY);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return centro;
	}

	@Override
	public double calculaÁrea() {
		double area = (this.getInferiorDireito().getX() - this.getSuperiorEsquerdo().getX()) * (this.superiorEsquerdo.getY() - this.getInferiorDireito().getY());
		return area;
	}

	@Override
	public double calculaPerímetro() {
		double perimetro = ((this.getInferiorDireito().getX() - this.getSuperiorEsquerdo().getX()) * 2) + ((this.superiorEsquerdo.getY() - this.getInferiorDireito().getY()) * 2);
		return perimetro;
	}


}
