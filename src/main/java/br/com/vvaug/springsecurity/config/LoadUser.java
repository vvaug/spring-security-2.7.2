package br.com.vvaug.springsecurity.config;

import br.com.vvaug.springsecurity.entity.Role;
import br.com.vvaug.springsecurity.entity.User;
import br.com.vvaug.springsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class LoadUser {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner loadUserOnDatabase(){
        return args -> {
            userRepository.deleteAll();
            log.info("Loading user");
            userRepository.save(User.builder()
                    .username("vvaug")
                    .password(passwordEncoder.encode("vvaug"))
                    .roles(List.of(Role.builder()
                            .name("ROLE_USER")
                            .build()))
                    .build());
        };
    }
}
