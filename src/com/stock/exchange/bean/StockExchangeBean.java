package com.stock.exchange.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.ChartModel;

import com.stock.exchange.graphics.GraphicsGenerator;
import com.stock.exchange.model.Business;
import com.stock.exchange.model.Candle;
import com.stock.exchange.model.TemporalSeries;
import com.stock.exchange.reader.CandlesFactory;
import com.stock.exchange.ws.ClientWebService;

@ManagedBean 
@SessionScoped
public class StockExchangeBean{
	
	private ChartModel graphicModel;

	private List<Business> business;
	
	public ChartModel getGraphicModel(){
		return graphicModel;
	}

	@PostConstruct 
	public void prepareData(){ 
		ClientWebService client = new ClientWebService(); 
		this.business = client.getBusiness(); 
		List<Candle> candles = new CandlesFactory().buildCandles(this.business); 
		TemporalSeries serie = new TemporalSeries(candles);
		GraphicsGenerator generator = new GraphicsGenerator(serie, 2, serie.getTotal()-1);
		generator.plotIndicator(ind);
		this.graphicModel = generator.getModeloGrafico()
	}

	public List<Business> getBusiness(){ 
		return business; 
	}
	
}