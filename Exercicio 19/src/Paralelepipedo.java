
public class Paralelepipedo implements ObjetoTridimensional{
	private Ponto3D pontoDiagonalA;
	private Ponto3D pontoDiagonalB;
	
	public Paralelepipedo() throws Exception {
		this.setPontoDiagonalA(0,0,0);
		this.setPontoDiagonalB(1, 1, 1);
	}
	
	public Paralelepipedo(Ponto3D diagonalA, Ponto3D diagonalB) throws Exception {
		this.setPontoDiagonalA(diagonalA);
		this.setPontoDiagonalB(diagonalB);
	}
	
	public Paralelepipedo(Ponto3D diagonalB) throws Exception {
		this.setPontoDiagonalA(0,0,0);
		this.setPontoDiagonalB(diagonalB);
	}
	
	public Ponto3D getPontoDiagonalA() {
		return pontoDiagonalA;
	}
	
	public void setPontoDiagonalA(Ponto3D pontoDiagonalA) {
		this.pontoDiagonalA = pontoDiagonalA;
	}
	
	public void setPontoDiagonalA(double x, double y, double z) throws Exception {
		this.pontoDiagonalA = new Ponto3D(x,y,z);
	}

	public Ponto3D getPontoDiagonalB() {
		return pontoDiagonalB;
	}

	public void setPontoDiagonalB(Ponto3D pontoDiagonalB) {
		this.pontoDiagonalB = pontoDiagonalB;
	}
	
	public void setPontoDiagonalB(double x, double y, double z) throws Exception {
		this.pontoDiagonalA = new Ponto3D(x,y,z);
	}

	@Override
	public Ponto3D centro() {
		double centroX = (this.getPontoDiagonalB().getX() + this.getPontoDiagonalA().getX())/2;
		double centroY = (this.getPontoDiagonalB().getY() + this.getPontoDiagonalA().getY())/2;
		double centroZ = (this.getPontoDiagonalB().getZ() + this.getPontoDiagonalA().getZ())/2;
		try {
			return new Ponto3D(centroX, centroY, centroZ);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public double calculaVolume() {
		double a = this.getPontoDiagonalB().getX() - this.getPontoDiagonalA().getX();
		double b = this.getPontoDiagonalB().getY() - this.getPontoDiagonalA().getY();
		double c = this.getPontoDiagonalB().getZ() - this.getPontoDiagonalA().getZ();
		double volume = a*b*c;
		return volume;
	}

	@Override
	public double calculaSuperficie() {
		double a = this.getPontoDiagonalB().getX() - this.getPontoDiagonalA().getX();
		double b = this.getPontoDiagonalB().getY() - this.getPontoDiagonalA().getY();
		double c = this.getPontoDiagonalB().getZ() - this.getPontoDiagonalA().getZ();
		double superficie = 2*a*b + 2*a*c + 2*b*c;
		return superficie;
	}
	
}
