package com.nnk.springboot;

import com.nnk.springboot.DTOs.RatingDTO;
import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;
import com.nnk.springboot.services.RatingService;

import org.junit.jupiter.api.*;
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
import static org.junit.Assert.assertTrue;
import java.util.List;
import javax.transaction.Transactional;

@ExtendWith (SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public class RatingServiceTests {

	Logger logger = LoggerFactory.getLogger(RatingServiceTests.class);

	@Autowired
	private RatingRepository ratingRepository;

	@Autowired
	private RatingService ratingService;
	
	@Mock
	private Rating rating;
	@Mock
	private RatingDTO ratingDTO;

	@BeforeEach
	public void setUp() {
		
		rating = new Rating("moodysRating  ", "sandRating ","fitchRating ", 1);
		ratingRepository.save(rating);
		ratingDTO = new RatingDTO("moodysRating modified ", "sandRating modified","fitchRating modified", 2);
	}

	@AfterEach()
	public void tearDown() {
		rating = null;
		ratingDTO = null;
		ratingRepository.deleteAll();
	}

	@Test
	public void saveRatingTest() {
		Rating ratingToSave = ratingService.saveRating(rating);
		assertNotNull(ratingToSave);
		assertEquals(ratingToSave.getId(), rating.getId());
	
	}

	@Test
	public void findAllRatingTest() {
		
		List<Rating> ratingLs = ratingService.getAllRating();
		assertNotNull(ratingLs);
		assertTrue(ratingLs.size() > 0);
	}

	@Test
	@Transactional
	public void updateRatingTest() {
		ratingService.updateRating(rating.getId(), ratingDTO);
		Rating retrivedModifiedRating = ratingRepository.getById(rating.getId());
		assertThat(ratingDTO.getMoodysRatingDto() == retrivedModifiedRating.getMoodysRating());
	}

	@Test
	public void deleteRatingTest() throws Exception{
		ratingService.deleteRating(rating.getId());
		assertFalse(ratingRepository.existsById(rating.getId()));

	}

	
}
