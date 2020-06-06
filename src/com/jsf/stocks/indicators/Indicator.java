package com.jsf.stocks.indicators;

import com.jsf.stocks.model.TemporalSeries;

public interface Indicator{

	double calculate(int position, TemporalSeries series);

}