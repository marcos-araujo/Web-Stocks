package com.stock.exchange.reader;

import java.math.BigDecimal;
import java.util.Calendar;

import com.stock.exchange.model.Candle;

public class CandleBuilder{
	
	private BigDecimal opening;
	private BigDecimal shutdown;
	private BigDecimal minimum;
	private BigDecimal maximum;
	private BigDecimal volume;
	private Calendar date;
	
	public CandleBuilder withOpening(BigDecimal opening){
		this.opening = opening;
		return this;
	}
	
	public CandleBuilder withShutdown(BigDecimal shutdown){
		this.shutdown = shutdown;
		return this;
	}
	
	public CandleBuilder withMinimum(BigDecimal minimum){
		this.minimum = minimum;
		return this;
	}
	
	public CandleBuilder withMaximum(BigDecimal maximum){
		this.maximum = maximum;
		return this;
	}
	
	public CandleBuilder withVolume(BigDecimal volume){
		this.volume = volume;
		return this;
	}
	
	public CandleBuilder withDate(Calendar date){
		this.date = date;
		return this;
	}

	public Candle buildCandle(){
		if(opening == null || shutdown == null || minimum == null || maximum == null || volume == null || date == null)
			throw new IllegalStateException("All atributes must be completed.");
		return new Candle(opening, shutdown, minimum, maximum, volume, date);
	}
	
}