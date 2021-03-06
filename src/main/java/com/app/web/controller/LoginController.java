package com.app.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.auth.service.SecurityService;
import com.app.service.UserService;
import com.app.user.model.UserModel;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	// @Autowired
	// private UserValidator userValidator;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		System.out.println("Welcome");
		model.addAttribute("userForm", new UserModel());

		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute("userForm") UserForm userForm, BindingResult bindingResult,
			Model model) {
		// userValidator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "registration";
		}

		UserModel userModel = new UserModel();
		userModel.setUsername(userForm.getUsername());
		userModel.setFirstName(userForm.getFirstName());
		userModel.setLastName(userForm.getLastName());
		userModel.setDob(userForm.getDob());
		
		if(userModel.getUsername() != null)
		userModel.setEmail(userModel.getUsername());
		
		userService.save(userModel);

		securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

		return "redirect:/welcome";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "login";
	}

	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String welcome(Model model) {
		return "welcome";
	}

}
