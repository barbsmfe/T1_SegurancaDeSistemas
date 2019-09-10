package com.barbsmfe.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.barbsmfe.model.FrequenciaAlfabeto;

public class Chave {

	private static final int TAMANHO_MAXIMO_CHAVE = 10;
	private static final String ALFABETO = "abcdefghijklmnopqrstuvwxyz";
	private Map<Integer, Double> tamanhoChavePorIc;
	private List<String> strings;
	private IndiceDeCoincidencia ic;
	private FrequenciaAlfabeto fa;
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
		fa = new FrequenciaAlfabeto();
	}

	public String encontrarChave() {
		List<String> colunasOrganizadas = organizarTextoCriptografado(encontrarTamanhoChave());
		Map<Character, Double> frequenciaAlfabetoPtBr = fa.getFrequenciaLetrasPtBr();
		Map<Character, Double> frequenciaLetras = new HashMap<Character, Double>();

		String chave = "";
		for (String palavraCriptografada : colunasOrganizadas) {
			ic.inicializarindiceDeCoincidenciaDasLetras();
			frequenciaLetras = ic.verificarFrequenciaDeLetrasDoTexto(palavraCriptografada);
			chave = chave + chiSquare(frequenciaAlfabetoPtBr, frequenciaLetras, palavraCriptografada);
		}
		return chave;
	}

	private List<String> organizarTextoCriptografado(int tamanhoChave) {
		strings.clear();
		int index = 0;
		while (index < textoCriptografado.length()) {
			strings.add(
					textoCriptografado.substring(index, Math.min(index + tamanhoChave, textoCriptografado.length())));
			index += tamanhoChave;
		}
		return organizarColunas(strings);
	}

	private int encontrarTamanhoChave() {
		int tamanhoChave = 0;
		for (int i = 1; i <= TAMANHO_MAXIMO_CHAVE; i++) {
			tamanhoChave = encontrarTamanhoChave(organizarTextoCriptografado(i), i);
			strings.clear();
		}
		return tamanhoChave;
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

	private int encontrarTamanhoChave(List<String> palavras, int index) {
		double[] icPalavras = { 0 };
		palavras.forEach(palavra -> {
			icPalavras[0] += ic.encontrarIndiceDeCoincidencia(palavra);
		});
		tamanhoChavePorIc.put(index, icPalavras[0] / index);
		return tamanhoChavePorIc.entrySet().stream()
				.max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
	}

	private Character chiSquare(Map<Character, Double> frequenciaAlfabetoPtBr, Map<Character, Double> frequenciaLetras,
			String palavraCriptografada) {
		Map<Character, Double> chiSquare = new HashMap<Character, Double>();
		for (int i = 0; i < ALFABETO.length(); i++) {
			double chiSquared = 0;
			for (char letra : frequenciaAlfabetoPtBr.keySet()) {
				int novoIndex = ALFABETO.indexOf(letra) + i;
				if (novoIndex > 25) {
					novoIndex = novoIndex - 26;
				}

				if (frequenciaLetras.containsKey(ALFABETO.charAt(novoIndex))) {
					double frequenciaDaLetra = frequenciaLetras.get(ALFABETO.charAt(novoIndex));
					double frequenciaMultiplicada = frequenciaAlfabetoPtBr.get(letra) * palavraCriptografada.length();
					chiSquared += Math.pow((frequenciaDaLetra - frequenciaMultiplicada), 2) / frequenciaMultiplicada;
				}
			}
			chiSquare.put(ALFABETO.charAt(i), chiSquared);
		}
		return chiSquare.entrySet().stream().min((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1)
				.get().getKey();
	}
}
