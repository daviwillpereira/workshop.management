package br.com.emporiodoscalcados.workshop.management.signup;

import java.util.function.Predicate;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class EmailValidator implements Predicate<String>{

	@Override
	public boolean test(String s) {
		return Pattern.matches("^[a-z-0-9.]+@[a-z0-9]+\\.[a-z]+(\\.[a-z]+)?$", s);
	}

}
