
public class CilindroEscalavel implements ObjetoTridimensional, Escalavel {
	private Ponto3D centro;
	private double raio;
	private double altura;
	
	public CilindroEscalavel() throws Exception {
		this.setCentro(0,0,0);
		this.setRaio(1);
		this.setAltura(1);
	}
	
	public CilindroEscalavel(Ponto3D centro, double raio, double altura) throws Exception {
		this.setCentro(centro);
		this.setRaio(raio);
		this.setAltura(altura);
	}
	
	public CilindroEscalavel(double raio, double altura) throws Exception {
		this.setCentro(0,0,0);
		this.setRaio(raio);
		this.setAltura(altura);
	}
	
	public Ponto3D getCentro() {
		return centro;
	}
	
	public void setCentro(Ponto3D centro) {
		this.centro = centro;
	}
	
	public void setCentro(double x, double y, double z) throws Exception {
		this.centro = new Ponto3D(x,y,z);
	}
	
	public double getRaio() {
		return raio;
	}
	
	public void setRaio(double raio) {
		this.raio = raio;
	}
	
	public double getAltura() {
		return altura;
	}
	
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	@Override
	public void amplia(double escala) {
		this.setAltura(escala * this.getAltura());
		this.setRaio(escala * this.getRaio());
	}

	@Override
	public void espelha() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Ponto3D centro() {
		return this.getCentro();
	}

	@Override
	public double calculaVolume() {
		double volume = Math.PI * Math.pow(this.getRaio(), 2) * this.getAltura();
		return volume;
	}

	@Override
	public double calculaSuperficie() {
		double superficie = 2 * Math.PI * this.getRaio() * this.altura + 2 * Math.PI * Math.pow(this.getRaio(), 2);
		return superficie;
	}


}
