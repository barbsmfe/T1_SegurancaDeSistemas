package T1_SegurancaSistemas;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.barbsmfe.domain.Decifrador;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class DecifradorTest {
	
	private Decifrador decifrador;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

	@Before
	public void setUp() {
	    System.setOut(new PrintStream(outContent));
	}

	@After
	public void restoreStream() {
	    System.setOut(originalOut);
	}
	
	@Test
	public void testarFileNotFoundExceptionDuranteLeituraDeTexto() {
		decifrador = new Decifrador("buuuuuga.txt");
		assertEquals("Não foi possível encontrar o arquivo:  'buuuuuga.txt'\n", outContent.toString());
	}
	
	@Test
	public void testarSeValorDeCHaveEncontradoEstaCorreto() {
		decifrador = new Decifrador("textoCriptografado.txt");
		decifrador.decodificarTexto();
		assertEquals(7, decifrador.getChaveEncontrada().length());
	}
	
	@Test
	public void testarSeAChaveEncontradaEstaCorreta() {
		decifrador = new Decifrador("textoCriptografado.txt");
		decifrador.decodificarTexto();
		assertEquals("avelino", decifrador.getChaveEncontrada());
	}
}
