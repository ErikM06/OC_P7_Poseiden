package com.nnk.springboot.util;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import com.nnk.springboot.DTOs.RatingDTO;
import com.nnk.springboot.domain.Rating;


@Mapper(componentModel = "spring")
public interface RatingMapper {
	@BeanMapping (nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateRatingByDTO (RatingDTO ratingDto, @MappingTarget Rating rating);

}
