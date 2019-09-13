package com.barbsmfe.domain;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Decifrador {

	private Chave chave;
	private String textoCriptografado;
	private String chaveEncontrada;
	private String textoDecodificado;
	private boolean portugues;

	public void leitorDeArquivo(String nomeArquivo) {
		String line = "";
		try {
			FileReader fileReader = new FileReader(nomeArquivo);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				textoCriptografado = textoCriptografado + line;
			}
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Não foi possível encontrar o arquivo:  '" + nomeArquivo + "'");
		} catch (IOException ex) {
			System.out.println("Erro ao ler o arquivo: '" + nomeArquivo + "'");
		}
	}

	public Decifrador(String palavraCriptografada, boolean portugues) {
		textoCriptografado = "";
		leitorDeArquivo(palavraCriptografada);
		chave = new Chave(textoCriptografado, portugues);
	}

	public void decodificarTexto() {
		chaveEncontrada = chave.encontrarChave();
		textoDecodificado = "";
		int j = 0;
		for (int i = 0; i < textoCriptografado.length(); i++) {
			if (j >= chaveEncontrada.length()) {
				j = 0;
			}
			int x = (textoCriptografado.charAt(i) - chaveEncontrada.charAt(j) + 26) % 26;
			textoDecodificado += chave.ALFABETO.charAt(x);
			j++;
		}
	}

	public String getChaveEncontrada() {
		return chaveEncontrada;
	}	
	
	public String getTextoDecodificado() {
		return textoDecodificado;
	}
}