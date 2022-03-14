package com.nnk.springboot.util;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import com.nnk.springboot.DTOs.TradeDTO;
import com.nnk.springboot.domain.Trade;

@Component
@Mapper (componentModel = "spring")
public interface TradeMapper {
	
	@BeanMapping (nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateRatingByDTO (TradeDTO tradeDto, @MappingTarget Trade trade);

}
