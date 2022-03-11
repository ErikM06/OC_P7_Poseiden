package com.nnk.springboot.DTOs;

import lombok.Data;

@Data
public class CurvePointDto {
	
	Integer curveIdDto;
	Double valueDto;
	Double termDto;
	
	public CurvePointDto(Integer curveIdDto, Double valueDto, Double termDto) {
		super();
		this.curveIdDto = curveIdDto;
		this.valueDto = valueDto;
		this.termDto = termDto;
	}
	
	

}
