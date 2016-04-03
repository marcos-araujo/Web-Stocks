package com.stock.exchange.indicators;

import com.stock.exchange.model.TemporalSeries;

public class OpeningIndicator implements Indicator{

	public double calculate(int position, TemporalSeries serie){
		return serie.getCandle(position).getOpening().doubleValue();
	}

	@Override
	public String toString(){
		return "Opening Indicator";
	}
	
}