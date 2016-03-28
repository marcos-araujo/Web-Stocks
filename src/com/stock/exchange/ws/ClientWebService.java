package com.stock.exchange.ws;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.stock.exchange.model.Business;
import com.stock.exchange.reader.ReaderXML;

public class ClientWebService{
	
	private static final String URL_WEBSERVICE = "http://argentumws.caelum.com.br/negociacoes";
	
	public List<Business> getBusiness(){
		HttpURLConnection connection = null;
		URL url = null;
		InputStream content = null;
		try{
			url = new URL(URL_WEBSERVICE);
			connection = (HttpURLConnection)url.openConnection();
			content = connection.getInputStream();
		}catch(IOException e){
			e.printStackTrace();
		}
		return new ReaderXML().load(content);
	}

}
