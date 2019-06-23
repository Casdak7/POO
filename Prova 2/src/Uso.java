import java.util.Scanner;

import agenda.Agenda;
import agenda.*;
import dataTempo.*;

public class Uso {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		int control;
		boolean quit = false;
		
		Data dataInicio = null;
		Data dataFim = null;
		Horario horarioInicio;
		Horario horarioFim;
		String entradaString;
		int entradaInteira;
		Periodo periodo = null;
		
		String local;
		String titulo;
		String descricao;
		
		
		Agenda agenda = new Agenda();
		
		while(!quit) {
			System.out.println("Menu:\n 1-Listar Agenda\n 2-Criar Evento\n 3-Criar Lembrete\n 4-Criar Meta\n 9-Sair");
			System.out.print("Digite um comando:");
			control = entrada.nextInt();
			
			switch(control) {
			case 1:
				System.out.println(agenda.toString());
				break;
			case 2:
				periodo = inputPeriodo();
				titulo = inputTitulo();
				descricao = inputDescricao();
				local = inputLocal();
				agenda.insere(new Evento(local, titulo, descricao, periodo));
				break;
			case 3:

				break;
			case 4:
				break;
			case 9:
				System.out.println("Saindo...");
				quit = true;
				break;
			default:
				System.out.println("Comando Invalido!");
				break;
			}
		}
		
		entrada.close();
		System.exit(0);
	}
	
	public static Periodo inputPeriodo() {
		Scanner entrada = new Scanner(System.in);
		Data dataInicio = null;
		Data dataFim = null;
		Horario horarioInicio;
		Horario horarioFim;
		String entradaString;
		int entradaInteira;
		Periodo periodo = null;
		
		System.out.print("Data de Inicio (dd/mm/aaaa): ");
		entradaString = entrada.next();
		try {
			dataInicio = new Data(entradaString);
		} catch (Exception e) {
			System.out.println("Data Invalida");
			e.printStackTrace();
		}
		System.out.print("Data de Fim (dd/mm/aaaa): ");
		entradaString = entrada.next();
		try {
			dataFim = new Data(entradaString);
		} catch (Exception e) {
			System.out.println("Data Invalida");
			e.printStackTrace();
		}
		System.out.print("Horario de Inicio(hh:mm:ss): ");
		entradaString = entrada.next();
		try {
			horarioInicio = new Horario(entradaString);
		} catch (Exception e) {
			System.out.println("Horario Invalido!");
			e.printStackTrace();
		}
		System.out.print("Horario de Fim(hh:mm:ss): ");
		entradaString = entrada.next();
		try {
			horarioFim = new Horario(entradaString);
		} catch (Exception e) {
			System.out.println("Horario Invalido!");
			e.printStackTrace();
		}
//		System.out.println(dataInicio.toString()+" - "+dataFim.toString());
		periodo = new Periodo(dataInicio, new Horario(), dataFim, new Horario());
//		System.out.println(periodo.getData_inicio().toString()+" - "+periodo.getData_fim().toString());
		return periodo;
	}
	
	public static String inputString(String mensagem) {
		Scanner entrada = new Scanner(System.in);
		String entradaString;
		int entradaInteira;;
		
		System.out.print(mensagem);
		entradaString = entrada.next();
		return entradaString;	
	}
	
	public static String inputTitulo() {
		return inputString("Titulo: ");
	}
	
	public static String inputDescricao() {
		return inputString("Descricao: ");
	}
	
	public static String inputLocal() {
		return inputString("Local: ");
	}

}
