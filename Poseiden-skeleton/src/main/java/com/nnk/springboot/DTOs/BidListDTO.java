package com.nnk.springboot.DTOs;



import org.springframework.stereotype.Component;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Component
public class BidListDTO {
	
	private Integer id;
	
	String account;
	
	String type;
	
	Double bidQuantity;

	public BidListDTO(String account, String type, Double bidQuantity) {
		super();
		this.account = account;
		this.type = type;
		this.bidQuantity = bidQuantity;
	}

}
