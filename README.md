# T1 - Segurança De Sistemas

## Objetivo

O objetivo do trabalho é decodificar o texto recebido que está criptografado com a cifra de Vigenère, para isso foram feitas as seguintes etapas:

1. Foi descoberto o tamanho da chave com o índice de coincidência.
2. O texto foi organizado em colunas, cada coluna foi codificada utilizando uma das letras da chave.
3. Utilizando o tamanho da chave, foi feito o cálculo do qui-quadrado (chiSquare) para descobrir a letra que codificou cada coluna do texto.
4. Após descoberta a chave, foi possível decodificar o texto fazendo o caminho inverso da normal codificação de Vigenère. 

## Execução

### IDE

Basta entrar onde está a classe main e executar o programa, quando pedido o nome do arquivo texto, digitar:

        textoCriptografado.txt


O programa irá perguntar se o texto está em português ou não, no caso desde texto, ele está em português, basta digitar 1, se o caso teste usado estiver em inglês, basta digitar 2.

Agora é só apertar a tecla Enter e ver o resultado exibido em tela.

### Terminal

Para executar através do terminal basta entrar na pasta do projeto e usar o comando:

        gradle build

Isso irá gerar um arquivo .jar na pasta ./build/libs/, para executar esse arquivo é preciso ter certeza de que o arquivo com o texto criptografado esteja junto deste .jar, então mova o arquivo textoCriptografado.txt para ./build/libs/, uma vez feito isso, entre nessa pasta e digite o comando: 

        java -jar T1_SegurancaSistemas.jar

Quando pedido o arquivo, digitar:

        textoCriptografado.txt

O programa irá perguntar se o texto está em português ou não, no caso desde texto, ele está em português, basta digitar 1, se o caso teste usado estiver em inglês, basta digitar 2.

Agora é só apertar a tecla Enter e ver o resultado exibido em tela.
 
