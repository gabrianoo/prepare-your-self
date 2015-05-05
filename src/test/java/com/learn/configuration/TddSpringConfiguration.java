package com.learn.configuration;

import com.learn.service.media.MediaRepository;
import com.learn.service.user.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Mockito.mock;

@Configuration
@ComponentScan(basePackages = "com.learn")
public class TddSpringConfiguration {

    @Bean
    public MediaRepository getMediaRepository() {
        return mock(MediaRepository.class);
    }

    @Bean
    public UserRepository getUserRepository() {
        return mock(UserRepository.class);
    }
}
