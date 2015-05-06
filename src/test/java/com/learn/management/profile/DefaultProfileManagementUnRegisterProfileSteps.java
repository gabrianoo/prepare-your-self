package com.learn.management.profile;

import com.learn.service.user.UserService;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

@Named
public class DefaultProfileManagementUnRegisterProfileSteps {

    private final Integer validUserId = 1;
    private final Integer missingUserId = null;
    private final Integer inValidUserId = 1;
    private Integer testProfileUserId;
    private Exception exception;
    @Inject
    @Named("defaultProfileManagement")
    private ProfileManagement profileManagement;
    @Inject
    private UserService userService;

    @PostConstruct
    public void initializeDefaultProfileManagementUnRegisterProfileSteps() {
        doNothing()
                .when(userService).deleteUser(validUserId);
        doThrow(IllegalArgumentException.class)
                .when(userService).deleteUser(inValidUserId);
        doThrow(IllegalArgumentException.class)
                .when(userService).deleteUser(missingUserId);
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

    @Given("missing user id for un registering")
    public void missingUserIdForUnRegistering() {
        testProfileUserId = missingUserId;
    }

    @When("un registering profile with missing user id")
    public void unRegisteringProfileWithMissingUserId() {
        try {
            profileManagement.unRegisterProfile(testProfileUserId);
        } catch (Exception ex) {
            exception = ex;
        }
    }

    @Then("$exceptionClassName should be thrown for missing user id when un register")
    public void exceptionShouldBeThrownForMissingUserIdWhenUnRegister(String exceptionClassName) throws ClassNotFoundException {
        Class<?> exceptionClass = Class.forName(exceptionClassName);
        if (exception != null && exceptionClass.isInstance(exception)) {
            exception = null;
        } else {
            fail();
        }
    }

    @Given("invalid user id for un registering")
    public void invalidUserIdForUnRegistering() {
        testProfileUserId = inValidUserId;
    }

    @When("un registering profile with invalid user id")
    public void unRegisteringProfileWithInvalidUserId() {
        try {
            profileManagement.unRegisterProfile(testProfileUserId);
        } catch (Exception ex) {
            exception = ex;
        }
    }

    @Then("$exceptionClassName should be thrown for invalid user id when un register")
    public void exceptionShouldBeThrownForInvalidUserIdWhenUnRegister(String exceptionClassName) throws ClassNotFoundException {
        Class<?> exceptionClass = Class.forName(exceptionClassName);
        if (exception != null && exceptionClass.isInstance(exception)) {
            exception = null;
        } else {
            fail();
        }
    }
}
