package Aplicacao;

import java.util.Scanner;
import Matematica.ConstantesMatematicas;

public class Uso {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Digite um numero inteiro para saber sua raiz quadrada:");
		int numero = entrada.nextInt();

		
		System.out.println(ConstantesMatematicas.RAIZDE[numero]);
		entrada.close();
		
	}

}
