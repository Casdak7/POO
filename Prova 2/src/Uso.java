import java.util.Scanner;

import agenda.Agenda;
import agenda.*;
import dataTempo.*;

public class Uso {
	static Scanner entrada = new Scanner(System.in);
	public static void main(String[] args) {
		int control;
		boolean quit = false;
		
//		Data dataInicio = null;
//		Data dataFim = null;
//		Horario horarioInicio;
//		Horario horarioFim;
//		String entradaString;
//		int entradaInteira;
		
		Periodo periodo = null;
		String local;
		int prioridade;
		int minutos;
		String titulo;
		String descricao;
		
		
		Agenda agenda = new Agenda();
		
		while(!quit) {
			System.out.println("Menu:\n "
					+ "1-Listar Agenda\n "
					+ "2-Criar Evento\n "
					+ "3-Criar Lembrete\n "
					+ "4-Criar Meta\n "
					+ "5-Listar por Periodo\n "
					+ "6-Listar Metas por Prioridade\n "
					+ "7-Listar Eventos por Local\n "
					+ "8-Listar Lembretes por ordem de minutos para alarme\n "
					+ "9-Sair");
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
				periodo = Uso.inputPeriodo();
				titulo = Uso.inputTitulo();
				descricao = Uso.inputDescricao();
				System.out.print("Minutos para alerta:");
				minutos = entrada.nextInt();
				try {
					agenda.insere(new Lembrete(minutos, titulo, descricao, periodo));
				} catch (Exception e) {
					System.out.println("Minutos para Alerta inválido!");
					e.printStackTrace();
				}
				break;
			case 4:
				periodo = Uso.inputPeriodo();
				titulo = Uso.inputTitulo();
				descricao = Uso.inputDescricao();
				System.out.print("Prioridade:");
				prioridade = entrada.nextInt();
				agenda.insere(new Meta(prioridade, titulo, descricao, periodo));
				break;
			case 5:
			case 6:
				System.out.println(agenda.getMetasPorPrioridade().toString());
				break;
			case 7:
				System.out.println(agenda.getEventosPorLocal().toString());
				break;
			case 8:
				System.out.println(agenda.getLembretesPorMinutos().toString());
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
		Data dataInicio = null;
		Data dataFim = null;
		Horario horarioInicio = null;
		Horario horarioFim = null;
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
		periodo = new Periodo(dataInicio, horarioInicio, dataFim, horarioFim);
//		System.out.println(periodo.getData_inicio().toString()+" - "+periodo.getData_fim().toString());
		return periodo;
	}
	
	public static String inputString(String mensagem) {
		String entradaString;
		
		System.out.print(mensagem);
		entradaString = entrada.next();
		return entradaString;	
	}
	
	public static String inputTitulo() {
		String input = inputString("Titulo: ");
		return input;
	}
	
	public static String inputDescricao() {
		String input = inputString("Descricao: ");
		return input;
	}
	
	public static String inputLocal() {
		String input = inputString("Local: ");
		return input;
	}

}
