package dataTempo;

import java.io.Serializable;
import java.util.Comparator;

/**Classe que representa uma data e controla manipulações de datas do tipo dd/mm/yyyy ou d/m/yyyy.
 * 
 * @author Cassio Fernandes
 * @version 1.0
 *
 */
@SuppressWarnings("serial")
public class Data implements Comparable<Data>, Serializable{

	private int dia;
	private int mes;
	private int ano;
	
	/**Construtor padrão da classe Data
	 * 
	 * @return Data 1/1/1900
	 * @throws Exception
	 * @version 1.0 (junho-2019)
	 */
	public Data() throws Exception{
		setData(1, 1, 1900);
	}
	
	/**Construtor de Data com dia instanciado em 1
	 * 
	 * @param mes : aceita valores de 1 a 12
	 * @param ano : aceita valores maiores que 1562
	 * @throws Exception
	 * @version 1.0 (junho-2019)
	 */
	public Data(int mes, int ano) throws Exception{
		setData(1, mes, ano);
	}
	
	/**Construtor de Data completo
	 * 
	 * @param dia : aceita valores de 1 a 31 (Depende do mês)
	 * @param mes : aceita valores de 1 a 12
	 * @param ano : aceita valores maiores que 1562
	 * @throws Exception
	 * @version 1.0 (junho-2019)
	 */
	public Data(int dia, int mes, int ano) throws Exception{
		setData(dia, mes, ano);
	}
	
	/**
	 * Construtor de Data através de uma String no formato dd/mm/yyyy
	 * 
	 * @param data
	 * @throws Exception
	 * @version 1.0 (junho-2019)
	 */
	public Data(String data) throws Exception{

		int dia = 0, mes = 0, ano = 0;

		//Confere se a string possui o tamanho correto para ser do tipo d/m/aaaa ou dd/mm/aaaa
		if(data.length() < 8 || data.length() > 10) {
			throw new Exception("Formato de Data Incorreto!");
		} else {

			//Confere a localizacao do caracter / para saber se e do tipo d/ ou dd/
			if(data.substring(1,2).contentEquals("/")) {
				try {
					dia = Integer.parseInt(data.substring(0,1));
				} catch(Exception exception) {
					throw new Exception("Formato de Data Incorreto, valores nao numericos!");
				}

				//Confere a localizacao do caracter / para saber se e do tipo m/ ou mm/
				if(data.substring(3,4).contentEquals("/")) {
					try {
						mes = Integer.parseInt(data.substring(2,3));
						ano = Integer.parseInt(data.substring(4, 8));
					} catch(Exception exception){
						throw new Exception("Formato de Data Incorreto, valores nao numericos!");
						
					}

				} else if(data.substring(4,5).contentEquals("/")) {
					try {
						mes = Integer.parseInt(data.substring(2,4));
						ano = Integer.parseInt(data.substring(5, 9));
					} catch(Exception exception){
						throw new Exception("Formato de Data Incorreto, valores nao numericos!");
					}
				} else {
					throw new Exception("Formato de Data Incorreto!");
				}
			} else if(data.substring(2,3).contentEquals("/")) {
				try {
					dia = Integer.parseInt(data.substring(0,2));
				} catch(Exception exception) {
					throw new Exception("Formato de Data Incorreto!");
				}

				//Confere a localizacao do caracter / para saber se e do tipo m/ ou mm/
				if(data.substring(4,5).contentEquals("/")) {
					try {
						mes = Integer.parseInt(data.substring(3,4));
						ano = Integer.parseInt(data.substring(5, 9));
					} catch(Exception exception) {
						throw new Exception("Formato de Data Incorreto, valores nao numericos!");
					}
				} else if(data.substring(5,6).contentEquals("/")) {
					try {
						mes = Integer.parseInt(data.substring(3,5));
						ano = Integer.parseInt(data.substring(6, 10));
					} catch(Exception exception) {
						throw new Exception("Formato de Data Incorreto, valores nao numericos!");
					}
				} else {
					throw new Exception("Formato de Data Incorreto!");
				}
			} else {
				throw new Exception("Formato de Data Incorreto!");
			}

			setData(dia, mes, ano);
		}
	}
	
	/**
	 * Construtor de Data que aceita um mes pelo seu nome em String
	 * @param dia
	 * @param mesS
	 * @param ano
	 * @throws Exception
	 * @version 1.0 (junho-2019)
	 */
	public Data(int dia, String mesS, int ano) throws Exception{

		int mes = whatMes(mesS);

		setData(dia, mes, ano);

	}
	
	/**
	 * Retorna o objeto data atual
	 * @return Data
	 * @version 1.0 (junho-2019)
	 */
	public Data getData() {
		return this;
	}
	
	/**
	 * Atribui os atributos de Data dado os parâmetros
	 * @param dia
	 * @param mes
	 * @param ano
	 * @return boolean
	 * @throws Exception
	 * @version 1.0 (junho-2019)
	 */
	public boolean setData(int dia, int mes, int ano) throws Exception {

		if(!isDataValida(dia, mes, ano)) {
//			System.out.println("Atribuindo Valor padrão 01/01/1900");
//			this.ano = 1900;
//			this.mes = 1;
//			this.dia = 1;
			
			throw new Exception("Data Invalida!");
		} else {
			this.ano = ano;
			this.mes = mes;
			this.dia = dia;
		}

		return true;
	}
	
	/**
	 * Confere se o ano é bissexto, caso seja retorna true
	 * @param ano 
	 * @return boolean
	 * @version 1.0 (junho-2019)
	 */
	public static boolean isBissexto(int ano) {
		if(ano % 4 == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Confere se o ano da Data é bissexto, caso seja retorna true
	 * @param ano 
	 * @return boolean
	 * @version 1.0 (junho-2019)
	 */
	public boolean isBissexto() {
		if(this.ano % 4 == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Retorna true caso a data seja válida, com dia, mes, e ano (> 1562) válidos
	 * @param dia
	 * @param mes
	 * @param ano
	 * @return boolean
	 * @version 1.0 (junho-2019)
	 */
	public static boolean  isDataValida(int dia, int mes, int ano) {

		if(ano < 1582) {
//			System.out.println("Erro! Ano deve ser maior que 1582");
			return false;
		}

		if(mes <= 0 || mes > 12) {
//			System.out.println("Erro! Mes deve possuir um valor de 1 a 12.");
			return false;
		}

		if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
			if(!(dia > 0 && dia <= 31)) {
//				StringBuilder erro = new StringBuilder();
//				erro.append("Erro! O mes ").append(mes).append(" deve receber um valor de dia de 1 a 31");
//				System.out.println(erro.toString());
				return false;
			}
		} else if(mes == 4 || mes == 6 || mes == 9 || mes == 11) {
			if(!(dia > 0 && dia <= 30)) {
//				StringBuilder erro = new StringBuilder();
//				erro.append("Erro! O mes ").append(mes).append(" deve receber um valor de dia de 1 a 30");
//				System.out.println(erro.toString());
				return false;
			}
		} else {
			if(isBissexto(ano)) {
				if(!(dia > 0 && dia <= 29)) {
//					StringBuilder erro = new StringBuilder();
//					erro.append("Erro! O mes ").append(mes).append(" de um ano bissexto deve receber um valor de dia de 1 a 29");
//					System.out.println(erro.toString());
					return false;
				}
			} else {
				if(!(dia > 0 && dia <= 28)) {
//					StringBuilder erro = new StringBuilder();
//					erro.append("Erro! O mes ").append(mes).append(" deve receber um valor de dia de 1 a 28");
//					System.out.println(erro.toString());
					return false;
				}
			}
		}

		return true;
	}
	
	/**
	 * 
	 * @return ano
	 */
	public int getAno() {
		return ano;
	}
	
	/**
	 * Retorna uma representação da data em String da forma dd/mm/yyyy
	 * @return String
	 * @version 1.0 (junho-2019)
	 */
	public String toString() {
		StringBuilder dataString = new StringBuilder();
		dataString.append(this.dia).append("/").append(this.mes).append("/").append(this.ano);
		return (dataString.toString());
	}
	
	/**
	 * Converte uma String do nome do mês em um inteiro que represente este mês. Caso nenhum mês represente retorna 0
	 * @param mes
	 * @return int
	 * @version 1.0 (junho-2019)
	 */
	public int whatMes(String mes) {
		
		if(mes.toUpperCase().equals("JANEIRO")) {
			return 1;		
		} else if(mes.toUpperCase().equals("FEVEREIRO")) {
			return 2;
		} else if(mes.toUpperCase().equals("MARCO")) {
			return 3;
		} else if(mes.toUpperCase().equals("MARÇO")) {
			return 3;
		} else if(mes.toUpperCase().equals("ABRIL")) {
			return 4;
		} else if(mes.toUpperCase().equals("MAIO")) {
			return 5;
		} else if(mes.toUpperCase().equals("JUNHO")) {
			return 6;
		} else if(mes.toUpperCase().equals("JULHO")) {
			return 7;
		} else if(mes.toUpperCase().equals("AGOSTO")) {
			return 8;
		} else if(mes.toUpperCase().equals("SETEMBRO")) {
			return 9;
		} else if(mes.toUpperCase().equals("OUTUBRO")) {
			return 10;
		} else if(mes.toUpperCase().equals("NOVEMBRO")) {
			return 11;
		} else if(mes.toUpperCase().equals("DEZEMBRO")) {
			return 12;
		}
		
		return 0;
	}
	
	/**
	 * Retorna true caso dia, mes e ano sejam iguais ao dia, mes e ano da outra Data
	 * @param data
	 * @return boolean
	 * @version 1.0 (junho-2019)
	 */
	public boolean equals(Data data) {
		
		if(this.toString().equals(data.toString())) {
			return true;
		}
		
		return false;
		
	}
	
	/**
	 * Retorna true caso esta Data.toString() sejam iguais a String data
	 * @param data
	 * @return boolean
	 * @version 1.0 (junho-2019)
	 */
	public boolean equals(String data) {
		
		if(this.toString().equals(data)) {
			return true;
		}
		
		return false;
	}
	
	public static Data verificaECriaData(int dia, int mes, int ano) {
		Data data;
		try {
			data = new Data(dia, mes, ano);
		} catch (Exception e) {
			return null;
		}
		
		return data;
	}
	
	/**
	 * Compara dois objetos Data e vê qual a sua ordem de acordo com a ordenação natural das datas
	 * 
	 * @param data
	 * @return 1 caso maior, 0 caso igual, -1 caso menor
	 * @version 1.0 (junho-2019)
	 */
	public int compareTo(Data data) {
		if (this.ano > data.ano)
			return 1;
		else if(this.ano == data.ano) {
			if(this.mes > data.mes)
				return 1;
			else if(this.mes == data.mes) {
				if(this.dia > data.dia)
					return 1;
				else if(this.dia == data.dia)
					return 0;
				else
					return -1;
					
			} else
				return -1;
		} else
			return -1;
	}
	
}

/**
 * Fornece um método para ser usado na ordenação de várias instâncias da classe
 * Data pela ordenacao natural de datas.
 * <p>
 * Esta ordenação é realizada pelo método estático sort da classe Collections
 *
 * @author Cassio Fernandes
 * @version 1.0 (junho-2019)
 *
 */
class ComparaData implements Comparator<Data> {
  	public int compare(Data data1, Data data2) {
        	return data1.compareTo(data2);
  	}
}

