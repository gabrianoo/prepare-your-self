package com.learn.management.profile;

import com.learn.service.media.Media;
import com.learn.service.media.MediaBusinessObject;
import com.learn.service.media.MediaService;
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

@Named
public class DefaultProfileManagementRegisterProfileSteps {

    private final String validMediaName = "MediaName";
    private final String validMediaExtension = "JPG";
    private final byte[] validMediaBytes = validMediaName.getBytes();
    private final String validUserFirstName = "FirstName";
    private final String validUserEmail = "email@email.com";
    @Inject
    @Named("defaultProfileManagement")
    private ProfileManagement profileManagement;
    private Profile testProfile;
    private Exception exception;
    @Inject
    private UserService userService;
    @Inject
    private MediaService mediaService;

    @PostConstruct
    public void initializeDefaultProfileManagementRegisterProfileSteps() {
        doReturn(buildValidUser()).
                when(userService).createUser(
                UserBusinessObject.newBuilder()
                        .userFirstName(validUserFirstName)
                        .userEmail(validUserEmail)
                        .build()
        );
        doReturn(buildValidMedia()).
                when(mediaService).createMedia(
                MediaBusinessObject.newBuilder()
                        .mediaName(validMediaName)
                        .mediaExtension(validMediaExtension)
                        .mediaBytes(validMediaBytes)
                        .build()
        );
    }

    private User buildValidUser() {
        final Integer validUserId = 1;
        return UserBusinessObject.newBuilder()
                .userId(validUserId)
                .userFirstName(validUserFirstName)
                .userEmail(validUserEmail)
                .build();
    }

    private Media buildValidMedia() {
        final Integer validMediaId = 1;
        return MediaBusinessObject.newBuilder()
                .mediaId(validMediaId)
                .mediaName(validMediaName)
                .mediaExtension(validMediaExtension)
                .mediaBytes(validMediaBytes)
                .build();
    }

    private Profile buildValidProfileWithMedia() {
        return Profile.newBuilder()
                .user(buildValidUser())
                .media(buildValidMedia())
                .build();
    }

    private Profile buildValidProfileWithoutMedia() {
        return Profile.newBuilder()
                .user(buildValidUser())
                .build();
    }

    @Given("valid user and no media for profile register")
    public void validUserAndNoMediaForProfileRegister() {
        testProfile = Profile.newBuilder()
                .user(
                        UserBusinessObject.newBuilder()
                                .userFirstName(validUserFirstName)
                                .userEmail(validUserEmail)
                                .build()
                ).build();
    }

    @When("register profile with valid user and no media")
    public void registerProfileWithValidUserAndNoMedia() {
        profileManagement.registerProfile(testProfile);
    }

    @Then("profile with valid user and no media registered")
    public void profileWithValidUserAndNoMediaRegistered() {
        assertThat(buildValidProfileWithoutMedia(), equalTo(testProfile));
    }

    @Given("no user and valid media for profile register")
    public void noUserAndValidMediaForProfileRegister() {
        testProfile = Profile.newBuilder()
                .media(
                        MediaBusinessObject.newBuilder()
                                .mediaName(validMediaName)
                                .mediaExtension(validMediaExtension)
                                .mediaBytes(validMediaBytes)
                                .build()
                ).build();
    }

    @When("register profile with no user and valid media")
    public void registerProfileWithNoUserAndValidMedia() {
        try {
            profileManagement.registerProfile(testProfile);
        } catch (Exception ex) {
            exception = ex;
        }
    }

    @Then("$exceptionClassName should be thrown for missing user")
    public void exceptionShouldBeThrownForMissingUser(String exceptionClassName) throws ClassNotFoundException {
        Class<?> exceptionClass = Class.forName(exceptionClassName);
        if (exception != null && exceptionClass.isInstance(exception)) {
            exception = null;
        } else {
            fail();
        }
    }

    @Given("valid user and valid media for profile register")
    public void validUserAndValidMediaForProfileRegister() {
        testProfile = Profile.newBuilder()
                .user(
                        UserBusinessObject.newBuilder()
                                .userFirstName(validUserFirstName)
                                .userEmail(validUserEmail)
                                .build()
                )
                .media(
                        MediaBusinessObject.newBuilder()
                                .mediaName(validMediaName)
                                .mediaExtension(validMediaExtension)
                                .mediaBytes(validMediaBytes)
                                .build()
                ).build();
    }

    @When("register profile with valid user and valid media")
    public void registerProfileWithValidUserAndValidMedia() {
        profileManagement.registerProfile(testProfile);
    }

    @Then("profile with valid user and valid media registered")
    public void profileWithValidUserAndValidMediaRegistered() {
        assertThat(buildValidProfileWithMedia(), equalTo(testProfile));
    }
}
