package com.nnk.springboot.DTOs;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode
@Component
public class RatingDTO {
	Integer idDto;
	@NotBlank(message = "moodysRating is mandatory")
	String moodysRatingDto;
	String sandPRatingDto;
	String fitchRatingDto;
	@Digits(integer = 8, fraction = 2, message = "Must be a number!")
	Integer orderNumberDto;

	public RatingDTO(String moodysRatingDto, String sandPRatingDto, String fitchRatingDto, Integer orderNumberDto) {
		super();
		this.moodysRatingDto = moodysRatingDto;
		this.sandPRatingDto = sandPRatingDto;
		this.fitchRatingDto = fitchRatingDto;
		this.orderNumberDto = orderNumberDto;
	}

}
