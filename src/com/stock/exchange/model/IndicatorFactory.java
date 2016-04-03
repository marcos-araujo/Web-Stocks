package com.stock.exchange.model;

import java.lang.reflect.Constructor;

import com.stock.exchange.indicators.Indicator;

public class IndicatorFactory{
	
	private static final String PACKAGE = "com.stock.exchange.model.";
	private String indicadorName;
	private String mediaName;

	public IndicatorFactory(String indicadorName, String mediaName){
		super();
		this.indicadorName = indicadorName;
		this.mediaName = mediaName;
	}

	public Indicator getIndicador(){
		try{
			Indicator indicator = (Indicator) Class.forName(PACKAGE + this.indicadorName).newInstance();
			if(this.mediaName != null && !this.mediaName.isEmpty()){
				Constructor<?> constructor = Class.forName(PACKAGE + this.mediaName).getConstructor(Indicator.class);
				indicator = (Indicator) constructor.newInstance(indicator);
			}
			return indicator;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

}
