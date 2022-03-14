package com.nnk.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.DTOs.RuleNameDTO;
import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.interfaces.IRuleNameService;
import com.nnk.springboot.repositories.RuleNameRepository;
import com.nnk.springboot.util.RuleNameMapper;

@Service
public class RuleNameService implements IRuleNameService{
	
	@Autowired
	RuleNameRepository ruleNameRepository;

	@Autowired
	RuleNameMapper rMapper;

	@Override
	public List<RuleName> getAllRuleName() {
		// TODO Auto-generated method stub
		return ruleNameRepository.findAll();
	}

	@Override
	public RuleName uptadeRuleName(Integer id, RuleNameDTO ruleNameDto) {
		RuleName ruleNameToUpdate = ruleNameRepository.getById(id);
		rMapper.updateRuleNameByDTO(ruleNameDto, ruleNameToUpdate);
		// TODO Auto-generated method stub
		return ruleNameRepository.save(ruleNameToUpdate);
	}

	@Override
	public RuleName saveRuleName(RuleName ruleName) {
		// TODO Auto-generated method stub
		return ruleNameRepository.save(ruleName);
	}

	@Override
	public void deleteRuleName(Integer id) {
		// TODO Auto-generated method stub
		ruleNameRepository.deleteById(id);
	}

	@Override
	public RuleName getById(Integer id) {
		// TODO Auto-generated method stub
		return ruleNameRepository.getById(id);
	}

}
