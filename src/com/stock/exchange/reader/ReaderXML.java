package com.stock.exchange.reader;

import java.io.InputStream;
import java.util.List;

import com.stock.exchange.model.Business;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ReaderXML{
	
	@SuppressWarnings("unchecked")
	public List<Business> load(InputStream inputStream){
		XStream stream = new XStream(new DomDriver());
		stream.alias("business", Business.class);
		return (List<Business>) stream.fromXML(inputStream);
	}

}