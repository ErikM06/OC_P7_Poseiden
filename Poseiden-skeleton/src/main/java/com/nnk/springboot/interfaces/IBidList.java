package com.nnk.springboot.interfaces;

import java.util.List;

import com.nnk.springboot.domain.BidList;

public interface IBidList {
	
	public List<BidList> getAllBidList();
	
	public BidList uptadeBid(Integer id, BidList bid);
	
	public BidList saveBid (BidList bid);
	
	public void deleteBid (Integer id);
}
