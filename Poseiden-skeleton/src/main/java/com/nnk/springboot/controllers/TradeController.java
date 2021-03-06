package com.nnk.springboot.controllers;

import com.nnk.springboot.DTOs.TradeDTO;
import com.nnk.springboot.interfaces.ITradeService;

import customExceptions.CustomIdNotFoundException;

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

@Controller
public class TradeController {
	@Autowired
	ITradeService tradeService;

	@RequestMapping("/trade/list")
	public String home(Model model, @AuthenticationPrincipal OAuth2User principal) {
		if (principal!=null) {
			model.addAttribute("currentUser",principal.getAttributes().get("email"));
			}
		model.addAttribute("ratingLs", tradeService.getAllTrade());
		return "trade/list";
	}

	@GetMapping("/trade/add")
	public String addTrade(TradeDTO tradeDto, Model model) {
		model.addAttribute("tradeDto", new TradeDTO());
		return "trade/add";
	}

	@PostMapping("/trade/validate")
	public String validate(@ModelAttribute("trade") @Valid TradeDTO tradeDto, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "trade/add";
		}
		tradeService.saveTrade(tradeDto);
		return "redirect:/trade/list";
	}

	@GetMapping("/trade/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("tradeDto", new TradeDTO());
		try {
		model.addAttribute("trade", tradeService.getTradeById(id));
		} catch (CustomIdNotFoundException e) {
			model.addAttribute("error", e.getMessage());
		}
		return "trade/update";
	}

	@PostMapping("/trade/update/{id}")
	public String updateTrade(@PathVariable("id") Integer id, @ModelAttribute("tradeDto") @Valid TradeDTO tradeDto,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "trade/update";
		}
		tradeService.updateTrade(id, tradeDto);
		return "redirect:/trade/list";
	}

	@GetMapping("/trade/delete/{id}")
	public String deleteTrade(@PathVariable("id") Integer id) {
		tradeService.deleteTrade(id);
		return "redirect:/trade/list";
	}
}
