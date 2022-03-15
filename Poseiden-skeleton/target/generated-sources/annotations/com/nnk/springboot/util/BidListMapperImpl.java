package com.nnk.springboot.util;

import com.nnk.springboot.DTOs.BidListDTO;
import com.nnk.springboot.domain.BidList;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-15T19:24:43+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11 (Oracle Corporation)"
)
@Component
public class BidListMapperImpl implements BidListMapper {

    @Override
    public void updateBidListByBidListDTO(BidListDTO bidListDTO, BidList bidList) {
        if ( bidListDTO == null ) {
            return;
        }

        if ( bidListDTO.getAccount() != null ) {
            bidList.setAccount( bidListDTO.getAccount() );
        }
        if ( bidListDTO.getType() != null ) {
            bidList.setType( bidListDTO.getType() );
        }
        if ( bidListDTO.getBidQuantity() != null ) {
            bidList.setBidQuantity( bidListDTO.getBidQuantity() );
        }
    }
}
