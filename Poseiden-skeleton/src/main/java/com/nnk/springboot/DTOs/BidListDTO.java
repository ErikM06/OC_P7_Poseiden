package com.nnk.springboot.DTOs;

import javax.validation.constraints.NotBlank;

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
public class BidListDTO {
	
	private Integer id;
	@NotBlank (message = "Account is mandatory")
	String accountDto;
	@NotBlank (message = "Type is mandatory")
	String typeDto;
	
	Double bidQuantityDto;

	public BidListDTO(@NotBlank(message = "Account is mandatory") String accountDto,
			@NotBlank(message = "Type is mandatory") String typeDto, Double bidQuantityDto) {
		super();
		this.accountDto = accountDto;
		this.typeDto = typeDto;
		this.bidQuantityDto = bidQuantityDto;
	}

}
