package com.learn.service.user;

import com.learn.configuration.SpringTestConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.doReturn;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringTestConfiguration.class)
public class DefaultUserServiceReadAllUsersTest {

    private final Integer validUserId = 1;
    private final String validUserFirstName = "FirstName";
    private final String validUserEmail = "email@email.com";
    @Inject
    @Named("defaultUserService")
    private UserService userService;
    @Inject
    private UserRepository userRepository;

    private UserEntity buildValidUserEntity() {
        return UserEntity.newBuilder()
                .userId(validUserId)
                .userFirstName(validUserFirstName)
                .userEmail(validUserEmail)
                .build();
    }

    private User buildValidUser() {
        return UserBusinessObject.newBuilder()
                .userId(validUserId)
                .userFirstName(validUserFirstName)
                .userEmail(validUserEmail)
                .build();
    }

    private List<UserEntity> buildValidUserEntityList() {
        List<UserEntity> validUserEntityList = new ArrayList<>();
        validUserEntityList.add(buildValidUserEntity());
        validUserEntityList.add(buildValidUserEntity());
        return validUserEntityList;
    }

    @Test
    public void whenReadAllUserThenAllSystemUsersAreReturned() {
        doReturn(buildValidUserEntityList()).
                when(userRepository).findAll();
        List<User> users = userService.readAllUsers();
        for (User user : users) {
            assertThat(user, equalTo(buildValidUser()));
        }
    }
}
