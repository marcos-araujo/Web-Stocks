package com.stock.exchange.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.ChartModel;

import com.stock.exchange.graphics.GraphicsGenerator;
import com.stock.exchange.model.Business;
import com.stock.exchange.model.Candle;
import com.stock.exchange.model.IndicatorFactory;
import com.stock.exchange.model.TemporalSeries;
import com.stock.exchange.reader.CandlesFactory;
import com.stock.exchange.reader.XMLRandomGenerator;

@ManagedBean 
@SessionScoped
public class StockExchangeBean{
	
	private ChartModel graphicModel;
	private List<Business> business;
	private String title;
	private String indicator;
	private String media;
	
	public String getIndicator(){
		return indicator;
	}
	public void setIndicator(String indicator){
		this.indicator = indicator;
	}

	public String getMedia(){
		return media;
	}
	public void setMedia(String media){
		this.media = media;
	}

	public void setTitle(String title){
		this.title = title;
	}
	public String getTitle(){
		return title;
	}

	public ChartModel getGraphicModel(){
		return graphicModel;
	}

	public void prepareData(){ 
		//ClientWebService client = new ClientWebService(); 
		this.business = new XMLRandomGenerator().getBusiness(); 
		List<Candle> candles = new CandlesFactory().buildCandles(this.business); 
		TemporalSeries serie = new TemporalSeries(candles);
		GraphicsGenerator generator = new GraphicsGenerator(serie, 2, serie.getTotal()-1);
		IndicatorFactory indicadorFactory =	new IndicatorFactory(getIndicator(), getMedia());
		generator.plotIndicator(indicadorFactory.getIndicador());
		this.graphicModel = generator.getModelGraphic();
	}

	public List<Business> getBusiness(){ 
		return business; 
	}
	
}