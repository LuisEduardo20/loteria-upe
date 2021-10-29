package br.com.upe;

import br.com.upe.ResultadoLoteria;

public class App {
    public static void main(String[] args) {

        // Resultado Mega Sena
        ResultadoLoteria resultadoMegaSena = new ResultadoLoteria("mega-sena");
        String resultado = resultadoMegaSena.obtemUltimoResultado();
        System.out.println("Mega sena:" + resultado);

        // Resultado Time mania
        ResultadoLoteria resultadoTimemania = new ResultadoLoteria("timemania");
        String resultado3 = resultadoTimemania.obtemUltimoResultado();
        System.out.println("Timemania:" + resultado3);

        // Resultado Quina
        ResultadoLoteria resultadoQuina = new ResultadoLoteria("quina");
        String resultado2 = resultadoQuina.obtemUltimoResultado();
        System.out.println("Quina:" + resultado2);
    }
}