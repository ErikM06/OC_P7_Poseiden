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

import com.nnk.springboot.DTOs.RatingDTO;
import com.nnk.springboot.interfaces.IRatingService;

import customExceptions.CustomIdNotFoundException;

@Controller
public class RatingController {
	@Autowired
	IRatingService iRatingService;

    @RequestMapping("/rating/list")
    public String home(Model model, @AuthenticationPrincipal OAuth2User principal)
    {
    	if (principal!=null) {
    		model.addAttribute("currentUser",principal.getAttributes().get("email"));
    		}
    	model.addAttribute("ratingLs",iRatingService.getAllRating());
        return "rating/list";
    }

    @GetMapping("/rating/add")
    public String addRatingForm(Model model) {
    	model.addAttribute("rating", new RatingDTO());
        return "rating/add";
    }

    @PostMapping("/rating/validate")
    public String validate(@ModelAttribute("rating") @Valid RatingDTO ratingDto, BindingResult result, Model model) {
    	if (result.hasErrors()) {
    		return "rating/add";
    		}
    	iRatingService.saveRating(ratingDto);
        return "redirect:/rating/list";
    }

    @GetMapping("/rating/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
    	try {
    	model.addAttribute("rating", iRatingService.getById(id));
    	} catch (CustomIdNotFoundException e) {
    		model.addAttribute("error", e.getMessage());
    	}
    	model.addAttribute("ratingDto", new RatingDTO());
        return "rating/update";
    }

    @PostMapping("/rating/update/{id}")
    public String updateRating(@PathVariable("id") Integer id,  @ModelAttribute("ratingDto") @Valid RatingDTO ratingDto,
                             BindingResult result, Model model) {
    	if (result.hasErrors()) {
    		return "rating/update?error=true";
    	}
    	iRatingService.updateRating(id, ratingDto);
        return "redirect:/rating/list";
    }

    @GetMapping("/rating/delete/{id}")
    public String deleteRating(@PathVariable("id") Integer id, Model model) {
    	iRatingService.deleteRating(id);
        return "redirect:/rating/list";
    }
}
