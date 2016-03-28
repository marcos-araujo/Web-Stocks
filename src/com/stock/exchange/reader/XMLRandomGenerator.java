package com.stock.exchange.reader;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import com.stock.exchange.model.Business;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XMLRandomGenerator{
	
	public static void main(String[] args) throws IOException{
		Calendar date = Calendar.getInstance();
		Random random = new Random(123);
		List<Business> businessList = new ArrayList<Business>();
		double value = 40;
		int amount = 1000;
		for(int days = 0; days < 30; days++){
			int dayBusinessAmount = random.nextInt(20);
			for(int business = 0; business < dayBusinessAmount; business++){
				value += (random.nextInt(200) - 100) / 100.0;
				if(value < 5.0)
					value = 5.0;
				amount += 1000 - random.nextInt(500);
				Business n = new Business(new BigDecimal(value), amount, date);
				businessList.add(n);
			}
			date = (Calendar) date.clone();
			date.add(Calendar.DAY_OF_YEAR, 1);
		}
		XStream stream = new XStream(new DomDriver());
		stream.alias("business", Business.class);
		stream.setMode(XStream.NO_REFERENCES);
		PrintStream out = new PrintStream(new File("business.xml"));
		out.println(stream.toXML(businessList));
	}

}
