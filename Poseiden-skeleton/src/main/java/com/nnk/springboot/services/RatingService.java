package com.nnk.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.DTOs.RatingDTO;
import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.interfaces.IRatingService;
import com.nnk.springboot.repositories.RatingRepository;
import com.nnk.springboot.util.RatingMapper;

@Service
public class RatingService implements IRatingService{
	
	@Autowired
	RatingRepository ratingRepo;
	
	@Autowired
	RatingMapper rMapper;
	
	

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
	public Rating updateRating(Integer id, RatingDTO ratingDto) {
		Rating ratingToUpdate = ratingRepo.getById(id);
		rMapper.updateRatingByDTO(ratingDto, ratingToUpdate);;
		return ratingRepo.save(ratingToUpdate);
	}

	@Override
	public void deleteRating(Integer id) {
		ratingRepo.deleteById(id);	
	}

	@Override
	public Rating getById(Integer id) {
		// TODO Auto-generated method stub
		return ratingRepo.getById(id);
	}

	

	

}
