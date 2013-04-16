package com.btc.trade.dao;

import java.util.List;

import com.btc.trade.entity.Trade;

public interface MarketDao {

	public String tryToMakeDeal(Trade oppo);

	public List<Trade> getAllTradeData();

	public String deleteAllTradeData();
	
}
