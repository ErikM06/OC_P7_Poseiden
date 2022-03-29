package com.nnk.springboot.controllers;

import com.nnk.springboot.DTOs.TradeDTO;
import com.nnk.springboot.domain.Trade;
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
	// TODO: Inject Trade service
	@Autowired
	ITradeService tradeService;

	@RequestMapping("/trade/list")
	public String home(Model model, @AuthenticationPrincipal OAuth2User principal) {
		// TODO: find all Trade, add to model
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
		// TODO: check data valid and save to db, after saving return Trade list
		if (result.hasErrors()) {
			return "trade/add";
		}
		tradeService.saveTrade(tradeDto);
		return "redirect:/trade/list";
	}

	@GetMapping("/trade/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		// TODO: get Trade by Id and to model then show to the form
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
		// TODO: check required fields, if valid call service to update Trade and return
		// Trade list
		if (result.hasErrors()) {
			return "trade/update";
		}
		tradeService.updateTrade(id, tradeDto);
		return "redirect:/trade/list";
	}

	@GetMapping("/trade/delete/{id}")
	public String deleteTrade(@PathVariable("id") Integer id) {
		// TODO: Find Trade by Id and delete the Trade, return to Trade list
		tradeService.deleteTrade(id);
		return "redirect:/trade/list";
	}
}
