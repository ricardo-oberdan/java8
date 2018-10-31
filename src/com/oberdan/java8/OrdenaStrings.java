package com.oberdan.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrdenaStrings {

	public static void main(String[] args) {
		List<String> lista = new ArrayList<>();
		lista.add("primeira string");
		lista.add("segunda string");
		lista.add("deve ser a primeira");
		
		Collections.sort(lista);
		System.out.println(lista);
		
		Comparator<String> comparador = new ComparadorPorTamanho();
		Collections.sort(lista, comparador);
		System.out.println(lista);

		Collections.sort(lista);

		System.out.println("Usando a nova API do Java 8");
		lista.sort(comparador);
		System.out.println(lista);
	}

}

class ComparadorPorTamanho implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		if (s1.length() < s2.length()) 
			return -1;

		if (s1.length() > s2.length()) 
			return 1;

		return 0;
	}
	
}