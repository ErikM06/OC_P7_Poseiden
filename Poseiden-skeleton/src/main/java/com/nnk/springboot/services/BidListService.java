package com.nnk.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.interfaces.IBidList;
import com.nnk.springboot.repositories.BidListRepository;

@Service
public class BidListService implements IBidList {
	
	@Autowired
	BidListRepository bidListRepo;
	
	public List<BidList> getAllBidList(){	
		return bidListRepo.findAll();	
	}

	@Override
	public BidList validateBid(BidList bid, Errors errors) {
		
		return null;
	}

	@Override
	public BidList uptadeBid(Integer id, BidList bid) {
		// TODO Auto-generated method stub
		return null;
	}
}
