package com.nnk.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.DTOs.BidListDTO;
import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.interfaces.IBidListService;
import com.nnk.springboot.repositories.BidListRepository;
import com.nnk.springboot.util.BidListMapper;

import customExceptions.CustomIdNotFoundException;

@Service
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
		BidList bid = new BidList();
		bMapper.updateBidListByBidListDTO(bidDto, bid);
		return bidListRepo.save(bid);
	}

	@Override
	public BidList uptadeBid(Integer id, BidListDTO bidDto) throws CustomIdNotFoundException {
		Optional<BidList>optional = bidListRepo.findById(id);
		if (optional.isEmpty()) {
			throw new CustomIdNotFoundException("BidList with id :"+id+" not found !");
		}
		BidList bidToUpdate = optional.get();
		bMapper.updateBidListByBidListDTO(bidDto, bidToUpdate);
		return bidListRepo.save(bidToUpdate);
	}

	@Override
	public void deleteBid(Integer id) {
		bidListRepo.deleteById(id);
	}

	@Override
	public BidList getById(Integer id) throws CustomIdNotFoundException {
		Optional<BidList>optional = bidListRepo.findById(id);
		if (optional.isEmpty()) {
			throw new CustomIdNotFoundException("BidList with id :"+id+" not found !");
		}
		// TODO Auto-generated method stub
		return optional.get();
	}
	

}
