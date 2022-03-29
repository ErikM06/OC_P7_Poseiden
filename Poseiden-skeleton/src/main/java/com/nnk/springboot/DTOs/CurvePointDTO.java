package com.nnk.springboot.DTOs;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Component
public class CurvePointDTO {
	@NotNull(message = "id is mandatory")
	Integer curveId;
	@NotNull(message = "value is mandatory")
	@Digits(integer = 8, fraction = 2, message = "Must be a number!")
	Double value;
	@NotNull(message = "term is mandatory")
	@Digits(integer = 8, fraction = 2, message = "Must be a number!")
	Double term;
	
	public CurvePointDTO(Integer curveId, Double value, Double term) {
		super();
		this.curveId = curveId;
		this.value = value;
		this.term = term;
	}

	
	
	

}
