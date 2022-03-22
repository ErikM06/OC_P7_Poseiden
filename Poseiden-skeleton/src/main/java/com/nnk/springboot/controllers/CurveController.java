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

import com.nnk.springboot.DTOs.CurvePointDTO;
import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.interfaces.ICurvePointService;


@Controller
public class CurveController {
    // TODO: Inject Curve Point service
	@Autowired
	ICurvePointService iCurvePoint;

    @RequestMapping("/curvePoint/list")
    public String home(Model model, @AuthenticationPrincipal OAuth2User principal) {
		// TODO: call service find all bids to show to the view
		if (principal != null) {
			model.addAttribute("user", principal.getAttributes().get("email"));
			} else {
				model.addAttribute("user");
			}
    
        // TODO: find all Curve Point, add to model
    	model.addAttribute("curvePointList",iCurvePoint.getAllCurvePoint());
        return "curvePoint/list";
    }

    @GetMapping("/curvePoint/add")
    public String addCurvePointForm(CurvePoint curvePoint, Model model) {
    	model.addAttribute("curvePoint", curvePoint);
        return "curvePoint/add";
    }

    @PostMapping("/curvePoint/validate")
    public String validate(@ModelAttribute("curvePoint") @Valid CurvePoint curvePoint, BindingResult result, Model model) {
    	if (result.hasErrors()) {
    		return "curvePoint/add";
    	}
    	iCurvePoint.saveBid(curvePoint);
        // TODO: check data valid and save to db, after saving return Curve list
        return "redirect:/curvePoint/list";
    }

    @GetMapping("/curvePoint/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get CurvePoint by Id and to model then show to the form
    	model.addAttribute("curvePointDto", new CurvePointDTO());
        return "curvePoint/update";
    }

    @PostMapping("/curvePoint/update/{id}")
    public String updateBid(@PathVariable("id") Integer id, @ModelAttribute("curvePointDto") @Valid CurvePointDTO curvePointDTO,
                             BindingResult result, Model model) {
    	if (result.hasErrors()) {
    		return "curvePoint/update";
    	}
    	iCurvePoint.updateCurvePoint(id, curvePointDTO);
        // TODO: check required fields, if valid call service to update Curve and return Curve list
        return "redirect:/curvePoint/list";
    }

    @GetMapping("/curvePoint/delete/{id}")
    public String deleteBid(@PathVariable("id") Integer id, Model model) {
    	model.addAttribute("id", id);
    	iCurvePoint.deleteBid(id);
        // TODO: Find Curve by Id and delete the Curve, return to Curve list
        return "redirect:/curvePoint/list";
    }
}
