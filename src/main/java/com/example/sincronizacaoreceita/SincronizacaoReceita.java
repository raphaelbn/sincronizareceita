package com.example.sincronizacaoreceita;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SincronizacaoReceita implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SincronizacaoReceita.class, args);     
	}

	@Bean
	public ProcessarArquivo getProcessadorCSV(){
		return new ProcessarCSV();
	}

	@Override
	public void run(String... args) throws Exception {
		if (args.length == 0) throw new Exception("Necessário passar o caminho para do arquivo como parametro!");
		if (args.length > 1) throw new Exception("Apenas um arquivo pode ser processado por vez!");
		getProcessadorCSV().processar(args[0]);
	}
}
