package br.com.upe;

import java.util.Arrays;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

public class ResultadoMegasena {
	
	private static String nomeSorteio;
	
	public ResultadoMegasena(String nomeSorteio) {
		this.nomeSorteio = nomeSorteio;
	}
	
	private final static String URL = "http://loterias.caixa.gov.br/wps/portal/loterias/landing/";
	private final static String MARCA_INICIAL_RETORNO_NAO_UTIL = "<ul class=\"resultado-loteria " + nomeSorteio + "\">";
	private final static String MARCA_FINAL_RETORNO_NAO_UTIL = "</ul>";
//	private final static String MARCA_INICIAL_RETORNO_NAO_UTIL = "<div class=\"resultado-loteria\">";
//	private final static String MARCA_FINAL_RETORNO_NAO_UTIL = "</div>";
	
	public static String obtemUltimoResultado(String nome) {
		HttpClient httpclient = new DefaultHttpClient();
		
		try {
//			System.out.println("Testando");
			HttpGet httpget = new HttpGet(URL);
//			System.out.println("HTTPGET: " + httpget);
			
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
//			System.out.println("responseHandler: " + responseHandler);
			
			String html = httpclient.execute(httpget, responseHandler);
//			System.out.println("html: " + html);
			
			return obterDezenas(html);
		}
		catch(Exception e) {
			System.out.println(e);
			throw new RuntimeException("Um erro inesperado ocorreu.", e);
		}
		finally {
			httpclient.getConnectionManager().shutdown();
		}
	}
	
	public static String obterDezenas(String html) {
//		Integer parteInicial = html.indexOf(MARCA_INICIAL_RETORNO_NAO_UTIL) + MARCA_INICIAL_RETORNO_NAO_UTIL.length();
		Integer parteInicial = html.indexOf(MARCA_INICIAL_RETORNO_NAO_UTIL);
//		System.out.println("parteInicial: " + parteInicial);
		
		Integer parteFinal = html.indexOf(MARCA_FINAL_RETORNO_NAO_UTIL, parteInicial);
//		System.out.println("parteFinal: " + parteFinal);
		
		String extracao = html.substring(parteInicial, parteFinal).replaceAll(" ", "");
//		System.out.println("extracao: " + extracao);
		
		String[] numeros = extracao.split("-");
//		System.out.println("numeros: " + Arrays.toString(numeros));
		
		String numerosFormatados = numeros[1].replaceAll("[^0-9]", " ");
//		System.out.println(numerosFormatados);
		
		return numerosFormatados;
	}
}
