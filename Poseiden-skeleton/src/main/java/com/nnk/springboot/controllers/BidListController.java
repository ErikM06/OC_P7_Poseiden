package com.nnk.springboot.controllers;

import java.nio.file.attribute.UserPrincipalNotFoundException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.nnk.springboot.DTOs.BidListDTO;
import com.nnk.springboot.interfaces.IBidListService;

import customExceptions.CustomIdNotFoundException;

@Controller
@RequestMapping
public class BidListController {

	Logger logger = LoggerFactory.getLogger(BidListController.class);

	@Autowired
	IBidListService iBidList;

	@RequestMapping("/bidList/list")
	public String home(Model model, @AuthenticationPrincipal OAuth2User principal)
			throws UserPrincipalNotFoundException {
		// TODO: call service find all bids to show to the view
		if (principal != null) {
			model.addAttribute("currentUser", principal.getAttributes().get("email"));
		}
		model.addAttribute("bidList", iBidList.getAllBidList());

		return "bidList/list";
	}

	@GetMapping("/bidList/add")
	public String addBidForm(Model model) {
		model.addAttribute("bidList", new BidListDTO());
		return "bidList/add";
	}

	@PostMapping("/bidList/validate")
	public String validate(@ModelAttribute("bidList") @Valid BidListDTO bidDto, BindingResult result, Model model) {
		// TODO: check data valid and save to db, after saving return bid list
		if (result.hasErrors()) {
			return "bidList/add";
		}
		iBidList.saveBid(bidDto);
		return "redirect:/bidList/list";
	}

	@GetMapping("/bidList/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		// TODO: get Bid by Id and to model then show to the form
		try {
		model.addAttribute("bidList", iBidList.getById(id));
		} catch (CustomIdNotFoundException e) {
			model.addAttribute("error", e.getMessage());
		}
		model.addAttribute("bidListDto", new BidListDTO());
		return "bidList/update";
	}

	@PostMapping("/bidList/update/{id}")
	public String updateBid(@PathVariable("id") Integer id, @ModelAttribute("bidListDto") @Valid BidListDTO bidListDto,
			BindingResult result, Model model) {
		// TODO: check required fields, if valid call service to update Bid and return
		// list Bid
		if (result.hasErrors()) {
			return "bidList/update";
		}
		// check if bid existe

		iBidList.uptadeBid(id, bidListDto);

		return "redirect:/bidList/list";
	}

	@GetMapping("/bidList/delete/{id}")
	public String deleteBid(@PathVariable("id") Integer id, Model model) {
		// TODO: Find Bid by Id and delete the bid, return to Bid list
		model.addAttribute("id", id);
		iBidList.deleteBid(id);
		return "redirect:/bidList/list";
	}
}
