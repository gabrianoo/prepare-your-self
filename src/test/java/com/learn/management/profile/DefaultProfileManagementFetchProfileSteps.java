package com.learn.management.profile;

import com.learn.service.user.User;
import com.learn.service.user.UserBusinessObject;
import com.learn.service.user.UserService;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

@Named
public class DefaultProfileManagementFetchProfileSteps {

    private final Integer validUserId = 1;
    private final Integer missingUserId = null;
    private final Integer inValidUserId = 2;
    private Exception exception;
    final String validUserFirstName = "FirstName";
    final String validUserEmail = "email@email.com";
    @Inject
    @Named("defaultProfileManagement")
    private ProfileManagement profileManagement;
    private Integer testProfileUserId;
    private Profile testProfile;
    @Inject
    private UserService userService;

    @PostConstruct
    public void initializeDefaultProfileManagementFetchingProfileSteps() {
        doReturn(buildValidUser()).
                when(userService).readUser(validUserId);
        doThrow(IllegalArgumentException.class)
                .when(userService).readUser(inValidUserId);
        doThrow(IllegalArgumentException.class)
                .when(userService).readUser(missingUserId);
    }

    private User buildValidUser() {
        return UserBusinessObject.newBuilder()
                .userId(validUserId)
                .userFirstName(validUserFirstName)
                .userEmail(validUserEmail)
                .build();
    }

    private Profile buildValidProfileWithoutMedia() {
        return Profile.newBuilder()
                .user(
                        buildValidUser()
                ).build();
    }

    @Given("valid user id for fetching")
    public void validUserIdForFetching() {
        testProfileUserId = 1;
    }

    @When("fetching profile with valid user id")
    public void fetchingProfileWithValidUserId() {
        testProfile = profileManagement.fetchProfile(testProfileUserId);
    }

    @Then("profile with valid user id fetched")
    public void profileWithValidUserIdFetched() {
        assertThat(buildValidProfileWithoutMedia(), equalTo(testProfile));
    }

    @Given("missing user id for fetching")
    public void missingUserIdForFetching() {
        testProfileUserId = missingUserId;
    }

    @When("fetching profile with missing user id")
    public void fetchingProfileWithMissingUserId() {
        try {
            profileManagement.unRegisterProfile(testProfileUserId);
        } catch (Exception ex) {
            exception = ex;
        }
    }

    @Then("$exceptionClassName should be thrown for missing user id when fetching")
    public void exceptionShouldBeThrownForMissingUserIdWhenFetching(String exceptionClassName) throws ClassNotFoundException {
        Class<?> exceptionClass = Class.forName(exceptionClassName);
        if (exception != null && exceptionClass.isInstance(exception)) {
            exception = null;
        } else {
            fail();
        }
    }

    @Given("invalid user id for fetching")
    public void invalidUserIdForFetching() {
        testProfileUserId = inValidUserId;
    }

    @When("fetching profile with invalid user id")
    public void fetchingProfileWithInvalidUserId() {
        try {
            profileManagement.unRegisterProfile(testProfileUserId);
        } catch (Exception ex) {
            exception = ex;
        }
    }

    @Then("$exceptionClassName should be thrown for invalid user id when fetching")
    public void exceptionShouldBeThrownForInvalidUserIdWhenFetching(String exceptionClassName) throws ClassNotFoundException {
        Class<?> exceptionClass = Class.forName(exceptionClassName);
        if (exception != null && exceptionClass.isInstance(exception)) {
            exception = null;
        } else {
            fail();
        }
    }
}
