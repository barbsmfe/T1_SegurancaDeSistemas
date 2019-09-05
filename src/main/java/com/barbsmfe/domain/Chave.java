package com.barbsmfe.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Chave {

	private static final int TAMANHO_MAXIMO_CHAVE = 10;
	private Map<Integer, Double> tamanhoChavePorIc;
	private List<String> strings;
	private IndiceDeCoincidencia ic;
	private String textoCriptografado;

	public Chave(String textoCriptografado) {
		textoCriptografado = textoCriptografado.replaceAll("\\s+", "");
		textoCriptografado = textoCriptografado.toLowerCase();

		this.textoCriptografado = textoCriptografado;
		tamanhoChavePorIc = new HashMap<Integer, Double>();

		tamanhoChavePorIc.put(1, 0.0);
		tamanhoChavePorIc.put(2, 0.0);
		tamanhoChavePorIc.put(3, 0.0);
		tamanhoChavePorIc.put(4, 0.0);
		tamanhoChavePorIc.put(5, 0.0);
		tamanhoChavePorIc.put(6, 0.0);
		tamanhoChavePorIc.put(7, 0.0);
		tamanhoChavePorIc.put(8, 0.0);
		tamanhoChavePorIc.put(9, 0.0);
		tamanhoChavePorIc.put(10, 0.0);

		strings = new ArrayList<String>();
		ic = new IndiceDeCoincidencia();
	}

	public List<String> organizarTextoCriptografado(int tamanhoChave) {
		strings.clear();
		int index = 0;
		while (index < textoCriptografado.length()) {
			strings.add(
					textoCriptografado.substring(index, Math.min(index + tamanhoChave, textoCriptografado.length())));
			index += tamanhoChave;
		}
		System.out.println(strings);
		return organizarColunas(strings);
	}

	public void separarString() {
		for (int i = 1; i <= TAMANHO_MAXIMO_CHAVE; i++) {
			encontrarTamanhoChave(organizarTextoCriptografado(i), i);
			strings.clear();
		}
		//System.out.println(tamanhoChavePorIc);
	}

	private List<String> organizarColunas(List<String> palavras) {
		String[] colunasPalavras = new String[palavras.get(0).length()];
		Arrays.fill(colunasPalavras, "");

		palavras.forEach(palavra -> {
			for (int i = 0; i < palavra.length(); i++) {
				colunasPalavras[i] = colunasPalavras[i] + palavra.charAt(i);
			}
		});

		palavras.removeAll(palavras);
		for (int j = 0; j < colunasPalavras.length; j++) {
			palavras.add(colunasPalavras[j]);
		}
		return palavras;
	}

	private void encontrarTamanhoChave(List<String> palavras, int index) {
		double[] icPalavras = { 0 };
		palavras.forEach(palavra -> {
			icPalavras[0] += ic.encontrarIndiceDeCoincidencia(palavra);
		});
		tamanhoChavePorIc.put(index, icPalavras[0] / index);
	}
}
