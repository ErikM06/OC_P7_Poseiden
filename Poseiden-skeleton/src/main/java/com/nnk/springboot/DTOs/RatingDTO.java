package com.nnk.springboot.DTOs;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@Component
public class RatingDTO {
	Integer id;
	@NotBlank(message = "moodysRating is mandatory")
	String moodysRating;
	String sandPRating;
	String fitchRating;
	@NotNull(message = "orderNumber is mandatory")
	@Digits(integer = 8, fraction = 2, message = "Must be a number!")
	Integer orderNumber;

	public RatingDTO(String moodysRating, String sandPRating, String fitchRating, Integer orderNumber) {
		super();
		this.moodysRating = moodysRating;
		this.sandPRating = sandPRating;
		this.fitchRating = fitchRating;
		this.orderNumber = orderNumber;
	}

}
