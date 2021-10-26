package br.com.upe;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

public class ResultadoMegasena {
	private final static String URL = "";
	private final static String MARCA_INICIAL_RETORNO_NAO_UTIL = "<div>";
	private final static String MARCA_FINAL_RETORNO_NAO_UTIL = "</div>";
	
	public static String[] obtemUltimoResultado() {
		HttpClient httpclient = new DefaultHttpClient();
		
		try {
			HttpGet httpget = new HttpGet(URL);
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			String html = httpclient.execute(httpget, responseHandler);
			
			return obterDezenas(html);
		}
		catch(Exception e) {
			throw new RuntimeException("Um erro inesperado ocorreu.", e);
		}
		finally {
			httpclient.getConnectionManager().shutdown();
		}
	}
	
	public static String[] obterDezenas(String html) {
		Integer parteInicial = html.indexOf(MARCA_INICIAL_RETORNO_NAO_UTIL) + MARCA_INICIAL_RETORNO_NAO_UTIL.length();
		Integer parteFinal = html.indexOf(MARCA_FINAL_RETORNO_NAO_UTIL);
		String extracao = html.substring(parteInicial, parteFinal).replaceAll(" ", "");
		String[] numeros = extracao.split("-");
		return numeros;
	}
}
