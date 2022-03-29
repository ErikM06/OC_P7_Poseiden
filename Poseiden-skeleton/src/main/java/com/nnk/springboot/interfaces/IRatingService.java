package com.nnk.springboot.interfaces;

import java.util.List;

import com.nnk.springboot.DTOs.RatingDTO;
import com.nnk.springboot.domain.Rating;

public interface IRatingService {
	public List<Rating> getAllRating();

	public Rating saveRating(RatingDTO ratingDto);

	public Rating updateRating(Integer id, RatingDTO ratingDto);

	public void deleteRating(Integer id);
	
	public Rating getById(Integer id);

}
