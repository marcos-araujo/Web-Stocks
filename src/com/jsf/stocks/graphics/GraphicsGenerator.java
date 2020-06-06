package com.jsf.stocks.graphics;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartModel;
import org.primefaces.model.chart.LineChartSeries;

import com.jsf.stocks.indicators.Indicator;
import com.jsf.stocks.model.TemporalSeries;

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
		LineChartSeries chartSerie = new LineChartSeries(ind.toString());
		for(int i = begin; i <= end; i++){
			double value = ind.calculate(i, series);
			chartSerie.set(i, value);
		}
		this.graphicModel.addSeries(chartSerie);
	}

	public ChartModel getModelGraphic(){
		return this.graphicModel;
	}
	
}