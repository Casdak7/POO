
public class Data {

	private int dia;
	private int mes;
	private int ano;

	Data() throws Exception{
		setData(1, 1, 1900);
	}

	Data(int mes, int ano) throws Exception{
		setData(1, mes, ano);
	}

	Data(int dia, int mes, int ano) throws Exception{
		setData(dia, mes, ano);
	}

	Data(String data) throws Exception{

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

	Data(int dia, String mesS, int ano) throws Exception{

		int mes = whatMes(mesS);

		setData(dia, mes, ano);

	}

	public Data getData() {
		return this;
	}

	public boolean setData(int dia, int mes, int ano) throws Exception {

		if(!isDataValida(dia, mes, ano)) {
//			System.out.println("Atribuindo Valor padr�o 01/01/1900");
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

	public static boolean isBissexto(int ano) {
		if(ano % 4 == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isBissexto() {
		if(this.ano % 4 == 0) {
			return true;
		} else {
			return false;
		}
	}

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

	public String toString() {
		StringBuilder dataString = new StringBuilder();
		dataString.append(this.dia).append("/").append(this.mes).append("/").append(this.ano);
		return (dataString.toString());
	}

	public int whatMes(String mes) {
		
		if(mes.toUpperCase().equals("JANEIRO")) {
			return 1;		
		} else if(mes.toUpperCase().equals("FEVEREIRO")) {
			return 2;
		} else if(mes.toUpperCase().equals("MARCO")) {
			return 3;
		} else if(mes.toUpperCase().equals("MAR�O")) {
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

//	public void showError(int i) throws Exception {
//		switch(i) {
//		case 1:
//			System.out.println("Erro! Nao segue formato d/m/aaaa ou dd/mm/aaaa");	
//			break;
//		case 2:
//			System.out.println("Erro! String muito longa ou muito curta");
//			break;
//		default:
//			System.out.println("Erro! Sem mensagem de Erro");
//			break;
//		}
//
////		System.out.println("Atribuindo Valor padr�o 01/01/1900");
//		try {
//			setData(1, 1, 1900);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	public void showError() throws Exception {
//		System.out.println("Erro! Sem mensagem de Erro");
//		System.out.println("Atribuindo Valor padr�o 01/01/1900");
//		setData(1, 1, 1900);
//	}
	
	public boolean equals(Data data) {
		
		if(this.toString().equals(data.toString())) {
			return true;
		}
		
		return false;
		
	}
	
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
	
	//Deve ser nao-estatica na versao atual pois precisa-se comparar dois objetos diferentes
	//Logo, precisa-se de uma data para comparar. Para ser estatico, bastava receber como argumento
	//duas datas, seja em formato de string e construir dentro do metodo ou dois objetos data
	//como argumento
	public int compareTo(Data _data) {
		if (this.ano > _data.ano)
			return 1;
		else if(this.ano == _data.ano) {
			if(this.mes > _data.mes)
				return 1;
			else if(this.mes == _data.mes) {
				if(this.dia > _data.dia)
					return 1;
				else if(this.dia == _data.dia)
					return 0;
				else
					return -1;
					
			} else
				return -1;
		} else
			return -1;
	}
}
