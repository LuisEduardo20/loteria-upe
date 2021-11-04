package br.com.upe;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void verificarDezenaMegasena() {

        ResultadoLoteria resultadoMegaSena = new ResultadoLoteria("mega-sena");
        String resultado = resultadoMegaSena.obtemUltimoResultado();

        assertEquals(12, resultado.length());
    }

    @Test
    public void verificarDezenaTimemania() {

        ResultadoLoteria resultadoTimemania = new ResultadoLoteria("timemania");
        String resultado = resultadoTimemania.obtemUltimoResultado();

        assertEquals(14, resultado.length());
    }

    @Test
    public void verificarDezenaQuina() {

        ResultadoLoteria resultadoQuina = new ResultadoLoteria("quina");

        String resultado = resultadoQuina.obtemUltimoResultado()
 	
		assertEquals(10, resultado.length());	
    }
}
