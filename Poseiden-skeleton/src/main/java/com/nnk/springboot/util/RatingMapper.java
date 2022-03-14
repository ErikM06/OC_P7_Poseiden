package com.nnk.springboot.util;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import com.nnk.springboot.DTOs.RatingDTO;
import com.nnk.springboot.domain.Rating;

@Component
@Mapper (componentModel = "spring")
public interface RatingMapper {
	@BeanMapping (nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateBidListByBidListDTO (RatingDTO ratingDto, @MappingTarget Rating rating);

}
