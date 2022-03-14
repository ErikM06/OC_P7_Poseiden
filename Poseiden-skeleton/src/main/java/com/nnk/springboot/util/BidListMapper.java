package com.nnk.springboot.util;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import com.nnk.springboot.DTOs.BidListDTO;
import com.nnk.springboot.domain.BidList;



@Mapper(componentModel = "spring")
public interface BidListMapper {
	@BeanMapping (nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	public void updateBidListByBidListDTO (BidListDTO bidListDTO, @MappingTarget BidList bidList);
}


