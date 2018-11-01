package com.oberdan.java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class UsandoLocalDate {

	public static void main(String[] args) {
		//Criando a data de hoje
		LocalDate hoje = LocalDate.now();
		System.out.println(hoje);
		
		String dataFormatada = hoje.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println(dataFormatada);
		
		LocalDate meuAniversario = LocalDate.of(1978, Month.APRIL, 3);
		
		int anos = hoje.getYear() - meuAniversario.getYear();
		System.out.println(anos);
		
		Period periodo = Period.between(meuAniversario, hoje);
		System.out.println(periodo);
		
		//Toda API de data é imutável, ou seja, sempre devolve um novo Objeto
		LocalDate daquiAPouco = hoje.plusYears(2).plusDays(6);
		System.out.println(daquiAPouco);
		
		LocalDateTime agora = LocalDateTime.now();
		System.out.println(agora);
		System.out.println(agora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")));
		
		hoje = agora.toLocalDate();
		
		YearMonth anoMes = YearMonth.of(2018, Month.FEBRUARY);
		LocalTime intervalo = LocalTime.of(13, 30);
	}

}
