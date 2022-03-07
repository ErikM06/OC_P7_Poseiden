package com.nnk.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.interfaces.ITradeService;
import com.nnk.springboot.repositories.TradeRepository;

public class TradeService implements ITradeService{
	
	@Autowired
	TradeRepository tradeRepo;

	@Override
	public List<Trade> getAllTrade() {
		// TODO Auto-generated method stub
		return tradeRepo.findAll();
	}

	@Override
	public Trade saveTrade(Trade rating) {
		// TODO Auto-generated method stub
		return tradeRepo.save(rating);
	}

	@Override
	public Trade updateTrade(Integer id, Trade rating) {
		Trade tradeToUpdate = tradeRepo.getById(id);
		return null;
	}

	@Override
	public void deleteTrade(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
