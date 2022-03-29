package com.nnk.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.DTOs.RatingDTO;
import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.interfaces.IRatingService;
import com.nnk.springboot.repositories.RatingRepository;
import com.nnk.springboot.util.RatingMapper;

import customExceptions.CustomBidNotFoundException;

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
	public Rating saveRating(RatingDTO ratingDto) {
		Rating ratingToSave = new Rating();
		rMapper.updateRatingByDTO(ratingDto, ratingToSave);;
		return ratingRepo.save(ratingToSave);
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
		Optional<Rating>optional = ratingRepo.findById(id);
		if (optional.isEmpty()) {
			throw new CustomBidNotFoundException("Rating with id:"+id+" not found!");
		}
		return optional.get();
	}

}
