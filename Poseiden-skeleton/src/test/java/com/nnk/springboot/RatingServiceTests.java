package com.nnk.springboot;

import com.nnk.springboot.DTOs.RatingDTO;
import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;
import com.nnk.springboot.services.RatingService;

import org.junit.jupiter.api.*;
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

@ExtendWith (MockitoExtension.class)
public class RatingServiceTests {

	Logger logger = LoggerFactory.getLogger(RatingServiceTests.class);

	@Mock
	private RatingRepository ratingRepository;

	@Autowired
	@InjectMocks
	private RatingService spyRatingService = Mockito.spy(new RatingService());
	private Rating rating1;
	private List<Rating> ratingLs;
	private RatingDTO ratingDTO;

	@BeforeEach
	public void setUp() {
		/*
		 * BidList bid = new BidList("Account Test", "Type Test", 10d); bid =
		 * bidListRepository.save(bid); logger.info(bid.toString()+"has been saved");
		 */
		ratingLs = new ArrayList<Rating>();
		rating1 = new Rating("moodysRating Test", "sandRating Test","fitchRating Test", 1);
		ratingLs.add(rating1);
	}

	@AfterEach()
	public void tearDown() {
		// bidListRepository.deleteAll();
		rating1 = null;
		ratingLs = null;
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
		when(ratingRepository.save(any())).thenReturn(rating1);
		spyRatingService.saveRating(rating1);
		verify(ratingRepository, times(1)).save(any());
	}

	@Test
	public void findAllBidTest() {
		/*
		 * List<BidList> listResult = bidListService.getAllBidList();
		 * Assert.assertFalse(listResult.isEmpty());
		 */
		ratingRepository.save(rating1);
		when(ratingRepository.findAll()).thenReturn(ratingLs);
		List<Rating> ratingLs1 = spyRatingService.getAllRating();
		assertEquals(ratingLs, ratingLs1);
		verify(ratingRepository, times(1)).save(rating1);
		verify(ratingRepository, times(1)).findAll();
	}

	@Test
	public void updateBidTest() {
		ratingDTO = new RatingDTO("moodysRating modified ", "sandRating modified","fitchRating modified", 2);
		rating1.setId(1);
		when(ratingRepository.save(any())).thenReturn(any());
		ratingRepository.save(rating1);
		spyRatingService.updateRating(rating1.getId(), ratingDTO);
		assertThat(ratingDTO.getIdDto()==rating1.getId() && ratingDTO.getMoodysRatingDto()==rating1.getMoodysRating());
		verify(ratingRepository, times(2)).save(any());
	}

	@Test
	public void deleteBidTest() throws Exception{
		Optional<Rating> rating1Optional = Optional.of(rating1);
		if (rating1Optional.isEmpty()) {
			throw new Exception();
		} else {
			
			spyRatingService.deleteRating(rating1.getId());
			verify(ratingRepository).deleteById(rating1.getId());
		}

	}

	
}
