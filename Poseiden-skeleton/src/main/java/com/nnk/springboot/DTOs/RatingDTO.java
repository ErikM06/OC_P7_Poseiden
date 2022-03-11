package com.nnk.springboot.DTOs;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class RatingDTO {
	Integer idDto;
	@NotBlank (message = "moodysRating is mandatory")
	String moodysRatingDto;
	String sandPRatingDto;
	String fitchRatingDto;
	Integer orderNumberDto;
	public RatingDTO( String moodysRatingDto, String sandPRatingDto,
			String fitchRatingDto, Integer orderNumberDto) {
		super();
		this.moodysRatingDto = moodysRatingDto;
		this.sandPRatingDto = sandPRatingDto;
		this.fitchRatingDto = fitchRatingDto;
		this.orderNumberDto = orderNumberDto;
	}
	
	

}
