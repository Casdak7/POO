import java.util.Scanner;

public class Uso {

	public static void main(String[] args) {
		
		//Contadores e variavel para sair de loop antes das 50 iteracoes
		int i = 0;
		int j = 0;
		boolean exit = false;
		
		//Variavel que controla fluxo do programa
		int control;
		
		//Variaveis que receberao os inputs
		String newTexto;
		Double newLinha;
		Double newColuna;
		String newSombra;
		
		//Vetor que armazenara as novas CaixaTexto
		CaixaTexto []registros = new CaixaTexto[50];
		
		Scanner input = new Scanner(System.in);
		
		for(i = 0; i < 50; i++) {
			System.out.println("1 - Nova Caixa Texto sem Sombra");
			System.out.println("2 - Nova Caixa Texto com Sombra");
			System.out.println("-1 - Sair");
			System.out.print("Iteracao " + i + " - Digite um Commando: ");
			control = input.nextInt();
			switch(control) {
			case 1:
				System.out.print("Texto: ");
				newTexto = input.next();
				System.out.print("Linha: ");
				newLinha = input.nextDouble();
				System.out.print("Coluna: ");
				newColuna = input.nextDouble();
				try {
					registros[i] = new CaixaTexto(newTexto, newLinha, newColuna);
				} catch (Exception e) {
					i--;
					e.printStackTrace();
				}
				break;
			case 2:
				System.out.print("Texto: ");
				newTexto = input.next();
				System.out.print("Linha: ");
				newLinha = input.nextDouble();
				System.out.print("Coluna: ");
				newColuna = input.nextDouble();
				System.out.print("Sombra: ");
				newSombra = input.next();
				try {
					registros[i] = new CaixaTextoSombra(new Texto(newTexto), newLinha, newColuna, newSombra);
				} catch (Exception e) {
					i--;
					e.printStackTrace();
				}
				break;
			case -1:
				exit = true;
				break;
			default:
				System.out.println("Entrada Invalida!");
				i--;
				break;		
			}
			
			if(exit)
				break;
		}
		
		input.close();
		
		for(j = 0; j < i; j++) {
			System.out.println(j + " - " + registros[j].toString());
		}
		
		System.exit(1);;
	}

}
