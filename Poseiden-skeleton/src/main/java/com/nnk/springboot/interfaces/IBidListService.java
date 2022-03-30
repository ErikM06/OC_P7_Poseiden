package com.nnk.springboot.interfaces;

import java.util.List;

import com.nnk.springboot.DTOs.BidListDTO;
import com.nnk.springboot.domain.BidList;

import customExceptions.CustomIdNotFoundException;


public interface IBidListService {
	
	public List<BidList> getAllBidList();
	
	public BidList uptadeBid(Integer id, BidListDTO bidDto) throws CustomIdNotFoundException;
	
	public BidList saveBid (BidListDTO bidDto);
	
	public void deleteBid (Integer id);
	
	public BidList getById (Integer id) throws CustomIdNotFoundException;

}
