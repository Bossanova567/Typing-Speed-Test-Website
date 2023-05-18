package com.example.TypingSpeedTestWebsite.controllers;

import com.example.TypingSpeedTestWebsite.models.Account;
import com.example.TypingSpeedTestWebsite.models.Role;
import com.example.TypingSpeedTestWebsite.services.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private AccountService accountService;

	@Operation(summary = "Register new account", description = "Heads to registration page.")
	@RequestMapping(value = "register",method = RequestMethod.GET)
	public String register(ModelMap modelMap) {
		modelMap.put("user", new Account());
		return "register";
	}

	@Operation(summary = "Register new account", description = "Creates a new account with the provided information.")
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(@Parameter(description = "User's account.", required = true) @ModelAttribute("user") Account account, ModelMap modelMap) {
		try {
			String hash = new BCryptPasswordEncoder().encode(account.getPassword());
			account.setPassword(hash);
			account.setRoleByRole(new Role(2));
			accountService.save(account);
			return "redirect:/user-panel";
		} catch (Exception e) {
			modelMap.put("err", e.getMessage());
			return "register";
		}
	}

	@Operation(summary = "View dashboard", description = "Heads to personal dashboard page, where users statistics is seen.")
	@RequestMapping(value = "dashboard",method = RequestMethod.GET)
	public String dashboard(ModelMap modelMap) {
		return "dashboard";
	}

	@Operation(summary = "Edit profile", description = "Heads to profile editing page.")
	@RequestMapping(value = "profile",method = RequestMethod.GET)
	public String profile(Authentication authentication, ModelMap modelMap) {
		modelMap.put("user", accountService.findByUsername(authentication.getName()));
		return "profile";
	}

	@Operation(summary = "Edit profile", description = "Edits user's personal data, like username or email.")
	@RequestMapping(value = "profile", method = RequestMethod.POST)
	public String profile(@Parameter(description = "User's account.", required = true) @ModelAttribute("user") Account account, ModelMap modelMap) {
		try {
			Account currentAccount = accountService.findById(account.getId());
			if(!account.getPassword().isEmpty()) {
				String hash = new BCryptPasswordEncoder().encode(account.getPassword());
				currentAccount.setPassword(hash);
			}
			currentAccount.setEmail(account.getEmail());
			accountService.save(currentAccount);
			return "redirect:/user/dashboard";
		} catch (Exception e) {
			modelMap.put("err", e.getMessage());
			return "profile";
		}
	}
	
	
}
