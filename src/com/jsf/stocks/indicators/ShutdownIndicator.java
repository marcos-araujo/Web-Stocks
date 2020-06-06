package com.jsf.stocks.indicators;

import com.jsf.stocks.model.TemporalSeries;

public class ShutdownIndicator implements Indicator{

	public double calculate(int position, TemporalSeries serie){
		return serie.getCandle(position).getShutdown().doubleValue();
	}

	@Override
	public String toString(){
		return "Shutdown Indicator";
	}
	
}