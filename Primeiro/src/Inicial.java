import java.util.Scanner;

public class Inicial {
	public static void main(String args[]) {
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
