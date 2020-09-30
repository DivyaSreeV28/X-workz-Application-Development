package com.xworkz.springbootweb.configuration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

	public WelcomeController() {
		System.out.println("Created " + this.getClass().getSimpleName());
	}

	@RequestMapping("onclick")
	public String onClick() {
		System.out.println("Invoked onClick");
		return "welcome.jsp";
	}

	@RequestMapping("welcome")
	public String WelcomeMessage(String from, String message, String to, Model model) {
		try {
			System.out.println("Invoked welcome page and redirecting to DisplayMessage.jsp");

			model.addAttribute("from", from);
			model.addAttribute("message", message);
			model.addAttribute("to", to);
		} catch (Exception e) {
			System.err.println("Exception in welcome controller " + e);
		}
		return "DisplayMessage.jsp";
	}
	
}