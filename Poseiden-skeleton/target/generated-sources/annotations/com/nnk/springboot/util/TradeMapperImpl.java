package com.nnk.springboot.util;

import com.nnk.springboot.DTOs.TradeDTO;
import com.nnk.springboot.domain.Trade;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-24T13:23:38+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11 (Oracle Corporation)"
)
@Component
public class TradeMapperImpl implements TradeMapper {

    @Override
    public void updateRatingByDTO(TradeDTO tradeDto, Trade trade) {
        if ( tradeDto == null ) {
            return;
        }

        if ( tradeDto.getAccount() != null ) {
            trade.setAccount( tradeDto.getAccount() );
        }
        if ( tradeDto.getType() != null ) {
            trade.setType( tradeDto.getType() );
        }
    }
}
