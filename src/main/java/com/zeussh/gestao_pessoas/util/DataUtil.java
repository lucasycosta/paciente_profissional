package com.zeussh.gestao_pessoas.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DataUtil {

	private static final String formatDataHora = "dd/MM/yyyy HH:mm";
	private static final String formatDataHoraSeg = "dd/MM/yyyy HH:mm:ss";
	private static final String formatDataHoraTraco = "dd-MM-yyyy HH:mm:ss";
	private static final String dataHoraInvertida = "yyyyMMddHHmmss";
	private static final String formatData = "dd/MM/yyyy";

	private static final String ano = "yyyy";
	private static final String mes = "MM";
	private static final String dia = "dd";

	public static Date getDataHora(String dataHora) {
		try {
			return new SimpleDateFormat(formatDataHora).parse(dataHora);
		} catch (ParseException e) {
			log.error(e.getMessage());
		}
		return null;
	}
	
	
	public static Date getDataHoraSeg(String dataHora) {
		try {
			return new SimpleDateFormat(formatDataHoraSeg).parse(dataHora);
		} catch (ParseException e) {
			log.error(e.getMessage());
		}
		return null;
	}

	public static Date getDataHoraRest(String dataHora) {
		try {
			return new SimpleDateFormat(formatDataHoraTraco).parse(dataHora);
		} catch (ParseException e) {
			log.error(e.getMessage());
		}
		return null;
	}

	public static Date getData(String data) {
		try {
			return new SimpleDateFormat(formatData).parse(data);
		} catch (ParseException e) {
			log.error(e.getMessage());
		}
		return null;
	}

	public static String getDataHora(Date dataHora) {
		return new SimpleDateFormat(formatDataHora).format(dataHora);
	}

	public static String getData(Date data) {
		return new SimpleDateFormat(formatData).format(data);
	}
	
	public static String converterSegundosEmHoras(Integer segundo) {
		long seconds = Math.round(segundo);
		LocalTime timeOfDay = LocalTime.ofSecondOfDay(seconds);
		return timeOfDay.toString();
	}

	public static String gerarNome(String nomeUsuario) {
		return dataHoraInvertida(new Date()) + "-" + nomeUsuario.replaceAll("\\s+","");
	}

	public static Date getDataTime(Long data) {
		return new Date(data * 1000);
	}

	private static String dataHoraInvertida(Date data) {
		return new SimpleDateFormat(dataHoraInvertida).format(data);
	}

	public static Integer quantidadeDias(Date data) {
		Date hoje = new Date();
		LocalDate begin = LocalDate.of(Integer.parseInt(new SimpleDateFormat(ano).format(data)),
				Integer.parseInt(new SimpleDateFormat(mes).format(data)),
				Integer.parseInt(new SimpleDateFormat(dia).format(data)));
		LocalDate end = LocalDate.of(Integer.parseInt(new SimpleDateFormat(ano).format(hoje)),
				Integer.parseInt(new SimpleDateFormat(mes).format(hoje)),
				Integer.parseInt(new SimpleDateFormat(dia).format(hoje)));
		long days = ChronoUnit.DAYS.between(begin, end);
		return (int) days;
	}
	
	public static Date capturarDataDia(Boolean menos, Integer quantidade) {
		Calendar dataAtual = Calendar.getInstance();
		if (menos) {
			dataAtual.add(Calendar.DAY_OF_WEEK, - quantidade);	
		} else {
			dataAtual.add(Calendar.DAY_OF_WEEK, + quantidade);
		}
		
		return dataAtual.getTime();
	}
	
	public static Date capturarDataMes(Integer quantidade) {
		Calendar dataAtual = Calendar.getInstance();
		dataAtual.add(Calendar.MONTH, - quantidade);
		return dataAtual.getTime();
	}

}
