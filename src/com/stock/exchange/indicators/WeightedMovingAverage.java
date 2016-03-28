package com.stock.exchange.indicators;

import com.stock.exchange.model.TemporalSeries;

public class WeightedMovingAverage implements Indicator{
	
	private Indicator otherIndicator;
	
	public WeightedMovingAverage(Indicator otherIndicator){
		this.otherIndicator = otherIndicator;
	}
	
	public double calculate(int position, TemporalSeries series){
		double sum = 0.0;
		int weight = 1;

		for(int i = position - 2; i <= position; i++){
			sum += otherIndicator.calculate(i, series) * weight;
			weight ++;
		}

		return sum / 6;
	}

	@Override
	public String toString(){
		return "Weighted Moving Average - " + this.otherIndicator.toString();
	}
	
}