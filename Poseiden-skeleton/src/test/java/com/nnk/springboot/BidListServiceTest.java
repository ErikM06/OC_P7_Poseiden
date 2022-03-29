package com.nnk.springboot;

import com.nnk.springboot.DTOs.BidListDTO;
import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
import com.nnk.springboot.services.BidListService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import java.util.List;
import javax.transaction.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
/*
 * Integration test
 */
public class BidListServiceTest {

	Logger logger = LoggerFactory.getLogger(BidListServiceTest.class);

	@Autowired
	private BidListRepository bidListRepository;

	@Autowired
	private BidListService bidListService;

	@Mock
	private BidListDTO bidDto;

	@Mock
	private BidList bid;

	@BeforeEach
	public void setUpBid() {
		bid = new BidList("account test", "type test", 10.0);
		bidListRepository.save(bid);
		bidDto = new BidListDTO("accountDto test", "typeDto test", 50.0);
	}

	@AfterEach
	public void tearDown() {
		bid = null;
		bidDto = null;
		bidListRepository.deleteAll();
	}

	@Test
	public void saveBidTest() {
		BidList bidToSave = bidListService.saveBid(bidDto);
		assertNotNull(bidToSave);
		assertEquals(bidToSave.getAccount(), bidDto.getAccount());

	}

	@Test
	public void findAllBidTest() {
		List<BidList> bidList = bidListService.getAllBidList();
		assertNotNull(bidList);
		assertThat(bidList.contains(bid));
	}

	@Test
	@Transactional
	public void updateBidTest() {
		bidListService.uptadeBid(bid.getBidListId(), bidDto);
		BidList retrivedModifiedBid = bidListRepository.getById(bid.getBidListId());
		assertThat(bidDto.getAccount().equals(retrivedModifiedBid.getAccount()));
	}

	@Test
	public void deleteBidTest() throws Exception {
		bidListService.deleteBid(bid.getBidListId());
		assertFalse(bidListRepository.existsById(bid.getBidListId()));

	}
}
