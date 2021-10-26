package br.com.upe;


public class App 
{
    public static void main( String[] args )
    {
        String resultado = ResultadoMegasena.obtemUltimoResultado("mega-sena");
//        for(String dezena: resultado) {
//        	System.out.print(dezena + " ");
//        }
        System.out.print("mega sena:" + resultado);
    }
}


