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

import com.nnk.springboot.DTOs.RatingDTO;
import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.interfaces.IRatingService;

@Controller
public class RatingController {
    // TODO: Inject Rating service
	@Autowired
	IRatingService iRatingService;

    @RequestMapping("/rating/list")
    public String home(Model model)
    {
        // TODO: find all Rating, add to model
    	model.addAttribute("ratingLs",iRatingService.getAllRating());
        return "rating/list";
    }

    @GetMapping("/rating/add")
    public String addRatingForm(Model model) {
    	model.addAttribute("rating", new Rating());
        return "rating/add";
    }

    @PostMapping("/rating/validate")
    public String validate(@ModelAttribute("rating") @Valid Rating rating, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return Rating list
    	if (result.hasErrors()) {
    		return "redirect:/rating/add?error=true";
    		}
    	iRatingService.saveRating(rating);
        return "redirect:/rating/list";
    }

    @GetMapping("/rating/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get Rating by Id and to model then show to the form
    	model.addAttribute("ratingDto", new RatingDTO());
        return "rating/update";
    }

    @PostMapping("/rating/update/{id}")
    public String updateRating(@PathVariable("id") Integer id,  @ModelAttribute("ratingDto") @Valid RatingDTO ratingDto,
                             BindingResult result, Model model) {
        // TODO: check required fields, if valid call service to update Rating and return Rating list
    	if (result.hasErrors()) {
    		return "rating/update?error=true";
    	}
    	iRatingService.updateRating(id, ratingDto);
        return "redirect:/rating/list";
    }

    @GetMapping("/rating/delete/{id}")
    public String deleteRating(@PathVariable("id") Integer id, Model model) {
        // TODO: Find Rating by Id and delete the Rating, return to Rating list
    	model.addAttribute("id", id);
    	iRatingService.deleteRating(id);
        return "redirect:/rating/list";
    }
}
