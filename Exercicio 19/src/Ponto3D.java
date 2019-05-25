
public class Ponto3D extends Ponto{
	private double z;
	
	public double getZ() {
		return z;
	}
	
	public void setZ(double z) throws Exception {
		if(Ponto.isLimite(z)) 	
        	this.z = z;
		else
        	throw new Exception ("valor de z fora dos limites");
	}
	
	public Ponto3D() throws Exception {
		super();
		this.setZ(0);
	}
	
	public Ponto3D(double x, double y, double z) throws Exception {
		super(x, y);
		this.setZ(0);
	}
	
	public Ponto3D clonar() throws Exception {
     	return new Ponto3D(super.getX(), super.getY(), this.getZ());
	}
	

	public boolean temEixoComum(Ponto3D ponto){
     	return (super.temEixoComum((Ponto) ponto) || (this.getZ() == ponto.getZ()));
	}
	
	static public double distancia(double x1, double y1, double z1, double x2, double y2,  double z2){
     	return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)+(z1-z2)*(z1-z2));
	}
	
	public double distancia(Ponto3D ponto){
     	return Ponto3D.distancia(this.getX(),this.getY(), this.getZ(),ponto.getX(),ponto.getY(), ponto.getZ());
	}
	
	public double distancia(double _x, double _y, double _z){
     	return Ponto3D.distancia(this.getX(),this.getY(),this.getZ(),_x,_y,_z);
	}
	
	public double distanciaDaOrigem(){
     	return Ponto3D.distancia(this.getX(),this.getY(),this.getZ(),0,0,0);
	}
	
	public int compareTo(Ponto3D _ponto){
     	if (this.distanciaDaOrigem() > _ponto.distanciaDaOrigem())
            	return 1;
     	else if(this.distanciaDaOrigem() < _ponto.distanciaDaOrigem())
            	return -1;
     	else
            	return 0;
	}
	
	public boolean equals(Object obj) {
     	if (this == obj)
            	return true;
     	if (obj == null)
            	return false;
     	if (getClass() != obj.getClass())
            	return false;
     	final Ponto3D other = (Ponto3D) obj;
     	if (Double.doubleToLongBits(super.getX()) != Double.doubleToLongBits(other.getX()))
            	return false;
     	if (Double.doubleToLongBits(super.getY()) != Double.doubleToLongBits(other.getY()))
            	return false;
     	if (Double.doubleToLongBits(this.getZ()) != Double.doubleToLongBits(other.getZ()))
     			return false;
     	return true;
	}
	
	@Override
	public String toString(){
     	StringBuilder coord = new StringBuilder();
     	coord.append("(");
     	coord.append(super.getX());
     	coord.append(",");
     	coord.append(+super.getY());
     	coord.append(",");
     	coord.append(+this.getZ());
     	coord.append(")");
     	return coord.toString();
	}


}
