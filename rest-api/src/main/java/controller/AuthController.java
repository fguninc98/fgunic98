package controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.User;
import repository.UserRepository;

@Controller
public class AuthController {
	private UserRepository userRepository;

	public AuthController(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String landing(){
		return "register";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(){
		return "login";
	}

    @PostMapping("/")
    public String addUser(@RequestBody @Valid User user) {
        userRepository.save(user);
        return "login";
    }
	
}
