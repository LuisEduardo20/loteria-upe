package br.com.upe;

import java.util.Arrays;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import java.io.IOException;

public class ResultadoLoteria {
	private static String MARCA_INICIAL_RETORNO_NAO_UTIL;

	public ResultadoLoteria(String nomeSorteio) {
		this.MARCA_INICIAL_RETORNO_NAO_UTIL = "<ul class=\"resultado-loteria " + nomeSorteio + "\">";
	}

	private final static String URL = "http://loterias.caixa.gov.br/wps/portal/loterias/landing/";
	private final static String MARCA_FINAL_RETORNO_NAO_UTIL = "</ul>";

	public static String obtemUltimoResultado() {
		CloseableHttpClient httpclient = HttpClientBuilder.create().build();

		try {
			HttpGet httpget = new HttpGet(URL);

			ResponseHandler<String> responseHandler = new BasicResponseHandler();

			String html = httpclient.execute(httpget, responseHandler);

			return obterDezenas(html);
		} catch (IOException e) {
			System.out.println(e);
			throw new RuntimeException("Um erro inesperado ocorreu.", e);
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
	}

	public static String obterDezenas(String html) {
		Integer parteInicial = html.indexOf(MARCA_INICIAL_RETORNO_NAO_UTIL);

		Integer parteFinal = html.indexOf(MARCA_FINAL_RETORNO_NAO_UTIL, parteInicial);

		String extracao = html.substring(parteInicial, parteFinal).replaceAll("[^0-9]", "");

		return extracao;

	}

	public static String resultadoFormatado(String extracao) {
		String resultado = "";

		for (int i = 0; i < extracao.length(); i += 2) {
			resultado += " ";
			resultado += extracao.substring(i, i + 2);
		}

		return resultado;
	}
}
