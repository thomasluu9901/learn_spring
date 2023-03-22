package com.vn.learn.java;

import com.vn.learn.java.Entity.User;
import com.vn.learn.java.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RequiredArgsConstructor
@EnableJpaAuditing
public class Application {
	private final UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@PostConstruct
	void tesst(){
		for (int i = 6; i < 11; i++) {
			User user = new User();
			user.setName("ten"+i);
			user.setEmail("email"+i);
			user.setPass("pass"+i);
			userRepository.save(user);
		}
	}

}
