package br.com.upe;

import br.com.upe.ResultadoMegasena;

public class App {
    public static void main(String[] args) {

        // Resultado Mega Sena
        ResultadoMegasena resultadoMegaSena = new ResultadoMegasena("mega-sena");
        String resultado = resultadoMegaSena.obtemUltimoResultado();
        System.out.println("Mega sena:" + resultado);

        // Resultado Time mania
        ResultadoMegasena resultadoTimemania = new ResultadoMegasena("timemania");
        String resultado3 = resultadoTimemania.obtemUltimoResultado();
        System.out.println("Timemania:" + resultado3);

        // Resultado Quina
        ResultadoMegasena resultadoQuina = new ResultadoMegasena("quina");
        String resultado2 = resultadoQuina.obtemUltimoResultado();
        System.out.println("Quina:" + resultado2);
    }
}