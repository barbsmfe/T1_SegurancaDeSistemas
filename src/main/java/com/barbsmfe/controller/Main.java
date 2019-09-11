package com.barbsmfe.controller;

import com.barbsmfe.domain.Decifrador;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Digite o nome do arquivo que contém o texto cripografado: ");
		String nomeArquivo = teclado.nextLine();

		Decifrador d = new Decifrador(nomeArquivo);
		d.decodificarTexto();
		
		System.out.println("A chave encontrada foi: " + d.getChaveEncontrada());
		System.out.println("O texto decriptografado é: " + d.getTextoDecodificado());
	}
}
