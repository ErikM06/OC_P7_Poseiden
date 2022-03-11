package com.nnk.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.DTOs.BidListDTO;
import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.interfaces.BidListMapper;
import com.nnk.springboot.interfaces.IBidListService;
import com.nnk.springboot.repositories.BidListRepository;


@Service
public class BidListService implements IBidListService, BidListMapper {
	
	@Autowired
	BidListRepository bidListRepo;
	
	
	@Override
	public List<BidList> getAllBidList(){	
		return bidListRepo.findAll();	
	}
	@Override
	public BidList saveBid (BidList bid) {
		return bidListRepo.save(bid);
		
	}

	@Override
	public BidList uptadeBid(Integer id, BidListDTO bidDto) {
		BidList bidToUpdate =bidListRepo.getById(id);
		/*bidToUpdate.setAccount(bid.getAccount());
		bidToUpdate.setType(bid.getType());
		bidToUpdate.setAskQuantity(bid.getAskQuantity());*/
		updateBidListByBidListDTO(bidDto, bidToUpdate);
		return bidListRepo.save(bidToUpdate);
	}
	@Override
	public void deleteBid (Integer id) {
		bidListRepo.deleteById(id);
	}

	@Override
	public void updateBidListByBidListDTO(BidListDTO bidListDTO, BidList bidList) {
		// TODO Auto-generated method stub
		
	}
}
