package controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.User;
import repository.UserRepository;

@RestController
@RequestMapping("/")
// Test colab
public class AuthController {
	private UserRepository userRepository;

	public AuthController(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	@GetMapping("/")
	public String landing(){
		return "register";
	}
	
	@GetMapping("/login")
	public String login(){
		return "login";
	}

    @PostMapping("/")
    public String addUser(@RequestBody @Valid User user) {
        userRepository.save(user);
        return "login";
    }
	
}
