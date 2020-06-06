package com.jsf.stocks.indicators;

import com.jsf.stocks.model.TemporalSeries;

public class OpeningIndicator implements Indicator{

	public double calculate(int position, TemporalSeries serie){
		return serie.getCandle(position).getOpening().doubleValue();
	}

	@Override
	public String toString(){
		return "Opening Indicator";
	}
	
}