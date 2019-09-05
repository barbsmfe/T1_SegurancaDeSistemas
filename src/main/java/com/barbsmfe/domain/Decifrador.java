package com.barbsmfe.domain;

import java.util.List;

public class Decifrador {
	
	private int tamanhoChave;
	private Chave chave;
	private IndiceDeCoincidencia ic;
	private String palavra;
	
	//fazer método que lê arquivo
	
	public Decifrador(String palavraCriptografada) {
		palavra = palavraCriptografada;
		chave = new Chave(palavraCriptografada);
		ic = new IndiceDeCoincidencia();
	}
	
	public void fazACoisa() {
		List<String> coisa = chave.organizarTextoCriptografado(7);
		System.out.println(coisa);
	}

}
