package com.learn.management.profile;

import com.learn.service.user.UserService;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import static org.mockito.Mockito.*;

@Named
public class DefaultProfileManagementDeleteProfileSteps {

    private final Integer validUserId = 1;
    private Integer testProfileUserId;
    @Inject
    @Named("defaultProfileManagement")
    private ProfileManagement profileManagement;
    @Inject
    private UserService userService;

    @PostConstruct
    public void initializeDefaultProfileManagementUnRegisterProfileSteps() {
        doNothing()
                .when(userService).deleteUser(validUserId);
    }

    @Given("valid user id for un registering")
    public void validUserForUnRegistering() {
        testProfileUserId = 1;
    }

    @When("un registering profile with valid user id")
    public void unRegisteringProfileWithValidUserId() {
        profileManagement.unRegisterProfile(testProfileUserId);
    }

    @Then("profile with valid user id un registered")
    public void profileWithValidUserIdUnRegistered() {
        verify(userService, times(1)).deleteUser(validUserId);
    }
}
