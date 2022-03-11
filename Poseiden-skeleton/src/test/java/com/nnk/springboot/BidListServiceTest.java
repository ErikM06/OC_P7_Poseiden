package com.nnk.springboot;

import com.nnk.springboot.DTOs.BidListDTO;
import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
import com.nnk.springboot.services.BidListService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)

/*
 * https://springframework.guru/testing-spring-boot-restful-services/
 */
public class BidListServiceTest {

	Logger logger = LoggerFactory.getLogger(BidListServiceTest.class);

	@Mock
	private BidListRepository bidListRepository;

	@Autowired
	@InjectMocks
	private BidListService spyBidListService = Mockito.spy(new BidListService());
	private BidList bid1;
	private BidList bid2;
	private List<BidList> bidList;
	private BidListDTO bidDto;

	@BeforeEach
	public void setUp() {
		/*
		 * BidList bid = new BidList("Account Test", "Type Test", 10d); bid =
		 * bidListRepository.save(bid); logger.info(bid.toString()+"has been saved");
		 */
		bidList = new ArrayList<BidList>();
		bid1 = new BidList("Account Test", "Type Test", 10d);
		bid2 =  new BidList();
		bidList.add(bid1);
		bidList.add(bid2);
		
	}

	@AfterEach()
	public void tearDown() {
		// bidListRepository.deleteAll();
		bid1 = bid2 = null;
		bidList = null;
	}

	@Test
	public void saveBidTest() {
		/*
		 * BidList bid = new BidList("Account Test", "Type Test", 30d);
		 * bidListService.saveBid(bid); BidList bidToAssert =
		 * bidListRepository.getById(bid.getBidListId());
		 * Assert.assertNotNull(bidToAssert);
		 * Assert.assertEquals(bidToAssert.getBidQuantity(), 30d, 30d);
		 */
		when(bidListRepository.save(any())).thenReturn(bid1);
		spyBidListService.saveBid(bid1);
		verify(bidListRepository, times(1)).save(any());
	}

	@Test
	public void findAllBidTest() {
		/*
		 * List<BidList> listResult = bidListService.getAllBidList();
		 * Assert.assertFalse(listResult.isEmpty());
		 */
		bidListRepository.save(bid1);
		when(bidListRepository.findAll()).thenReturn(bidList);
		List<BidList> bidList1 = spyBidListService.getAllBidList();
		assertEquals(bidList, bidList1);
		verify(bidListRepository, times(1)).save(bid1);
		verify(bidListRepository, times(1)).findAll();
	}

	@Test
	public void updateBidTest() {
		bidDto = new BidListDTO("Account modified", "Type modified", 50d);
		bid1.setBidListId(1);
		when(bidListRepository.save(any())).thenReturn(any());
		bidListRepository.save(bid1);
		spyBidListService.uptadeBid(bid1.getBidListId(), bidDto);
		assertThat(bidDto.getId()==bid1.getBidListId() && bidDto.getAccountDto()==bid1.getAccount());
		verify(bidListRepository, times(2)).save(any());
	}

	@Test
	public void deleteBidTest() throws Exception{
		Optional<BidList> bid1Optional = Optional.of(bid1);
		if (bid1Optional.isEmpty()) {
			throw new Exception();
		} else {
			
			spyBidListService.deleteBid(bid1.getBidListId());
			verify(bidListRepository).deleteById(bid1.getBidListId());
		}

	}
}
