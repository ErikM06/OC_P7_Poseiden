package com.nnk.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.interfaces.IRatingService;
import com.nnk.springboot.repositories.RatingRepository;

@Service
public class RatingService implements IRatingService{
	
	@Autowired
	RatingRepository ratingRepo;

	@Override
	public List<Rating> getAllRating() {
		
		return ratingRepo.findAll();
	}

	@Override
	public Rating saveRating(Rating rating) {
		// TODO Auto-generated method stub
		return ratingRepo.save(rating);
	}

	@Override
	public Rating updateRating(Integer id, Rating rating) {
		Rating ratingToUpdate = ratingRepo.getById(id);
		ratingToUpdate.setFitchRating(rating.getFitchRating());
		ratingToUpdate.setMoodysRating(rating.getMoodysRating());
		ratingToUpdate.setOrderNumber(rating.getOrderNumber());
		ratingToUpdate.setSandPRating(rating.getSandPRating());
		return ratingRepo.save(ratingToUpdate);
	}

	@Override
	public void deleteRating(Integer id) {
		ratingRepo.deleteById(id);	
	}

}
