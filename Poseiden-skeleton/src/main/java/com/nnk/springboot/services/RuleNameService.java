package com.nnk.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.DTOs.RuleNameDTO;
import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.interfaces.IRuleNameService;
import com.nnk.springboot.repositories.RuleNameRepository;
import com.nnk.springboot.util.RuleNameMapper;

import customExceptions.CustomIdNotFoundException;

@Service
public class RuleNameService implements IRuleNameService{
	
	@Autowired
	RuleNameRepository ruleNameRepository;

	@Autowired
	RuleNameMapper rMapper;

	@Override
	public List<RuleName> getAllRuleName() {
		return ruleNameRepository.findAll();
	}

	@Override
	public RuleName uptadeRuleName(Integer id, RuleNameDTO ruleNameDto) {
		RuleName ruleNameToUpdate = ruleNameRepository.getById(id);
		rMapper.updateRuleNameByDTO(ruleNameDto, ruleNameToUpdate);
		return ruleNameRepository.save(ruleNameToUpdate);
	}

	@Override
	public RuleName saveRuleName(RuleNameDTO ruleNameDto) {
		RuleName ruleNameToSave = new RuleName();
		rMapper.updateRuleNameByDTO(ruleNameDto, ruleNameToSave);
		return ruleNameRepository.save(ruleNameToSave);
	}

	@Override
	public void deleteRuleName(Integer id) {
		ruleNameRepository.deleteById(id);
	}

	@Override
	public RuleName getRuleNameById(Integer id) {
		Optional<RuleName> optional = ruleNameRepository.findById(id);
		if (optional.isEmpty()) {
			throw new CustomIdNotFoundException("RuleName with id :"+id+" not found!");
		}
		return optional.get();
	}

}
