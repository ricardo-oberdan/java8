package com.oberdan.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class UsandoLambdas {

	public static void main(String[] args) {
		List<String> listaPalavras = new ArrayList<>();
		listaPalavras.add("primeira string");
		listaPalavras.add("segunda string");
		listaPalavras.add("deve ser a primeira");

		Collections.sort(listaPalavras);

		// Usando classes anônimas
		Comparator<String> comparador = new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				if (s1.length() < s2.length())
					return -1;

				if (s1.length() > s2.length())
					return 1;

				return 0;
			}
		};

		Collections.sort(listaPalavras, comparador);

		for (String s : listaPalavras) {
			System.out.println(s);
		}
		System.out.println("Usando a nova API do Java 8");
		listaPalavras.sort(null);
		listaPalavras.sort(comparador);

		System.out.println("Usando classes anônimas, ja dentro do argumento");
		listaPalavras.forEach(new Consumer<String>() {
			@Override
			public void accept(String s) {
				System.out.println(s);
			}

		});

		System.out.println("Fazendo o mesmo com lambdas, ordenando naturalmente");
		listaPalavras.forEach(str -> System.out.println(str));
		listaPalavras.forEach(System.out::println);

		System.out.println("Fazendo o mesmo com lambdas, ordenando pelo tamanho da string");
		listaPalavras.sort((s1, s2) -> s1.length() - s2.length());
		listaPalavras.sort(Comparator.comparing(s -> s.length()));
		listaPalavras.sort(Comparator.comparing(String::length));
	}
}
