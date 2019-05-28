package exercicio23;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Uso23 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		TreeSet<String> wordTree = new TreeSet<String>();
		HashMap<String, Integer> wordHash = new HashMap<String, Integer>();
		LinkedList<String> wordList = new LinkedList<String>();
		TreeSet<Integer> intTree = new TreeSet<Integer>();
		TreeMap<String, Integer> wordTreeMap = new TreeMap<String, Integer>();
		String texto;
		String[] textoArray;
		 
		System.out.print("Digite um Texto:");
		texto = input.nextLine();
		
		input.close();
		
		textoArray = texto.split(" ");
		System.out.println(texto);
		
		for(int i = 0; i < textoArray.length; i++) {
			//Letra A
			wordTree.add(textoArray[i]);
			//Letra B
			if(!wordHash.containsKey(textoArray[i]))
				wordHash.put(textoArray[i], 1);
			else
				wordHash.put(textoArray[i], wordHash.get(textoArray[i]) + 1);
			
			wordList.add(textoArray[i]);
			
			//Letra E
			if(!wordTreeMap.containsKey(textoArray[i]))
				wordTreeMap.put(textoArray[i], 1);
			else
				wordTreeMap.put(textoArray[i], wordTreeMap.get(textoArray[i]) + 1);
		}
		
		while(intTree.toArray().length < 20) {
			intTree.add((int) (Math.random() * 50) + 1);
		}
		
		
		//Letra A
		System.out.println("Letra A: "+wordTree.toString());
		
		//Letra B
		System.out.println("Letra B: "+wordHash.toString());
		
		//Letra C
		Collections.shuffle(wordList);
		System.out.println("Letra C: " + wordList.toString());
		
		//Letra D
		System.out.println("Letra D: "+intTree.toString());
		
		//Letra E
		System.out.println("Letra E: "+wordTreeMap.toString());
				
	}

}
