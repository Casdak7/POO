
public class Esfera implements ObjetoTridimensional {
	private Ponto3D centro;
	private double raio;
	
	public Esfera() throws Exception {
		this.setCentro(0,0,0);
		this.setRaio(1);
	}
	
	public Esfera(Ponto3D centro, double raio) throws Exception {
		this.setCentro(centro);
		this.setRaio(raio);
	}
	
	public Esfera(double raio) throws Exception {
		this.setCentro(0,0,0);
		this.setRaio(raio);
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
	
	@Override
	public Ponto3D centro() {
		return this.getCentro();
	}

	@Override
	public double calculaVolume() {
		double volume = (4/3) * Math.PI *Math.pow(this.getRaio(), 3);
		return volume;
	}

	@Override
	public double calculaSuperficie() {
		double superficie = 4 * Math.PI * Math.pow(this.getRaio(), 2);
		return superficie;
	}
	
}
