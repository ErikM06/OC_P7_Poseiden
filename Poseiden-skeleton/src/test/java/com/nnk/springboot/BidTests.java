package com.nnk.springboot;

import com.nnk.springboot.DTOs.BidListDTO;
import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
import com.nnk.springboot.services.BidListService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")

public class BidTests {
	
	Logger logger = LoggerFactory.getLogger(BidTests.class);
	
	@Autowired
	private BidListRepository bidListRepository;

	@Autowired
	private BidListService bidListService;

	@BeforeAll
	@Transactional
	public void initBidValue() {
		BidList bid = new BidList("Account Test", "Type Test", 10d);
		bid = bidListRepository.save(bid);
		logger.info(bid.toString()+"has been saved");
	}

	@Test
	@Transactional
	public void saveBidTest() {
		BidList bid = new BidList("Account Test", "Type Test", 30d);
		bidListService.saveBid(bid);
		BidList bidToAssert = bidListRepository.getById(bid.getBidListId());
		Assert.assertNotNull(bidToAssert);
		Assert.assertEquals(bidToAssert.getBidQuantity(), 30d, 30d);
	}

	@Test
	public void findAllBidTest() {
		List<BidList> listResult = bidListService.getAllBidList();
		Assert.assertFalse(listResult.isEmpty());
	}

	@Test
	public void updateBidTest() {
	
		List<BidList> bidLs = bidListRepository.findAll();
		BidList bid= bidLs.get(0);
		BidListDTO bidDto = new BidListDTO();
		bidDto.setId(bid.getBidListId());
		bidDto.setBidQuantityDto(20d);
		bidListService.uptadeBid(bid.getBidListId(), bidDto);

		Assert.assertEquals(bidListRepository.getById(bid.getBidListId()).getBidQuantity(), 20d, 20d);
	}

	@Test
	public void deleteBidTest() {

		List<BidList> bidLs = bidListRepository.findAll();
		BidList bid= bidLs.get(0);
		bidListRepository.delete(bid);
		Assert.assertFalse(bidListRepository.findById(bid.getBidListId()).isPresent());
	}
}
