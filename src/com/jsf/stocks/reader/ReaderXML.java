package com.jsf.stocks.reader;

import java.io.InputStream;
import java.util.List;

import com.jsf.stocks.model.Business;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ReaderXML{
	
	@SuppressWarnings("unchecked")
	public List<Business> load(InputStream inputStream){
		XStream stream = new XStream(new DomDriver());
		stream.alias("negociacao", Business.class);
		stream.autodetectAnnotations(true);
		return (List<Business>) stream.fromXML(inputStream);
	}

}