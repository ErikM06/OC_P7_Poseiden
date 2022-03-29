package com.nnk.springboot.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nnk.springboot.DTOs.RuleNameDTO;
import com.nnk.springboot.interfaces.IRuleNameService;

import customExceptions.CustomBidNotFoundException;

@Controller
public class RuleNameController {
	// TODO: Inject RuleName service
	@Autowired
	IRuleNameService ruleNameService;

	@RequestMapping("/ruleName/list")
	public String home(Model model,@AuthenticationPrincipal OAuth2User principal) {
		if (principal!=null) {
			model.addAttribute("currentUser",principal.getAttributes().get("email"));
			}
		model.addAttribute("ruleNameLs", ruleNameService.getAllRuleName());
		return "ruleName/list";
	}

	@GetMapping("/ruleName/add")
	public String addRuleForm(Model model) {
		model.addAttribute("ruleNameDto", new RuleNameDTO());
		return "ruleName/add";
	}

	@PostMapping("/ruleName/validate")
	public String validate(@ModelAttribute("ruleNameDto") @Valid RuleNameDTO ruleNameDto, BindingResult result, Model model) {
		// TODO: check data valid and save to db, after saving return RuleName list
		if (result.hasErrors()) {
			return "ruleName/add";
		}
		ruleNameService.saveRuleName(ruleNameDto);
		return "redirect:/ruleName/list";
	}

	@GetMapping("/ruleName/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		try {
		model.addAttribute("ruleName", ruleNameService.getRuleNameById(id));
		} catch (CustomBidNotFoundException e) {
			model.addAttribute("error", e.getMessage());
		}
		model.addAttribute("ruleNameDto", new RuleNameDTO());
		return "ruleName/update";
	}

	@PostMapping("/ruleName/update/{id}")
	public String updateRuleName(@PathVariable("id") Integer id,
			@ModelAttribute("ruleNameDto") @Valid RuleNameDTO ruleNameDto, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "ruleName/add";
		}
		ruleNameService.uptadeRuleName(id, ruleNameDto);
		return "redirect:/ruleName/list";
	}

	@GetMapping("/ruleName/delete/{id}")
	public String deleteRuleName(@PathVariable("id") Integer id, Model model) {
		ruleNameService.deleteRuleName(id);
		return "redirect:/ruleName/list";
	}
}
