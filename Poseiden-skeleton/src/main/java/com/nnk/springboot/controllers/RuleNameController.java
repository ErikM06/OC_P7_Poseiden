package com.nnk.springboot.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nnk.springboot.DTOs.RuleNameDTO;
import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.interfaces.IRuleNameService;

@Controller
public class RuleNameController {
	// TODO: Inject RuleName service
	@Autowired
	IRuleNameService ruleNameService;

	@RequestMapping("/ruleName/list")
	public String home(Model model) {
		// TODO: find all RuleName, add to model
		model.addAttribute("ruleNameLs", ruleNameService.getAllRuleName());
		return "ruleName/list";
	}

	@GetMapping("/ruleName/add")
	public String addRuleForm(Model model) {
		model.addAttribute("ruleName", new RuleName());
		return "ruleName/add";
	}

	@PostMapping("/ruleName/validate")
	public String validate(@ModelAttribute("ruleName") @Valid RuleName ruleName, BindingResult result, Model model) {
		// TODO: check data valid and save to db, after saving return RuleName list
		if (result.hasErrors()) {
			return "ruleName/add";
		}
		ruleNameService.saveRuleName(ruleName);
		return "redirect:/ruleName/list";
	}

	@GetMapping("/ruleName/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		// TODO: get RuleName by Id and to model then show to the form
		model.addAttribute("ruleNameDto", new RuleNameDTO());
		return "ruleName/update";
	}

	@PostMapping("/ruleName/update/{id}")
	public String updateRuleName(@PathVariable("id") Integer id,
			@ModelAttribute("ruleNameDto") @Valid RuleNameDTO ruleNameDto, BindingResult result, Model model) {
		// TODO: check required fields, if valid call service to update RuleName and
		// return RuleName list
		if (result.hasErrors()) {
			return "ruleName/add";
		}
		ruleNameService.uptadeRuleName(id, ruleNameDto);
		return "redirect:/ruleName/list";
	}

	@GetMapping("/ruleName/delete/{id}")
	public String deleteRuleName(@PathVariable("id") Integer id, Model model) {
		// TODO: Find RuleName by Id and delete the RuleName, return to Rule list
		ruleNameService.deleteRuleName(id);
		return "redirect:/ruleName/list";
	}
}
