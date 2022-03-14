package com.nnk.springboot.util;

import com.nnk.springboot.DTOs.RuleNameDTO;
import com.nnk.springboot.domain.RuleName;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-14T21:03:09+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11 (Oracle Corporation)"
)
@Component
public class RuleNameMapperImpl implements RuleNameMapper {

    @Override
    public void updateRuleNameByDTO(RuleNameDTO ruleNameDto, RuleName ruleName) {
        if ( ruleNameDto == null ) {
            return;
        }
    }
}
