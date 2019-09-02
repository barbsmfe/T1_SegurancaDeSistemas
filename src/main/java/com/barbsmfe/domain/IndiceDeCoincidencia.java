package com.barbsmfe.domain;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class IndiceDeCoincidencia {

	private Map<Character, Double> indiceDeCoincidenciaDasLetras;
	private static DecimalFormat df = new DecimalFormat("#.#####");

	public IndiceDeCoincidencia() {
		inicializarindiceDeCoincidenciaDasLetras();
	}

	public void encontrarIndiceDeCoincidencia(String textoCriptografado) {
		textoCriptografado = textoCriptografado.replaceAll("\\s+", "");
		verificarFrequenciaDeLetrasDoTexto(textoCriptografado);

		double divisor = textoCriptografado.length()*(textoCriptografado.length()-1);
		
		verificarIndiceDeCoincidenciaDasLetrasDoTexto();
		double indiceDeCoincidencia = verificarIndiceDeCoincidenciaDoTexto(divisor);		
		
		System.out.println(indiceDeCoincidencia);
	}
	
	private double verificarIndiceDeCoincidenciaDoTexto(double divisor) {
		indiceDeCoincidenciaDasLetras.forEach((k,v) -> {
			indiceDeCoincidenciaDasLetras.put(k, Double.parseDouble((df.format(v/divisor)).replace(",", ".")));
		});		
		return indiceDeCoincidenciaDasLetras.values().stream().mapToDouble(Double::valueOf).sum();
	}
	
	private void verificarIndiceDeCoincidenciaDasLetrasDoTexto() {		
		indiceDeCoincidenciaDasLetras.forEach((k,v) -> {
			indiceDeCoincidenciaDasLetras.put(k, v*(v-1));
		});
		System.out.println(indiceDeCoincidenciaDasLetras);
	}

	private void verificarFrequenciaDeLetrasDoTexto(String textoCriptografado) {	
		for (int i = 0; i < textoCriptografado.length(); i++) {
			indiceDeCoincidenciaDasLetras.put(textoCriptografado.charAt(i),
					indiceDeCoincidenciaDasLetras.get(textoCriptografado.charAt(i)) + 1);
		}
		System.out.println(indiceDeCoincidenciaDasLetras);
	}

	private void inicializarindiceDeCoincidenciaDasLetras() {
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
