package com.nnk.springboot.interfaces;

import java.util.List;

import org.springframework.validation.Errors;

import com.nnk.springboot.domain.BidList;

public interface IBidList {
	
	public List<BidList> getAllBidList();
	
	public BidList validateBid(BidList bid, Errors errors);
	
	public BidList uptadeBid(Integer id, BidList bid);
}
