package com.nnk.springboot.util;

import com.nnk.springboot.DTOs.CurvePointDTO;
import com.nnk.springboot.domain.CurvePoint;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-14T15:48:45+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11 (Oracle Corporation)"
)
@Component
public class CurvePointMapperImpl implements CurvePointMapper {

    @Override
    public void updateCurvePointByCurvePointDto(CurvePointDTO curvePointDTO, CurvePoint curvePoint) {
        if ( curvePointDTO == null ) {
            return;
        }
    }
}