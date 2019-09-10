package com.barbsmfe.domain;

import java.util.HashMap;
import java.util.Map;

public class IndiceDeCoincidencia {

	private Map<Character, Double> indiceDeCoincidenciaDasLetras;

	public double encontrarIndiceDeCoincidencia(String textoCriptografado) {
		inicializarindiceDeCoincidenciaDasLetras();
		verificarFrequenciaDeLetrasDoTexto(textoCriptografado);

		double divisor = textoCriptografado.length() * (textoCriptografado.length() - 1);

		verificarIndiceDeCoincidenciaDasLetrasDoTexto();

		return verificarIndiceDeCoincidenciaDoTexto(divisor);
	}

	private double verificarIndiceDeCoincidenciaDoTexto(double divisor) {
		return (indiceDeCoincidenciaDasLetras.values().stream().mapToDouble(Double::valueOf).sum()) / divisor;
	}

	private void verificarIndiceDeCoincidenciaDasLetrasDoTexto() {
		indiceDeCoincidenciaDasLetras.forEach((k, v) -> {
			indiceDeCoincidenciaDasLetras.put(k, v * (v - 1));
		});
	}
	
	public Map<Character, Double> verificarFrequenciaDeLetrasDoTexto(String textoCriptografado) {
		Map<Character, Double> frequenciaLetras = new HashMap<Character, Double>();
		for (int i = 0; i < textoCriptografado.length(); i++) {
			indiceDeCoincidenciaDasLetras.put(textoCriptografado.charAt(i),
					indiceDeCoincidenciaDasLetras.get(textoCriptografado.charAt(i)) + 1);
		}		
		frequenciaLetras = indiceDeCoincidenciaDasLetras;
		return frequenciaLetras;
	}

	public void inicializarindiceDeCoincidenciaDasLetras() {
		indiceDeCoincidenciaDasLetras = new HashMap<Character, Double>();
		indiceDeCoincidenciaDasLetras.put('a', 0.0);
		indiceDeCoincidenciaDasLetras.put('b', 0.0);
		indiceDeCoincidenciaDasLetras.put('c', 0.0);
		indiceDeCoincidenciaDasLetras.put('d', 0.0);
		indiceDeCoincidenciaDasLetras.put('e', 0.0);
		indiceDeCoincidenciaDasLetras.put('f', 0.0);
		indiceDeCoincidenciaDasLetras.put('g', 0.0);
		indiceDeCoincidenciaDasLetras.put('h', 0.0);
		indiceDeCoincidenciaDasLetras.put('i', 0.0);
		indiceDeCoincidenciaDasLetras.put('j', 0.0);
		indiceDeCoincidenciaDasLetras.put('k', 0.0);
		indiceDeCoincidenciaDasLetras.put('l', 0.0);
		indiceDeCoincidenciaDasLetras.put('m', 0.0);
		indiceDeCoincidenciaDasLetras.put('n', 0.0);
		indiceDeCoincidenciaDasLetras.put('o', 0.0);
		indiceDeCoincidenciaDasLetras.put('p', 0.0);
		indiceDeCoincidenciaDasLetras.put('q', 0.0);
		indiceDeCoincidenciaDasLetras.put('r', 0.0);
		indiceDeCoincidenciaDasLetras.put('s', 0.0);
		indiceDeCoincidenciaDasLetras.put('t', 0.0);
		indiceDeCoincidenciaDasLetras.put('u', 0.0);
		indiceDeCoincidenciaDasLetras.put('v', 0.0);
		indiceDeCoincidenciaDasLetras.put('w', 0.0);
		indiceDeCoincidenciaDasLetras.put('x', 0.0);
		indiceDeCoincidenciaDasLetras.put('y', 0.0);
		indiceDeCoincidenciaDasLetras.put('z', 0.0);
	}
}
