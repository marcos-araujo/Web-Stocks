package com.stock.exchange.model;

import java.util.List;

public class TemporalSeries{
	
	private final List<Candle> candles;
	
	public TemporalSeries(List<Candle> candles){
		this.candles = candles;
	}

	public Candle getCandle(int i){
		return this.candles.get(i);
	}

	public int getTotal(){
		return this.candles.size();
	}

}