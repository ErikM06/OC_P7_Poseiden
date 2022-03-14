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
	
	Integer curveIdDto;
	Double valueDto;
	Double termDto;
	
	public CurvePointDTO(Integer curveIdDto, Double valueDto, Double termDto) {
		super();
		this.curveIdDto = curveIdDto;
		this.valueDto = valueDto;
		this.termDto = termDto;
	}

	
	
	

}
