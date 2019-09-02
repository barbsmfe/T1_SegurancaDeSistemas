package com.barbsmfe.model;

import java.util.Map;
import java.util.HashMap;

public class FrequenciaAlfabeto {

	private Map<Character, Double> frequenciaLetrasPtBr;

	public FrequenciaAlfabeto() {
		frequenciaLetrasPtBr = new HashMap<Character, Double>();
		frequenciaLetrasPtBr.put('a', 0.14634);
		frequenciaLetrasPtBr.put('b', 0.01043);
		frequenciaLetrasPtBr.put('c', 0.03882);
		frequenciaLetrasPtBr.put('d', 0.04992);
		frequenciaLetrasPtBr.put('e', 0.1257);
		frequenciaLetrasPtBr.put('f', 0.01023);
		frequenciaLetrasPtBr.put('g', 0.01303);
		frequenciaLetrasPtBr.put('h', 0.00781);
		frequenciaLetrasPtBr.put('i', 0.06186);
		frequenciaLetrasPtBr.put('j', 0.00397);
		frequenciaLetrasPtBr.put('k', 0.00015);
		frequenciaLetrasPtBr.put('l', 0.02779);
		frequenciaLetrasPtBr.put('m', 0.04738);
		frequenciaLetrasPtBr.put('n', 0.04446);
		frequenciaLetrasPtBr.put('o', 0.09735);
		frequenciaLetrasPtBr.put('p', 0.02523);
		frequenciaLetrasPtBr.put('q', 0.01204);
		frequenciaLetrasPtBr.put('r', 0.06530);
		frequenciaLetrasPtBr.put('s', 0.06805);
		frequenciaLetrasPtBr.put('t', 0.04336);
		frequenciaLetrasPtBr.put('u', 0.03639);
		frequenciaLetrasPtBr.put('v', 0.01575);
		frequenciaLetrasPtBr.put('w', 0.00037);
		frequenciaLetrasPtBr.put('x', 0.00253);
		frequenciaLetrasPtBr.put('y', 0.00006);
		frequenciaLetrasPtBr.put('z', 0.0047);
	}

	public Map<Character, Double> getFrequenciaLetrasPtBr() {
		frequenciaLetrasPtBr.entrySet().stream().sorted(Map.Entry.<Character, Double>comparingByValue().reversed())
				.forEachOrdered(x -> frequenciaLetrasPtBr.put(x.getKey(), x.getValue()));
		return frequenciaLetrasPtBr;
	}
}
