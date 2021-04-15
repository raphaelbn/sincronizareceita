package com.sincronizacaoreceita;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProcessarCSVTest {

	private ProcessarCSV processaCSV = new ProcessarCSV();

	@Test
	void testAtualizarContaStatusA() {
		assertEquals(true, processaCSV.atualizarConta("0101", "12225-6", "100,00", "A"));
	}

	@Test
	void testAtualizarContaStatusARetornaFalse() {
		assertEquals(false, processaCSV.atualizarConta("101", "12225-6", "100,00", "A"));
	}

	@Test
	void testAtualizarContaStatusB() {
		assertEquals(true, processaCSV.atualizarConta("3202", "00321-2", "34500,00", "B"));
	}

	@Test
	void testAtualizarContaStatusBRetornaFalse() {
		assertEquals(false, processaCSV.atualizarConta("32002", "00321-2", "34500,00", "B"));
	}

	@Test
	void testAtualizarContaStatusI() {
		assertEquals(true, processaCSV.atualizarConta("3202", "40011-1", "-35,12", "I"));
	}

	@Test
	void testAtualizarContaStatusIRetornaFalse() {
		ProcessarCSV processaCSV = new ProcessarCSV();
		assertEquals(false, processaCSV.atualizarConta("32c02", "40011-1", "-35,12", "I"));
	}

	@Test
	void testAtualizarContaStatusP() {
		assertEquals(true, processaCSV.atualizarConta("3202", "54001-2", "0,00", "P"));
	}

	@Test
	void testAtualizarContaStatusPRetornaFalse() {
		assertEquals(false, processaCSV.atualizarConta("322", "54001-2", "0,00", "P"));
	}
}
