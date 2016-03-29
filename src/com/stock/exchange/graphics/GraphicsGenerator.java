package com.stock.exchange.graphics;

import org.primefaces.model.chart.CartesianChartModel;

import com.stock.exchange.indicators.Indicator;
import com.stock.exchange.indicators.SimpleMovingAverage;
import com.stock.exchange.model.TemporalSeries;

public class GraphicsGenerator{
	
	private int begin;
	private int end;
	private TemporalSeries series;
	private CartesianChartModel graphicModel;
	
	public GraphicsGenerator(TemporalSeries serie, int begin, int end){
		this.begin = begin;
		this.end = end;
		this.series = serie;
		this.graphicModel = new CartesianChartModel();
	}

	public void plotIndicator(Indicator ind){
		for(int i = begin; i <= end; i++){
			double value = ind.calculate(i, series);
			String indicator = ind.toString();
			Integer index = Integer.valueOf(i);
		}
	}
	
}
