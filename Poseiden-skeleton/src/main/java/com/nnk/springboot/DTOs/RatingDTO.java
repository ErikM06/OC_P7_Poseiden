package com.nnk.springboot.DTOs;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class RatingDTO {
	
	@NotBlank (message = "moodysRating is mandatory")
	String moodysRating;
	String sandPRating;
	String fitchRating;
	Integer orderNumber;
	
	public RatingDTO( String moodysRating, String sandPRating,
			String fitchRating, Integer orderNumber) {
		super();
		this.moodysRating = moodysRating;
		this.sandPRating = sandPRating;
		this.fitchRating = fitchRating;
		this.orderNumber = orderNumber;
	}

}
