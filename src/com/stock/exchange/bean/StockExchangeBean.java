package com.stock.exchange.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.stock.exchange.model.Business;
import com.stock.exchange.ws.ClientWebService;

@ManagedBean 
@SessionScoped
public class StockExchangeBean{

	private List<Business> business;

	@PostConstruct 
	public void prepareData(){ 
		ClientWebService client = new ClientWebService(); 
		this.business = client.getBusiness(); 
	}

	public List<Business> getBusiness(){ 
		return business; 
	}
	
}