package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.app.domain.Admin;
import com.example.app.service.AdminService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {
	
	private final AdminService service;
	
	@GetMapping
	public String showHome(Model model) {
		model.addAttribute("admin", new Admin());
		return "home";
	}
	
	@PostMapping
	public String login(
			@Valid Admin admin,
			Errors errors,
			HttpSession session) throws Exception{
		//入力内容に不備がある
		if(errors.hasErrors()) {
			return "home";
		}
		
		//パスワード正しくない
		if(!service.isCorrectIdAndPassword(admin.getLoginId(),
	admin.getLoginPass())) {
			errors.rejectValue("loginId", "error.incorrect_id_password");
			return "home";
		}
		
		//正しいログインIDとパスワード
		//セッションにログインIDを格納し、リダイレクト
		session.setAttribute("loginId", admin.getLoginId());
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//セッションを破棄し、トップページへ遷移
		session.invalidate();
		return "redirect:/";
	}

}
