package com.barbsmfe.controller;

import com.barbsmfe.domain.Chave;
import com.barbsmfe.domain.IndiceDeCoincidencia;

public class Main {

	public static void main(String[] args) {
		String palavra = "plsualtlroaocrqcocauiseremmoiranstoiozaendroabiormrcaaocsnenidtliuannvduepranretqeeusscepxtexraexemxotssiedt";
		IndiceDeCoincidencia ic = new IndiceDeCoincidencia();
		ic.encontrarIndiceDeCoincidencia(palavra);

		Chave chave = new Chave(palavra);
		chave.separarString();		                       
	}

}
