
public class Data {
	
	private int dia;
	private int mes;
	private int ano;
	
	Data(){
		setData(1, 1, 1900);
	}
	
	Data(int mes, int ano){
		setData(1, mes, ano);
	}
	
	Data(int dia, int mes, int ano){
		setData(dia, mes, ano);
	}
	
	Data(String data){
		
		int dia = 0, mes = 0, ano = 0;
		
		//Confere se a string possui o tamanho correto para ser do tipo d/m/aaaa ou dd/mm/aaaa
		if(data.length() < 8 || data.length() > 10) {
			showError(2);
		} else {
		
			//Confere a localizacao do caracter / para saber se e do tipo d/ ou dd/
			if(data.substring(1,2).contentEquals("/")) {
				try {
					dia = Integer.parseInt(data.substring(0,1));
				} catch(Exception exception) {
					showError(1);
					return;
				}
				
				//Confere a localizacao do caracter / para saber se e do tipo m/ ou mm/
				if(data.substring(3,4).contentEquals("/")) {
					try {
						mes = Integer.parseInt(data.substring(2,3));
						ano = Integer.parseInt(data.substring(4, 8));
					} catch(Exception exception){
						showError(1);
						return;
					}

				} else if(data.substring(4,5).contentEquals("/")) {
					try {
						mes = Integer.parseInt(data.substring(2,4));
						ano = Integer.parseInt(data.substring(5, 9));
					} catch(Exception exception){
						showError(1);
						return;
					}
				} else {
					showError(1);
					return;
				}
			} else if(data.substring(2,3).contentEquals("/")) {
				try {
					dia = Integer.parseInt(data.substring(0,2));
				} catch(Exception exception) {
					showError(1);
					return;
				}
				
				//Confere a localizacao do caracter / para saber se e do tipo m/ ou mm/
				if(data.substring(4,5).contentEquals("/")) {
					try {
						mes = Integer.parseInt(data.substring(3,4));
						ano = Integer.parseInt(data.substring(5, 9));
					} catch(Exception exception) {
						showError(1);
						return;
					}
				} else if(data.substring(5,6).contentEquals("/")) {
					try {
						mes = Integer.parseInt(data.substring(3,5));
						ano = Integer.parseInt(data.substring(6, 10));
					} catch(Exception exception) {
						showError(1);
						return;
					}
				} else {
					showError(1);
					return;
				}
			} else {
				showError(1);
				return;
			}
			
			setData(dia, mes, ano);
		}
	}
	
	Data(int dia, String mesS, int ano){
		
		int mes = whatMes(mesS);
		
		setData(dia, mes, ano);
		
	}
	
	public Data getData() {
		return this;
	}
	
	public boolean setData(int dia, int mes, int ano) {
		
		this.ano = ano;
		this.mes = mes;
		this.dia = dia;
		
		if(!isDataValida(this)) {
			System.out.println("Atribuindo Valor padr�o 01/01/1900");
			this.ano = 1900;
			this.mes = 1;
			this.dia = 1;
		}
		
		return true;
	}
	
	public boolean isBissexto(int ano) {
		if(ano % 4 == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isDataValida(Data data) {
		
		if(data.ano < 1582) {
			System.out.println("Erro! Ano deve ser maior que 1582");
			return false;
		}
		
		if(data.mes <= 0 || data.mes > 12) {
			System.out.println("Erro! Mes deve possuir um valor de 1 a 12.");
			return false;
		}
		
		if(this.mes == 1 || this.mes == 3 || this.mes == 5 || this.mes == 7 || this.mes == 8 || this.mes == 10 || this.mes == 12) {
			if(!(this.dia > 0 && this.dia <= 31)) {
				System.out.println("Erro! O mes " + mes + " deve receber um valor de dia de 1 a 31");
				return false;
			}
		} else if(mes == 4 || mes == 6 || mes == 9 || mes == 11) {
			if(!(dia > 0 && dia <= 30)) {
				System.out.println("Erro! O mes " + mes + " deve receber um valor de dia de 1 a 30");
				return false;
			}
		} else {
			if(isBissexto(ano)) {
				if(!(dia > 0 && dia <= 29)) {
					System.out.println("Erro! O mes " + mes + " de um ano bissexto deve receber um valor de dia de 1 a 29");
					return false;
				}
			} else {
				if(!(dia > 0 && dia <= 28)) {
					System.out.println("Erro! O mes " + mes + " deve receber um valor de dia de 1 a 28");
					return false;
				}
			}
		}
		
		return true;
	}
	
	public String toString() {
		
		return (this.dia + "/" + this.mes + "/" + this.ano);
	}
	
	public int whatMes(String mes) {
		
		switch(mes.toUpperCase()) {
		case "JANEIRO":
			return 1;
		case "FEVEREIRO":
			return 2;
		case "MARCO":
			return 3;
		case "ABRIL":
			return 4;
		case "MAIO":
			return 5;
		case "JUNHO":
			return 6;
		case "JULHO":
			return 7;
		case "AGOSTO":
			return 8;
		case "SETEMBRO":
			return 9;
		case "OUTUBRO":
			return 10;
		case "NOVEMBRO":
			return 11;
		case "DEZEMBRO":
			return 12;
		default:
			return 0;
		}
		
	}
	
	public void showError(int i) {
		switch(i) {
		case 1:
			System.out.println("Erro! Nao segue formato d/m/aaaa ou dd/mm/aaaa");	
			break;
		case 2:
			System.out.println("Erro! String muito longa ou muito curta");
			break;
		default:
			System.out.println("Erro! Sem mensagem de Erro");
			break;
		}
		
		System.out.println("Atribuindo Valor padr�o 01/01/1900");
		setData(1, 1, 1900);
	}
	
	public void showError() {
		System.out.println("Erro! Sem mensagem de Erro");
		System.out.println("Atribuindo Valor padr�o 01/01/1900");
		setData(1, 1, 1900);
	}
}
