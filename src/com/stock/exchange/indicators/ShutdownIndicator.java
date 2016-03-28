package com.stock.exchange.indicators;

import com.stock.exchange.model.TemporalSeries;

public class ShutdownIndicator implements Indicator{

	public double calculate(int position, TemporalSeries serie){
		return serie.getCandle(position).getShutdown().doubleValue();
	}

	@Override
	public String toString(){
		return "Shutdown Indicator";
	}
	
}