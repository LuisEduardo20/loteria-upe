package br.com.upe;

import br.com.upe.ResultadoMegasena;

public class App 
{
    public static void main( String[] args )
    {
    	// Resultado Mega Sena
    	ResultadoMegasena resultadoMegaSena = new ResultadoMegasena("mega-sena");
        String resultado = resultadoMegaSena.obtemUltimoResultado();
        System.out.println("mega sena:" + resultado);
        
        // Resultado Quina
        ResultadoMegasena resultadoQuina = new ResultadoMegasena("quina");
        String resultado2 = resultadoQuina.obtemUltimoResultado();
        System.out.println("quina: " + resultado2);
        
        // Resultado Time mania
        ResultadoMegasena resultadoTimemania = new ResultadoMegasena("timemania");
        String resultado3 = resultadoTimemania.obtemUltimoResultado();
        System.out.println("timemania: " + resultado3);
    }
}