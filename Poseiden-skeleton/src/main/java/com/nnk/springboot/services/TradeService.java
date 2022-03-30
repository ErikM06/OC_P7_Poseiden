package com.nnk.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.DTOs.TradeDTO;
import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.interfaces.ITradeService;
import com.nnk.springboot.repositories.TradeRepository;
import com.nnk.springboot.util.TradeMapper;

import customExceptions.CustomIdNotFoundException;

@Service
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
	public Trade saveTrade(TradeDTO tradeDto) {
		// TODO Auto-generated method stub
		Trade tradeToSave = new Trade();
		tMapper.updateRatingByDTO(tradeDto, tradeToSave);
		return tradeRepo.save(tradeToSave);
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
	public Trade getTradeById(Integer id) throws CustomIdNotFoundException {
		Optional<Trade>optional = tradeRepo.findById(id);
		if (optional.isEmpty()) {
			throw new CustomIdNotFoundException("trade with id :"+id+" not found!");
		}
		return optional.get();
	}

}
