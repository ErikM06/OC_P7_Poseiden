package com.nnk.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
	
	public BidList saveBid (BidList bid) {
		return bidListRepo.save(bid);
		
	}

	
	public BidList uptadeBid(Integer id, BidList bid) {
		BidList bidToUpdate =bidListRepo.getById(id);
		bidToUpdate.setAccount(bid.getAccount());
		bidToUpdate.setType(bid.getType());
		bidToUpdate.setAskQuantity(bid.getAskQuantity());
		
		return bidListRepo.save(bidToUpdate);
	}
	public void deleteBid (Integer id) {
		bidListRepo.deleteById(id);
	}
}
