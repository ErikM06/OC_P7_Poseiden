package com.nnk.springboot.interfaces;

import java.util.List;

import com.nnk.springboot.domain.Trade;



public interface ITradeService {
	
	public List<Trade> getAllTrade();

	public Trade saveTrade(Trade rating);

	public Trade updateTrade(Integer id, Trade rating);

	public void deleteTrade(Integer id);


}
