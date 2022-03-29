package com.nnk.springboot.util;

import com.nnk.springboot.DTOs.RatingDTO;
import com.nnk.springboot.domain.Rating;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-29T12:27:52+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11 (Oracle Corporation)"
)
@Component
public class RatingMapperImpl implements RatingMapper {

    @Override
    public void updateRatingByDTO(RatingDTO ratingDto, Rating rating) {
        if ( ratingDto == null ) {
            return;
        }

        if ( ratingDto.getId() != null ) {
            rating.setId( ratingDto.getId() );
        }
        if ( ratingDto.getMoodysRating() != null ) {
            rating.setMoodysRating( ratingDto.getMoodysRating() );
        }
        if ( ratingDto.getSandPRating() != null ) {
            rating.setSandPRating( ratingDto.getSandPRating() );
        }
        if ( ratingDto.getFitchRating() != null ) {
            rating.setFitchRating( ratingDto.getFitchRating() );
        }
        if ( ratingDto.getOrderNumber() != null ) {
            rating.setOrderNumber( ratingDto.getOrderNumber() );
        }
    }
}
