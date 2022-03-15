package com.nnk.springboot;

import com.nnk.springboot.DTOs.RuleNameDTO;
import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;
import com.nnk.springboot.services.RuleNameService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import javax.transaction.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public class RuleTests {

	@Autowired
	private RuleNameRepository ruleNameRepository;
	
	@Autowired
	private RuleNameService ruleNameService;
	
	@Mock
	RuleName rule;
	
	@Mock
	RuleNameDTO ruleNameDTO;

	@BeforeEach
	public void setUp() {
		rule = new RuleName("Rule name test","Rule Description test");
		ruleNameRepository.save(rule);
		ruleNameDTO = new RuleNameDTO("RuleNameDto name test","RuleNameDto Description test");
	}

	@AfterEach()
	public void tearDown() {
		rule = null;
		ruleNameDTO = null;
		ruleNameRepository.deleteAll();
	}

	@Test
	public void saveRuleNameTest() {
		RuleName ruleToSave = ruleNameService.saveRuleName(rule);
		assertNotNull(ruleToSave);
		assertEquals(ruleToSave.getName(), rule.getName());
	}

	@Test
	public void findAllRuleNameTest() {
		List<RuleName> ruleLs = ruleNameService.getAllRuleName();
		assertNotNull(ruleLs);
		assertThat(ruleLs.contains(rule));
	}

	@Test
	@Transactional
	public void updateRuleNameTest() {
		ruleNameService.uptadeRuleName(rule.getId(), ruleNameDTO);
		RuleName retrivedModifiedRule = ruleNameRepository.getById(rule.getId());
		assertThat(ruleNameDTO.getName().equals(retrivedModifiedRule.getName()));
	}

	@Test
	public void deleteRuleNameTest() throws Exception {
		ruleNameService.deleteRuleName(rule.getId());
		assertFalse(ruleNameRepository.existsById(rule.getId()));

	}
}
