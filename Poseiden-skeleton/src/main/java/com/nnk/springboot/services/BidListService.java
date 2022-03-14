package com.nnk.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.nnk.springboot.DTOs.BidListDTO;
import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.interfaces.IBidListService;
import com.nnk.springboot.repositories.BidListRepository;
import com.nnk.springboot.util.BidListMapper;

@Service
@ComponentScan("com.nnk.springboot.util.BidListMapper")
public class BidListService implements IBidListService {

	@Autowired
	BidListRepository bidListRepo;

	@Autowired
	BidListMapper bMapper;

	@Override
	public List<BidList> getAllBidList() {
		return bidListRepo.findAll();
	}

	@Override
	public BidList saveBid(BidListDTO bidDto) {
		// mapping bitDto with a loop?
		BidList bid = new BidList();
		bid.setAccount(bidDto.getAccount());
		bid.setType(bidDto.getType());
		bid.setBidQuantity(bidDto.getBidQuantity());

		return bidListRepo.save(bid);
	}

	@Override
	public BidList uptadeBid(Integer id, BidListDTO bidDto) {
		BidList bidToUpdate = bidListRepo.getById(id);
		/*
		 * bidToUpdate.setAccount(bid.getAccount()); bidToUpdate.setType(bid.getType());
		 * bidToUpdate.setAskQuantity(bid.getAskQuantity());
		 */
		bMapper.updateBidListByBidListDTO(bidDto, bidToUpdate);
		return bidListRepo.save(bidToUpdate);
	}

	@Override
	public void deleteBid(Integer id) {
		bidListRepo.deleteById(id);
	}

	@Override
	public BidList getById(Integer id) {
		// TODO Auto-generated method stub
		return bidListRepo.getById(id);
	}

}
