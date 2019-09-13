package com.barbsmfe.controller;

import com.barbsmfe.domain.Decifrador;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		boolean portugues = false;

		System.out.println("Digite o nome do arquivo que contém o texto cripografado: ");
		String nomeArquivo = teclado.nextLine();
		System.out.println("O texto está em português?");
		System.out.println("1 - Sim");
		System.out.println("2 - Não");
		int opcao = teclado.nextInt();
		if (opcao == 1)
			portugues = true;
		else if (opcao == 2)
			portugues = false;

		Decifrador d = new Decifrador(nomeArquivo, portugues);
		d.decodificarTexto();

		System.out.println("A chave encontrada foi: " + d.getChaveEncontrada());
		System.out.println("O texto decriptografado é: " + d.getTextoDecodificado());
	}
}
