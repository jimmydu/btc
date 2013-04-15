package com.btc.trade.dao;

import com.btc.trade.entity.Trade;

public interface MarketDao {

	public String tryToMakeDeal(Trade oppo);
	
}
