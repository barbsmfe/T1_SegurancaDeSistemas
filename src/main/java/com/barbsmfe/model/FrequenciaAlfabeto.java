package com.barbsmfe.model;

import java.util.Map;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class FrequenciaAlfabeto {

	private Map<Character, Double> frequenciaLetrasPtBr;
	private boolean portugues = false;

	public FrequenciaAlfabeto(boolean portugues) {
		frequenciaLetrasPtBr = new HashMap<Character, Double>();
		this.portugues = portugues;
		leitorDeArquivoFrequencia();
	}

	public void leitorDeArquivoFrequencia() {
		String line = "";
		String nomeArquivo = "";
		String[] linhaDividida;
		
		if (portugues)
			nomeArquivo = "frequenciaPtBr.txt";
		else
			nomeArquivo = "frequenciaIngles.txt";
		
		try {
			FileReader fileReader = new FileReader(nomeArquivo);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				linhaDividida = line.split("-");
				frequenciaLetrasPtBr.put(linhaDividida[0].charAt(0), Double.parseDouble(linhaDividida[1]));
			}
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Não foi possível encontrar o arquivo:  '" + nomeArquivo + "'");
		} catch (IOException ex) {
			System.out.println("Erro ao ler o arquivo: '" + nomeArquivo + "'");
		}
	}

	public void setPortugues(boolean portugues) {
		this.portugues = portugues;
	}

	public Map<Character, Double> getFrequenciaLetras() {
		frequenciaLetrasPtBr.entrySet().stream().sorted(Map.Entry.<Character, Double>comparingByValue().reversed())
				.forEachOrdered(x -> frequenciaLetrasPtBr.put(x.getKey(), x.getValue()));
		return frequenciaLetrasPtBr;
	}
}
