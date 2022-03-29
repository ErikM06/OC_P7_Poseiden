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
import com.nnk.springboot.interfaces.ICurvePointService;

import customExceptions.CustomIdNotFoundException;

@Controller
public class CurveController {

	@Autowired
	ICurvePointService iCurvePoint;

	@RequestMapping("/curvePoint/list")
	public String home(Model model, @AuthenticationPrincipal OAuth2User principal) {
		if (principal != null) {
			model.addAttribute("currentUser", principal.getAttributes().get("email"));
		}

		model.addAttribute("curvePointList", iCurvePoint.getAllCurvePoint());
		return "curvePoint/list";
	}

	@GetMapping("/curvePoint/add")
	public String addCurvePointForm(CurvePointDTO curvePointDto, Model model) {
		model.addAttribute("curvePoint", curvePointDto);
		return "curvePoint/add";
	}

	@PostMapping("/curvePoint/validate")
	public String validate(@ModelAttribute("curvePoint") @Valid CurvePointDTO curvePointDto, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "curvePoint/add";
		}
		iCurvePoint.saveCurvePoint(curvePointDto);
		return "redirect:/curvePoint/list";
	}

	@GetMapping("/curvePoint/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		try {
			model.addAttribute("curvePoint", iCurvePoint.getCurvePointById(id));
		} catch (CustomIdNotFoundException e) {
			model.addAttribute("error", e.getMessage());
		}
		model.addAttribute("curvePointDto", new CurvePointDTO());
		return "curvePoint/update";
	}

	@PostMapping("/curvePoint/update/{id}")
	public String updateCurvePoint(@PathVariable("id") Integer id,
			@ModelAttribute("curvePointDto") @Valid CurvePointDTO curvePointDTO, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "curvePoint/update";
		}
		iCurvePoint.updateCurvePoint(id, curvePointDTO);

		return "redirect:/curvePoint/list";
	}

	@GetMapping("/curvePoint/delete/{id}")
	public String deleteCurvePoint(@PathVariable("id") Integer id, Model model) {
		iCurvePoint.deleteCurvePoint(id);
		return "redirect:/curvePoint/list";
	}
}
