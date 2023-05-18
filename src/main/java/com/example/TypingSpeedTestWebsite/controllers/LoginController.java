package com.example.TypingSpeedTestWebsite.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("user-panel")
public class LoginController {

	@RequestMapping(value = {"", "index" }, method = RequestMethod.GET)
	public String index() {
		return "redirect:/user-panel/login";
	}

	@Operation(summary = "Log in", description = "Heads to login page.")
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(@Parameter(description = "Serves as error indicator, if user tries to log in with wrong credentials.", required = false)
			@RequestParam(value = "error", required = false) String error, @Parameter(description = "Serves as indicator of loggin out, if user logged out.", required = false)
			@RequestParam(value = "logout", required = false) String logout,
			ModelMap modelMap) {
		if (error != null) {
			modelMap.put("msg", "Invalid username or password");
		}
		if (logout != null) {
			modelMap.put("msg", "Logout successfully");
		}
		return "login";
	}

	@Operation(summary = "Log out", description = "Logs out user and heads him to login page.")
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout() {
		return "redirect:/user-panel/login?logout";
	}

	@Operation(summary = "Inform about denied access", description = "Informs about access denial, if user heads to page, which requires login.")
	@RequestMapping(value = "accessDenied", method = RequestMethod.GET)
	public String accessDenied(Authentication authentication, ModelMap modelMap) {
		if (authentication != null) {
			modelMap.put("msg", "Hi " + authentication.getName() + ", you do not have permission to access this page!");
		}
		else {
			modelMap.put("msg", "You do not have permission to access this page!");
		}
		return "accessDenied";
	}

	@Operation(summary = "Login landing page", description = "Is used as landing page after logging in. Redirects user to dashboard page.")
	@RequestMapping(value = "welcome", method = RequestMethod.GET)
	public String welcome() {
		return "redirect:/user/dashboard";
	}
}

