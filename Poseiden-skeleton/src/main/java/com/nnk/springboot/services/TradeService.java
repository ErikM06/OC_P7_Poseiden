package com.nnk.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nnk.springboot.DTOs.TradeDTO;
import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.interfaces.ITradeService;
import com.nnk.springboot.repositories.TradeRepository;
import com.nnk.springboot.util.TradeMapper;

public class TradeService implements ITradeService{
	
	@Autowired
	TradeRepository tradeRepo;
	
	@Autowired
	TradeMapper tMapper;

	@Override
	public List<Trade> getAllTrade() {
		// TODO Auto-generated method stub
		return tradeRepo.findAll();
	}

	@Override
	public Trade saveTrade(Trade trade) {
		// TODO Auto-generated method stub
		return tradeRepo.save(trade);
	}

	@Override
	public Trade updateTrade(Integer id, TradeDTO tradeDto) {
		Trade tradeToUpdate = tradeRepo.getById(id);
		tMapper.updateRatingByDTO(tradeDto, tradeToUpdate);
		return tradeRepo.save(tradeToUpdate);
	}

	@Override
	public void deleteTrade(Integer id) {
		tradeRepo.deleteById(id);
		
	}

	@Override
	public Trade getById(Integer id) {
		// TODO Auto-generated method stub
		return tradeRepo.getById(id);
	}

}
