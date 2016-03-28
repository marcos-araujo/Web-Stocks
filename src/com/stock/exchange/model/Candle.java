package com.stock.exchange.model;

import java.math.BigDecimal;
import java.util.Calendar;

public class Candle{
	
	private final BigDecimal opening;
	private final BigDecimal shutdown;
	private final BigDecimal minimum;
	private final BigDecimal maximum;
	private final BigDecimal volume;
	private final Calendar date;
	
	public Candle(BigDecimal opening, BigDecimal shutdown, BigDecimal minimum, BigDecimal maximum, BigDecimal volume, Calendar date){
		if(maximum.doubleValue() < minimum.doubleValue())
			throw new IllegalArgumentException("Invalid numbers.");

		if(opening.doubleValue() < 0 || shutdown.doubleValue() < 0 || minimum.doubleValue() < 0 || maximum.doubleValue() < 0)
			throw new IllegalArgumentException("Invalid numbers.");

		if(date == null)
			throw new IllegalArgumentException("Invalid date.");
		
		this.opening = opening;
		this.shutdown = shutdown;
		this.minimum = minimum;
		this.maximum = maximum;
		this.volume = volume;
		this.date = date;
	}
	
	public BigDecimal getOpening(){
		return opening;
	}

	public BigDecimal getShutdown(){
		return shutdown;
	}

	public BigDecimal getMinimum(){
		return minimum;
	}

	public BigDecimal getMaximum(){
		return maximum;
	}

	public BigDecimal getVolume(){
		return volume;
	}

	public Calendar getDate(){
		return date;
	}

	public boolean isHigh(){
		return this.opening.doubleValue() <= this.shutdown.doubleValue();
	}

	public boolean isDown(){
		return this.opening.doubleValue() > this.shutdown.doubleValue();
	}
	
	public String toString(){
		return "[Opening " +  this.getOpening() + ", Shutdown " +  this.getShutdown() + ", Minimum" +  this.getMinimum() + 
				", Maximum" + this.getMaximum() + ", Volume " +  this.getVolume() + ", Date" + this.getDate() + "]";
	}
	
}