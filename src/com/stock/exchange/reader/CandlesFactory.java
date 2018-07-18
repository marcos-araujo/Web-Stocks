package com.stock.exchange.reader;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.stock.exchange.model.Candle;
import com.stock.exchange.model.Business;

public class CandlesFactory{
	
	public Candle buildCandleToDate(Calendar date, List<Business> business){
		BigDecimal maximum = business.isEmpty() ? new BigDecimal(0) : business.get(0).getPrice();
		BigDecimal minimum = business.isEmpty() ? new BigDecimal(0) : business.get(0).getPrice();
		BigDecimal volume = new BigDecimal(0);

		for(Business b : business){
			volume = volume.add(b.getVolume());
			
			BigDecimal price = b.getPrice();
			if(price.compareTo(maximum) > 0)
				maximum = price;
			else if(price.compareTo(maximum) < 0)
				minimum = price;
		}
		
		BigDecimal opening = business.isEmpty() ? new BigDecimal(0) : business.get(0).getPrice();
		BigDecimal shutdown = business.isEmpty() ? new BigDecimal(0) : business.get(business.size()-1).getPrice();
		
		return new Candle(opening, shutdown, minimum, maximum, volume, date);
	}

	public List<Candle> buildCandles(List<Business> allBusiness){
		List<Candle> candles = new ArrayList<>();
		List<Business> businessOfDay = new ArrayList<>();
		Calendar atualDate = allBusiness.get(0).getDate();

		for(Business business : allBusiness){
			if(business.getDate().before(atualDate)) 
				throw new IllegalStateException("Wrong bussiness order.");
			if(!business.isSameDay(atualDate)){
				buildAndStoreCandle(candles, businessOfDay, atualDate);
				businessOfDay = new ArrayList<>();
				atualDate = business.getDate();
			}
			businessOfDay.add(business);
		}

		buildAndStoreCandle(candles, businessOfDay, atualDate);
		return candles;
	}

	private void buildAndStoreCandle(List<Candle> candles, List<Business> businessOfDay, Calendar atualDate){
		Candle candleOfDay = buildCandleToDate(atualDate, businessOfDay);
		candles.add(candleOfDay);
	}
	
}