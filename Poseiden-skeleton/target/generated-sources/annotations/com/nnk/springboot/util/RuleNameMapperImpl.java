package com.nnk.springboot.util;

import com.nnk.springboot.DTOs.RuleNameDTO;
import com.nnk.springboot.domain.RuleName;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-29T12:56:01+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11 (Oracle Corporation)"
)
@Component
public class RuleNameMapperImpl implements RuleNameMapper {

    @Override
    public void updateRuleNameByDTO(RuleNameDTO ruleNameDto, RuleName ruleName) {
        if ( ruleNameDto == null ) {
            return;
        }

        if ( ruleNameDto.getName() != null ) {
            ruleName.setName( ruleNameDto.getName() );
        }
        if ( ruleNameDto.getDescription() != null ) {
            ruleName.setDescription( ruleNameDto.getDescription() );
        }
    }
}
