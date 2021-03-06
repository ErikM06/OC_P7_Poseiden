package com.nnk.springboot.interfaces;

import java.util.List;

import com.nnk.springboot.DTOs.TradeDTO;
import com.nnk.springboot.domain.Trade;

import customExceptions.CustomIdNotFoundException;


public interface ITradeService {
	
	public List<Trade> getAllTrade();

	public Trade saveTrade(TradeDTO tradeDto);

	public Trade updateTrade(Integer id, TradeDTO tradeDto);

	public void deleteTrade(Integer id);

	public Trade getTradeById(Integer id) throws CustomIdNotFoundException;

}
