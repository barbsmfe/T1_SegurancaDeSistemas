package com.barbsmfe.domain;


import com.barbsmfe.model.FrequenciaAlfabeto;

public class Decifrador {
	
	private Chave chave;
	private String textoCriptografado;
	
	//fazer mÃ©todo que lÃª arquivo
	public void leitorDeArquivo() {
		
	}
	
	public Decifrador(String palavraCriptografada) {
		chave = new Chave(palavraCriptografada);
	}
	
	public void fazACoisa() {
		
		System.out.println(chave.encontrarChave());
		
	}
	
	public void decodificarTexto() {
		
	}
	
}