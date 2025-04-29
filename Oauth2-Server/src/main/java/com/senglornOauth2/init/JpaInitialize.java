package com.senglornOauth2.init;

import com.senglornOauth2.entity.Authority;
import com.senglornOauth2.entity.User;
import com.senglornOauth2.repository.AuthorityRepository;
import com.senglornOauth2.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class JpaInitialize {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    void init() {
        Authority read = Authority.builder().name("read").build();
        Authority write = Authority.builder().name("write").build();
        Authority update = Authority.builder().name("update").build();
        Authority delete = Authority.builder().name("delete").build();

        authorityRepository.saveAll(List.of(read, write, update, delete));

        User admin = User.builder()
                .uuid(UUID.randomUUID().toString())
                .username("admin")
                .email("admin@localhost.com")
                .password(passwordEncoder.encode("123"))
                .familyName("admin")
                .givenName("admin")
                .gender("Male")
                .jobTitle("IT Manger")
                .dob(LocalDate.of(1998, 8, 4))
                .authorities(Set.of(read, write, update, delete)).build();


        User kangchi = User.builder()
                .uuid(UUID.randomUUID().toString())
                .username("senglorn")
                .email("senglorn@localhost.com")
                .password(passwordEncoder.encode("123"))
                .familyName("ly")
                .givenName("senglorn")
                .gender("Male")
                .jobTitle("IT Developer")
                .dob(LocalDate.of(2001, 03, 26))
                .authorities(Set.of(read, write)).build();
        userRepository.save(admin);
        userRepository.save(kangchi);
    }
}
