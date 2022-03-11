package com.nnk.springboot.services.util.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import com.nnk.springboot.DTOs.CurvePointDTO;
import com.nnk.springboot.domain.CurvePoint;

@Component
@Mapper (componentModel = "spring")
public interface CurvePointMapper {
	@BeanMapping (nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateCurvePointByCurvePointDto (CurvePointDTO curvePointDTO, @MappingTarget CurvePoint curvePoint);
}
