package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.app.domain.Problem;
import com.example.app.service.ProblemService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/problems")
@RequiredArgsConstructor
public class ProblemController {
	
	private final ProblemService service;
	
	@GetMapping
	public String list(Model model) throws Exception {
		model.addAttribute("problems" , service.getProblemList());
		return "problems/list";
	}
	
	
	@GetMapping("/add")
	public String addGet(Model model) throws Exception {
		model.addAttribute("title", "問題の追加");
		model.addAttribute("problem", new Problem());
	
		return "problems/save";
	}
	
	@PostMapping("/add")
	public String addPost(
			@Valid Problem problem,
			Errors errors,
			RedirectAttributes rd,
			Model model) throws Exception {
		if(errors.hasErrors()) {
			model.addAttribute("title", "問題の追加");
			
			return "problems/save";
		}
		
		service.addProblem(problem);
		rd.addFlashAttribute("statusMessage", "問題を追加しました。");
		return "redirect:/problems";
	}
	
	@GetMapping("/edit/{id}")
	public String editGet(@PathVariable Integer id, Model model) throws
	Exception {
		model.addAttribute("title", "問題の変更");
		model.addAttribute("problem",service.getProblemById(id));
		return "problems/save";
	}
	
	@PostMapping("/edit/{id}")
	public String editPost(
			@PathVariable Integer id,
			@Valid Problem problem,
			Errors errors,
			RedirectAttributes rd,
			Model model) throws Exception{
		if(errors.hasErrors()) {
			model.addAttribute("title","問題の変更");
			return "problems/save";
		}
		
		problem.setId(id); //更新に必要な問題IDをセット
		service.editProblem(problem);
		rd.addFlashAttribute("statusMessage", "問題を更新しました。");
		return "redirect:/problems";
	}
			
			
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id,RedirectAttributes rd)
						throws Exception {
		service.deleteProblem(id);
		rd.addFlashAttribute("statusMessage", "問題を削除しました。");
		return "redirect:/problems";
	}

}
