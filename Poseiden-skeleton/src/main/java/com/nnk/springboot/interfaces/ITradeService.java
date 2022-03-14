package com.nnk.springboot.interfaces;

import java.util.List;

import com.nnk.springboot.DTOs.TradeDTO;
import com.nnk.springboot.domain.Trade;


public interface ITradeService {
	
	public List<Trade> getAllTrade();

	public Trade saveTrade(Trade rating);

	public Trade updateTrade(Integer id, TradeDTO tradeDto);

	public void deleteTrade(Integer id);

	public Trade getById(Integer id);

}
