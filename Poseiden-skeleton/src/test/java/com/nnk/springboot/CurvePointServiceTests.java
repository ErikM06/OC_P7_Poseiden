package com.nnk.springboot;

import com.nnk.springboot.DTOs.CurvePointDto;
import com.nnk.springboot.domain.CurvePoint;

import com.nnk.springboot.repositories.CurvePointRepository;

import com.nnk.springboot.services.CurvePointService;

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
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)

public class CurvePointServiceTests {

	Logger logger = LoggerFactory.getLogger(CurvePointServiceTests.class);

	@Mock
	private CurvePointRepository curvePointRepository;

	@Autowired
	@InjectMocks
	private CurvePointService spyCurvePointService = Mockito.spy(new CurvePointService());
	private CurvePoint curvePoint1;
	private List<CurvePoint> curvePointLs;
	private CurvePointDto curvePointDto;

	@BeforeEach
	public void setUp() {
		/*
		 * BidList bid = new BidList("Account Test", "Type Test", 10d); bid =
		 * bidListRepository.save(bid); logger.info(bid.toString()+"has been saved");
		 */
		curvePointLs = new ArrayList<CurvePoint>();
		curvePoint1 = new CurvePoint(1, 20.0, 20.0);
		curvePointLs.add(curvePoint1);
		;

	}

	@AfterEach()
	public void tearDown() {
		// bidListRepository.deleteAll();
		curvePoint1 = null;
		curvePointLs = null;
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
		when(curvePointRepository.save(any())).thenReturn(curvePoint1);
		spyCurvePointService.saveBid(curvePoint1);
		verify(curvePointRepository, times(1)).save(any());
	}

	@Test
	public void findAllBidTest() {
		/*
		 * List<BidList> listResult = bidListService.getAllBidList();
		 * Assert.assertFalse(listResult.isEmpty());
		 */
		curvePointRepository.save(curvePoint1);
		when(curvePointRepository.findAll()).thenReturn(curvePointLs);
		List<CurvePoint> curvePointList1 = spyCurvePointService.getAllCurvePoint();
		assertEquals(curvePointLs, curvePointList1);
		verify(curvePointRepository, times(1)).save(curvePoint1);
		verify(curvePointRepository, times(1)).findAll();
	}

	@Test
	public void updateCurvePoint() {
		curvePointDto = new CurvePointDto(4, 40.0, 50.0);
		when(curvePointRepository.save(any())).thenReturn(any());
		curvePointRepository.save(curvePoint1);
		spyCurvePointService.updateCurvePoint(curvePoint1.getCurveId(), curvePointDto);
		assertThat(curvePointDto.getCurveIdDto() == curvePoint1.getCurveId()
				&& curvePointDto.getTermDto() == curvePoint1.getTerm());
		verify(curvePointRepository, times(2)).save(any());
	}

	@Test
	public void deleteBidTest() throws Exception {
		Optional<CurvePoint> curvePoint1Optional = Optional.of(curvePoint1);
		if (curvePoint1Optional.isEmpty()) {
			throw new Exception();
		} else {

			spyCurvePointService.deleteBid(curvePoint1.getCurveId());
			verify(curvePointRepository).deleteById(curvePoint1.getCurveId());
		}

	}

}
