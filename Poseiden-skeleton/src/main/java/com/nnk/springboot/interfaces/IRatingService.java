package com.nnk.springboot.interfaces;

import java.util.List;

import com.nnk.springboot.domain.Rating;

public interface IRatingService {
	public List<Rating> getAllRating();

	public Rating saveRating(Rating rating);

	public Rating updateRating(Integer id, Rating rating);

	public void deleteRating(Integer id);

}
