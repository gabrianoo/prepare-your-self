package com.learn.configuration;

import com.learn.service.media.DefaultMediaService;
import com.learn.service.media.MediaService;
import com.learn.service.user.DefaultUserService;
import com.learn.service.user.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.mockito.Mockito.mock;

@Configuration
@ComponentScan(basePackages = "com.learn",
        excludeFilters = {
                @ComponentScan.Filter(value = DefaultMediaService.class, type = FilterType.ASSIGNABLE_TYPE),
                @ComponentScan.Filter(value = DefaultUserService.class, type = FilterType.ASSIGNABLE_TYPE),
                @ComponentScan.Filter(value = TddSpringConfiguration.class, type = FilterType.ASSIGNABLE_TYPE)
        })
public class BddSpringConfiguration {

    @Bean
    public MediaService getMediaService() {
        return mock(MediaService.class);
    }

    @Bean
    public UserService getUserService() {
        return mock(UserService.class);
    }
}