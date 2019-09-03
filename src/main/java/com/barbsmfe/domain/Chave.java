package com.barbsmfe.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Chave {

	private static final int MAX_TAMANHO = 10;
	private Map<Integer, Double> tamanhoChavePorIc;
	private List<String> strings;
	private IndiceDeCoincidencia ic;
	private String textoCriptografado;
	private int divisor;

	public Chave(String textoCriptografado) {
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
		tamanhoChavePorIc.put(11, 0.0);
		tamanhoChavePorIc.put(12, 0.0);
		tamanhoChavePorIc.put(13, 0.0);
		tamanhoChavePorIc.put(14, 0.0);
		tamanhoChavePorIc.put(15, 0.0);
		tamanhoChavePorIc.put(16, 0.0);
		tamanhoChavePorIc.put(17, 0.0);
		tamanhoChavePorIc.put(18, 0.0);
		tamanhoChavePorIc.put(19, 0.0);
		tamanhoChavePorIc.put(20, 0.0);
		
		
		strings = new ArrayList<String>();
		ic = new IndiceDeCoincidencia();
		// dividir o texto criptografado por vários números, isso vai te dar várias mini
		// palavras
		// faz o bagulho do índice de coincidência com cada uma, a maior vai ser o
		// número da chave
	}

	public void separarString() {
		for (int i = 1; i <= 20; i++) {
			int tam = textoCriptografado.length()/i;			
			int index = 0;
			while (index < textoCriptografado.length()) {
				strings.add(textoCriptografado.substring(index, Math.min(index + tam, textoCriptografado.length())));
				index += tam;
			}
			encontrarTamanhoChave(strings, i);
			strings.clear();
		}
		System.out.println(tamanhoChavePorIc);
	}

	private void encontrarTamanhoChave(List<String> palavras, int index) {
		double[] icPalavras = {0};
		palavras.forEach(palavra -> {
			icPalavras[0] += ic.encontrarIndiceDeCoincidencia(palavra);			
		});
		tamanhoChavePorIc.put(index, icPalavras[0]/index);
	}

}
