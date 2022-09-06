package br.com.emporiodoscalcados.workshop.management.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import br.com.emporiodoscalcados.workshop.management.appuser.AppUserService;
import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig {

	private final AppUserService appUserService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	@Bean
	SecurityFilterChain web(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeHttpRequests(authorize -> {
				try {
					authorize
						.mvcMatchers("/api/v*/signup/**").permitAll()
						.mvcMatchers("/admin/**").hasRole("ADMIN")
						.anyRequest().authenticated().and().formLogin();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		)
		.authenticationProvider(daoAuthenticationProvider());
		return http.build();
	}

	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(bCryptPasswordEncoder);
		provider.setUserDetailsService(appUserService);

		return provider;
	}
}
