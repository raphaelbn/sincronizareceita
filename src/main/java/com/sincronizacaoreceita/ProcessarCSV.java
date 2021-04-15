package com.sincronizacaoreceita;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProcessarCSV implements ProcessarArquivo {

	public void processar(String filePath) {
		try {
			List<String[]> lines = Files.lines(Paths.get(filePath)).map(line -> line.concat(";resultado").split(";"))
					.collect(Collectors.toList());

			List<String> collect = lines.stream().map(line -> {
				if (!line[0].equals("agencia")) {
					boolean resultado = atualizarConta(line[0], line[1], line[2], line[3]);
					return new String[] { line[0], line[1], line[2], line[3], Boolean.toString(resultado) };
				}
				return line;
			}).map(line -> Stream.of(line).collect(Collectors.joining(";"))).collect(Collectors.toList());

			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String fileName = "sincronizareceita-resultado-".concat(timeStamp).concat(".csv");
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(fileName)))) {
				for (String line : collect) {
					bw.write(line);
					bw.newLine();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean atualizarConta(String agencia, String conta, String saldo, String status) {
		ReceitaService receitaService = new ReceitaService();
		conta = conta.replace("-", "");
		double saldoDb = Double.parseDouble(saldo.replace(",", "."));
		try {
			return receitaService.atualizarConta(agencia, conta, saldoDb, status);
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return false;
	}
}
