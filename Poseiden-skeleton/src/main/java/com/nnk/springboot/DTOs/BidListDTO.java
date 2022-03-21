package com.nnk.springboot.DTOs;



import javax.validation.constraints.Digits;

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
public class BidListDTO {
	
	private Integer id;
	
	String account;
	
	String type;
	
	@Digits(integer = 8, fraction = 2, message = "Must be a number!")
	Double bidQuantity;

	public BidListDTO(String account, String type, Double bidQuantity) {
		super();
		this.account = account;
		this.type = type;
		this.bidQuantity = bidQuantity;
	}

}
