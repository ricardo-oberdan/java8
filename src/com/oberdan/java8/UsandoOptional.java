package com.oberdan.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class UsandoOptional {

	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("Lua", 7));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		cursos.add(new Curso("Go", 5));

		Optional<Curso> optionalCurso = cursos.stream().filter(c -> c.getAlunos() >= 1000).findAny();
		
		//Curso curso;
		
		//Pega o curso, se não existir dá exceção NoSuchElementException
		//curso = optionalCurso.get();
		
		//Pego o curso, se não tiver nenhum devolve null
		//curso = optionalCurso.orElse(null);
		//O que resultará em NullPointerException
		//System.out.println(curso.getNome());
		
		//Não retorna exceção, ou devolve o que existe
		optionalCurso.ifPresent(c -> System.out.println(c.getNome()));

		cursos.stream()
			.filter(c -> c.getAlunos() >= 1000)
			.findAny()
			.ifPresent(c -> System.out.println(c.getNome()));
		
		
		//O stream não altera a lista original, ela devolve um objeto Stream
		//Mas posso querer filtrar minha lista e armazená-la numa nova lista
		List<Curso> resultado = cursos.stream()
									.filter(c -> c.getAlunos() >= 50)
									.collect(Collectors.toList());

		//ou na mesma lista
		cursos = cursos.stream()
					.filter(c -> c.getAlunos() >= 50)
					.collect(Collectors.toList());

		//Estou criando um Map, onde a chave é o nome do curso e valor é o próprio curso
		Map<String, Curso> mapa = cursos.stream()
			.collect(Collectors.toMap(c -> c.getNome(), c -> c));
		
		System.out.println(mapa);
	}
}
