
public interface ObjetoTridimensional {
	/**
   	 * O método centro retorna o ponto em tres dimensões que corresponde ao centro
   	 * do objeto geométrico.
   	 * @return uma instância da classe Ponto3D representando o centro do objeto
   	 *     	geométrico.
   	 */
   	Ponto3D centro();
 
   	/**
   	 * O método calculaVolume calcula o volume do objeto geométrico e retorna o volume
   	 * como um valor do tipo double.
   	 * @return o volume deste objeto geométrico.
   	 */
   	double calculaVolume();
 
   	/**
   	 * O método calculaSuperficie calcula a superficie do objeto geométrico e retorna a
   	 * superficie como um valor do tipo double.
   	 * @return a superficie deste objeto geométrico.
   	 */
   	double calculaSuperficie();
}
