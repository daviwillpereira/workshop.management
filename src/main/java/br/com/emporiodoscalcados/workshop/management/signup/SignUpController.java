package br.com.emporiodoscalcados.workshop.management.signup;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "api/v1/signup")
@AllArgsConstructor
public class SignUpController {

	private final SignUpService signUpService;

	@PostMapping
	public ResponseEntity<String> register(@RequestBody SignUpRequest request) {
		return ResponseEntity.status(HttpStatus.CREATED).body(signUpService.register(request));
	}

	@PatchMapping(path = "/confirm")
	public String confirm(@RequestParam("token") String token) {
		return signUpService.confirmToken(token);
	}
}
