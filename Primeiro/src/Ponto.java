import java.util.Scanner;

public class Ponto {

	static public final double LIMITE_INFERIOR_DEFAULT = 0;
	static public final double LIMITE_SUPERIOR_DEFAULT = 500;

	private double x;
	private double y;
	static private double limiteInferior = LIMITE_INFERIOR_DEFAULT; 
	static private double limiteSuperior = LIMITE_SUPERIOR_DEFAULT;
	
	public Ponto() throws Exception{
		setPonto(0, 0);
	}
	
	public Ponto(double x, double y) throws Exception{
		setPonto(x, y);
	}
	
	public Ponto(String ponto) throws Exception{
		String[] stringArray = ponto.split(",|\\(|\\)");
		double x = Double.parseDouble(stringArray[0]);
		double y = Double.parseDouble(stringArray[1]);
		setPonto(x, y);
	}
	
	public double getX() {
		return x;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public static double getLimiteInferior() {
		return limiteInferior;
	}
	
	public static void setLimiteInferior(double limiteInferior) {
		Ponto.limiteInferior = limiteInferior;
	}
	
	public static double getLimiteSuperior() {
		return limiteSuperior;
	}
	
	public static void setLimiteSuperior(double limiteSuperior) {
		Ponto.limiteSuperior = limiteSuperior;
	}
	
	public void setPonto(double x, double y) throws Exception {
		
		if(x < Ponto.limiteInferior || y < Ponto.limiteInferior) {
			throw new Exception("Ponto Invalido, excede limite inferior!");
		}
		
		if(x > Ponto.limiteSuperior || y > limiteSuperior) {
			throw new Exception("Ponto Invalido, excede limite superior!");
		}
		
		this.setX(x);
		this.setY(y);
	}
	
	public static void setLimites(double limiteInferior, double limiteSuperior) throws Exception{
		if(limiteInferior >= limiteSuperior)
			throw new Exception("Limite Inferior deve ser menor que o Limite Superior!");
		
		Ponto.setLimiteInferior(limiteInferior);
		Ponto.setLimiteSuperior(limiteSuperior);
	}
	
	public boolean equals(Ponto ponto) {
		if(this.x == ponto.x && this.y == ponto.y)
			return true;
		
		return false;
	}
	
	public String toString() {
		StringBuilder pontoString = new StringBuilder();
		pontoString.append("(").append(this.x).append(",").append(this.y).append(")");
		return pontoString.toString();
	}
	
	
	//Criar novo ponto
	public Ponto clonePonto() throws Exception {
		return new Ponto(this.getX(), this.getY());
	}
	
	public Ponto criaSwap() throws Exception {
		Ponto pontoSwapped = new Ponto(this.y, this.x);
		return  pontoSwapped;
	}
	
	public boolean temEixoComum(Ponto ponto) {
		if(this.x == ponto.x)
			return true;
		
		if(this.y == ponto.y)
			return true;
		
		return false;
	}
	
	public double distancia(Ponto ponto) {
		double distanciaEuclidiana = 
				Math.sqrt((this.x-ponto.x)*(this.x-ponto.x)+(this.y-ponto.y)*(this.y-ponto.y));
		
		return distanciaEuclidiana;
	}
	
	public double distancia(double x, double y) {
		double distanciaEuclidiana = 
				Math.sqrt((this.x-x)*(this.x-x)+(this.y-y)*(this.y-y));
		
		return distanciaEuclidiana;
	}
	
	public static double distancia(double x1, double y1, double x2, double y2) {
		double distanciaEuclidiana = 
				Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
		
		return distanciaEuclidiana;
	}
	
	public static double distancia(Ponto ponto1, Ponto ponto2) {
		double distanciaEuclidiana = 
				ponto1.distancia(ponto2);
		
		return distanciaEuclidiana;
	}
	
	public double distanciaDaOrigem() {
		double distanciaEuclidiana = 
				this.distancia(0,0);
		
		return distanciaEuclidiana;
	}
	
	public int compareTo(Ponto ponto) {
		double d1 = this.distanciaDaOrigem();
		double d2 = ponto.distanciaDaOrigem();
		
		if(d1 < d2)
			return -1;
		else if(d1 == d2)
			return 0;
		else
			return 1;
	}
	
	static public void randomPontos() {
		Scanner input = new Scanner(System.in);
		double inputX;
		double inputY;
		System.out.print("Digite o x: ");
		inputX = input.nextDouble();
		System.out.print("Digite o y: ");
		inputY = input.nextDouble();
		
		input.close();
		
		Ponto userPonto = null;
		
		try {
			userPonto = new Ponto(inputX, inputY);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Ponto randomPonto = null;
		
		for(int i = 0; i < 100; i++) {
			try {
				randomPonto = new Ponto(Math.random()*501, Math.random()*501);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(i + ") Distancia entre " + userPonto.toString() +
					" - "+ randomPonto.toString() + ": " + userPonto.distancia(randomPonto));
		}
	}

}
