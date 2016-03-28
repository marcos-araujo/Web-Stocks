package com.stock.exchange.indicators;

import com.stock.exchange.model.TemporalSeries;

public interface Indicator{

	double calculate(int position, TemporalSeries series);

}