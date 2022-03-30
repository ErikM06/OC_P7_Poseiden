package com.nnk.springboot.interfaces;

import java.util.List;

import com.nnk.springboot.DTOs.RuleNameDTO;
import com.nnk.springboot.domain.RuleName;

import customExceptions.CustomIdNotFoundException;

public interface IRuleNameService {
	
public List<RuleName> getAllRuleName();
	
	public RuleName uptadeRuleName(Integer id, RuleNameDTO ruleNameDto);
	
	public RuleName saveRuleName(RuleNameDTO ruleNameDto);
	
	public void deleteRuleName(Integer id);
	
	public RuleName getRuleNameById (Integer id) throws CustomIdNotFoundException;

}
