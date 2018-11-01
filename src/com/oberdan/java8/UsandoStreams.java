package com.oberdan.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UsandoStreams {

	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("Lua", 7));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		cursos.add(new Curso("Go", 5));

		//Exemplos de sort usando os lambdas
		cursos.sort(Comparator.comparing(c -> c.getNome()));
		cursos.sort(Comparator.comparing(Curso::getNome));
		cursos.forEach(c -> System.out.println(c.getNome()));
		cursos.sort(Comparator.comparingInt(Curso::getAlunos));
		cursos.forEach(c -> System.out.println(c.getNome()));
		System.out.println("================");

		//Usando streams

		//No exemplo abaixo, vou pegar os cursos que tenham mais de 100 alunos
		//Iterar neles para imprimir o nome do curso
		//Esse stream não impacta na coleção original. A lista continua a mesma.
		cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.forEach(c -> System.out.println(c.getNome()));

		//No exemplo abaixo, vou pegar os cursos que tenham menos de 10 alunos
		//Iterar neles para imprimir a quantidade de alunos
		cursos.stream()
			.filter(c -> c.getAlunos() < 10)
			.map(Curso::getAlunos)
			.forEach(System.out::println);

		//No exemplo abaixo, vou pegar somar o total de alunos da coleção, cujo nome do curso comece com J
		int soma = cursos.stream()
					.filter(c -> c.getNome().startsWith("J"))
					.mapToInt(Curso::getAlunos)
					.sum();
		System.out.println("Total de Alunos de cursos que começam com J: " + soma);
	}
}
