
public class Aluno {
	private String nome;
	private double nota1, nota2, media, pontos;
	static final public double DEFAULT_APROVACAO = 7.0;
	static final public double DEFAULT_LIMITE_NOTA = 10.0;
	static private double minimoAprovacao = Aluno.DEFAULT_APROVACAO;
	static private double limite_nota = Aluno.DEFAULT_LIMITE_NOTA;

	// quatro construtores sobrecarregados
	public Aluno(String _nome,double _nota1,double _nota2,double _pontos) throws Exception {
		this.setNome(_nome);
		this.setNotas(_nota1, _nota2, _pontos);
	}
	public Aluno(double _nota1, double _nota2, double _pontos) throws Exception {
		this("sem nome", _nota1, _nota2, _pontos);
	}
	public Aluno(double _nota1, double _nota2) throws Exception {
		this(_nota1, _nota2, 0.0);
	}
	public Aluno() throws Exception {
		this(0.0,0.0);
	}

	// m�todos de interface para acesso aos campos privados
	public String getNome() {      	
		return this.nome;  	
	}
	public void setNome(String _nome) {
		this.nome = _nome; 	
	}
	public double getNota1() {
		return this.nota1; 	
	}
	public double getNota2() {
		return this.nota2; 	
	}
	public double getMedia() {
		return this.media; 	
	}

	public double getPontos()  {
		return this.pontos;	
	}

	public void setPontos(double _pontos) {
		this.pontos = _pontos;
		this.calculaMedia();
	}

	// m�todos est�ticos de interface para o campo est�tico minimoAprovacao
	public static double getMinimoAprovacao() {
		return Aluno.minimoAprovacao;
	}

	public static void setMinimoAprovacao(double _minimoAprovacao) {
		Aluno.minimoAprovacao = _minimoAprovacao;
	} 
	
	public static double getLimiteNota() {
		return limite_nota;
	}

	public static void setLimiteNota(double limite_nota) {
		Aluno.limite_nota = limite_nota;
	}


	// tratamento de erros, escopo do programador de classes (comandos throw  e throws)
	public void setNotas(double _nota1, double _nota2,double _pontos)throws Exception {
		this.pontos = _pontos;
		if(_nota1>=0 && !ultrapassouLimite(_nota1) && _nota2>=0  && !ultrapassouLimite(_nota2)) {
			this.nota1 = _nota1;
			this.nota2 = _nota2;
			this.calculaMedia();
		}
		else
			// O comando throw desvia o processamento para o interior do catch que possui 
			// a classe do tipo do objeto lan�ado
			// Se for da categoria Exception (erro verificado) ent�o o uso de try-catch 
			// � obrigat�rio, ou ent�o, deve-se passar essa obrigatoriedade adiante com 
			// o comando throws no cabe�alho do m�todo
			throw new Exception("nota invalida");
		// Se for da categoria RuntimeException, n�o h� obrigatoriedade do tratamento
	}

	public void setNotas(double _nota1, double _nota2) throws Exception {
		this.setNotas(_nota1, _nota2, 0);
	}

	// sobrecarregamento do c�lculo da m�dia para limitar o valor m�ximo
	private double calculaMedia() {
		this.media = (this.getNota1() + this.getNota2() + this.getPontos())/2;
		if(ultrapassouLimite(this.media))
			this.media = limite_nota;
		return this.media;
	}

	//Metodo que verifica se a nota ultrapassou o limite maximo de nota, deve ser estatico 
	// ja que teremos que comparar varias notas diferentes
	private static boolean ultrapassouLimite(double _nota) {
		if(_nota > limite_nota) {
			return true;
		}
		
		return false;
	}
		
	// n�o � adequado que o m�todo toString exiba mensagens, pois
	// � comum considerar que o programador de classes n�o conhece o usu�rio final
	// Evita-se tamb�m textos retornados, escritos em uma determinada l�ngua. 
	public String toString(){
		return this.getNome()+";"
				+this.getNota1()+";"
				+this.getNota2()+";"
				+this.getPontos()+";"
				+this.getMedia();
	}

}
