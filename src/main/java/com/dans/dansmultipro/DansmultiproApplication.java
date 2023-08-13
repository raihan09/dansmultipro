package com.dans.dansmultipro;

import com.dans.dansmultipro.model.UserProfile;
import com.dans.dansmultipro.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@EnableJpaRepositories
@EnableTransactionManagement
public class DansmultiproApplication {
    @Autowired
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private UserProfileRepository userProfileRepository;

    public DansmultiproApplication(PasswordEncoder passwordEncoder, UserProfileRepository userProfileRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userProfileRepository = userProfileRepository;
    }
//init data user
    @PostConstruct
    private void initUser() {
        List<UserProfile> users = Stream.of(
                new UserProfile(1,"user1", passwordEncoder.encode("password1"))).collect(Collectors.toList());
        userProfileRepository.saveAll(users);
    }

    public static void main(String[] args) {
        SpringApplication.run(DansmultiproApplication.class, args);
    }

}
