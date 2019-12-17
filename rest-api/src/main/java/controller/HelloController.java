package controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.User;
import repository.UserRepository;

@RestController
@RequestMapping("/hello")
public class HelloController {
	private UserRepository userRepository;

	public HelloController(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	@GetMapping
	public ResponseEntity<String> hello(){
		return new ResponseEntity<>("Hello",HttpStatus.OK);
	}
    @GetMapping("/{id}")
    public ResponseEntity<String> hello(@PathVariable("id") String id) {
        return new ResponseEntity<>("Hello" + id, HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<Void> addUser(@RequestBody @Valid User user) {
        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
	
}
