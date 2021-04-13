package com.example.sincronizacaoreceita;

public class ProcessarCSV implements ProcessarArquivo {

	public void processar(String filePath) {
		 ReceitaService receitaService = new ReceitaService();
	     try {
			receitaService.atualizarConta("0101", "123456", 100.50, "A");
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}
