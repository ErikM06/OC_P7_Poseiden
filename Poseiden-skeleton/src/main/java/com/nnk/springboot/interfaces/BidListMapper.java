package com.nnk.springboot.interfaces;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import com.nnk.springboot.DTOs.BidListDTO;
import com.nnk.springboot.domain.BidList;

@Component
@Mapper (componentModel = "spring")
public interface BidListMapper {
	@BeanMapping (nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateBidListByBidListDTO (BidListDTO bidListDTO, @MappingTarget BidList bidList);
}
