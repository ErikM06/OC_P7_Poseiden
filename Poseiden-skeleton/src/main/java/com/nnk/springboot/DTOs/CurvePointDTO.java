package com.nnk.springboot.DTOs;

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
public class CurvePointDTO {
	
	Integer curveId;
	Double value;
	Double term;
	
	public CurvePointDTO(Integer curveId, Double value, Double term) {
		super();
		this.curveId = curveId;
		this.value = value;
		this.term = term;
	}

	
	
	

}
