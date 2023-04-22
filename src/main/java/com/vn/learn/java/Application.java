package com.vn.learn.java;

import com.vn.learn.java.entity.UserEntity;
import com.vn.learn.java.repository.UserRepository;
import com.vn.learn.java.ultil.lexorank.LexoRank;
import com.vn.learn.java.ultil.lexorank.LexoRankBucket;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RequiredArgsConstructor
@EnableJpaAuditing
public class Application {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@PostConstruct
	void tesst(){
		for (int i = 0; i < 11; i++) {
			UserEntity user = new UserEntity();
			user.setName("ten"+i);
			user.setEmail("email"+i);
			user.setPass(passwordEncoder.encode("pass"+i));
			String top = userRepository.getRankTopAsc();
			if (StringUtils.isNotBlank(top)){
				user.setOrderColumn(LexoRank.parse(top).genPrev().toString());
			}else {
				user.setOrderColumn(LexoRank.initial(LexoRankBucket.BUCKET_0).toString());
			}
			userRepository.save(user);
			userRepository.flush();
		}
	}

}
