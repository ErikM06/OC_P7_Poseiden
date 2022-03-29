package com.nnk.springboot.DTOs;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
	@NotBlank (message = "account is mandatory")
	String account;
	@NotBlank(message = "type is mandatory")
	String type;
	@NotNull (message = "quantity is mandatory")
	@Digits(integer = 8, fraction = 2, message = "Must be a number!")
	Double bidQuantity;

	public BidListDTO(String account, String type, Double bidQuantity) {
		super();
		this.account = account;
		this.type = type;
		this.bidQuantity = bidQuantity;
	}

}
