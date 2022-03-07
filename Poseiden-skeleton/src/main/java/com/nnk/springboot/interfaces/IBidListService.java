package com.nnk.springboot.interfaces;

import java.util.List;

import com.nnk.springboot.DTOs.BidListDTO;
import com.nnk.springboot.domain.BidList;

public interface IBidListService {
	
	public List<BidList> getAllBidList();
	
	public BidList uptadeBid(Integer id, BidListDTO bidDto);
	
	public BidList saveBid (BidList bid);
	
	public void deleteBid (Integer id);
}
