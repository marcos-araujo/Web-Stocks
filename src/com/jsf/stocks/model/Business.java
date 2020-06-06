package com.jsf.stocks.model;

import java.math.BigDecimal;
import java.util.Calendar;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("negociacao") 
public class Business{
	
	@XStreamAlias("preco")
	@XStreamAsAttribute  
	private final BigDecimal price;
	@XStreamAlias("quantidade")
	@XStreamAsAttribute  
	private final int amount;
	@XStreamAlias("data")
	@XStreamAsAttribute  
	private final Calendar date;
	
	public Business(BigDecimal price, int amount, Calendar date){
		if(date == null)
			throw new IllegalArgumentException("Invalid date.");
		this.price = price;
		this.amount = amount;
		this.date = date;
	}

	public BigDecimal getPrice(){
		return price;
	}

	public int getQuantity(){
		return amount;
	}

	public Calendar getDate(){
		return (Calendar) this.date.clone();
	}
	
	public BigDecimal getVolume(){
		return new BigDecimal(price.doubleValue() * amount);
	}

	public boolean isSameDay(Calendar outherDate){
		return this.date.get(Calendar.DATE) == outherDate.get(Calendar.DATE) && 
			this.date.get(Calendar.MONTH) == outherDate.get(Calendar.MONTH) && 
			this.date.get(Calendar.YEAR) == outherDate.get(Calendar.YEAR);
	}
	
}
