package com.jsf.stocks.indicators;

import com.jsf.stocks.model.TemporalSeries;

public class SimpleMovingAverage implements Indicator{
	
	private Indicator outherIndicator;
	
	public SimpleMovingAverage(Indicator outherIndicator){
		this.outherIndicator = outherIndicator;
	}
	
	public double calculate(int position, TemporalSeries series){
		double sum = 0.0;

		for(int i = position - 2; i <= position; i++)
			sum += outherIndicator.calculate(i, series);

		return sum / 3;
	}

	public String toString(){
		return "Simple Moving Average - " + outherIndicator;
	}
	
}