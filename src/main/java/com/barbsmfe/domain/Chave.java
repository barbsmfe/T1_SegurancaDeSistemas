package com.barbsmfe.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Chave {
	
	private static final int MAX_TAMANHO = 10;
	private Map<Integer, Double> tamanhoChavePorIc;
	private String textoCriptografado;
	private int divisor;
	
	public Chave(String textoCriptografado) {
		this.textoCriptografado = textoCriptografado;
		//dividir o texto criptografado por vários números, isso vai te dar várias mini palavras
		//faz o bagulho do índice de coincidência com cada uma, a maior vai ser o número da chave
	}
	
	
	private void encontrarTamanhoChave(String textoCriptografado) {		
		
	}
	

}
