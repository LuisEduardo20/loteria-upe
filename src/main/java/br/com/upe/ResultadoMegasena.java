package br.com.upe;

import java.util.Arrays;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

public class ResultadoMegasena {
	
	private static String nomeSorteio;
	private static String MARCA_INICIAL_RETORNO_NAO_UTIL;
	
	public ResultadoMegasena(String nomeSorteio) {
		this.nomeSorteio = nomeSorteio;
		// Movi a variável estática para o construtor
		// A variável nome sorteio não funcionava fora de um método estático 
		this.MARCA_INICIAL_RETORNO_NAO_UTIL = "<ul class=\"resultado-loteria " + nomeSorteio + "\">";
	}
	
	private final static String URL = "http://loterias.caixa.gov.br/wps/portal/loterias/landing/";
	private final static String MARCA_FINAL_RETORNO_NAO_UTIL = "</ul>";
	
	public static String obtemUltimoResultado() {
		HttpClient httpclient = new DefaultHttpClient();
		
		try {
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
		Integer parteInicial = html.indexOf(MARCA_INICIAL_RETORNO_NAO_UTIL);
//		System.out.println("parteInicial: " + parteInicial);
		
		Integer parteFinal = html.indexOf(MARCA_FINAL_RETORNO_NAO_UTIL, parteInicial);
//		System.out.println("parteFinal: " + parteFinal);
		
		String extracao = html.substring(parteInicial, parteFinal).replaceAll("[^0-9]", " ");
//		System.out.println("extracao: " + extracao);
		
		return extracao;
	}
}
