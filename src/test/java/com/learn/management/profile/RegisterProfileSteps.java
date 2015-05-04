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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class RegisterProfileSteps {

    private final Integer validMediaId = 1;
    private final String validMediaName = "MediaName";
    private final String validMediaExtension = "JPG";
    private final byte[] validMediaBytes = validMediaName.getBytes();
    private final Integer validUserId = 1;
    private final String validUserFirstName = "FirstName";
    private final String validUserEmail = "email@email.com";
    private ProfileManagement profileManagement;
    private Profile testProfile;
    private Exception exception;

    public RegisterProfileSteps() {
        UserService userService = mock(UserService.class);
        MediaService mediaService = mock(MediaService.class);
        profileManagement = new DefaultProfileManagement();
        ((DefaultProfileManagement) profileManagement).setUserService(userService);
        ((DefaultProfileManagement) profileManagement).setMediaService(mediaService);
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
        return UserBusinessObject.newBuilder()
                .userId(validUserId)
                .userFirstName(validUserFirstName)
                .userEmail(validUserEmail)
                .build();
    }

    private Media buildValidMedia() {
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

    @Given("valid profile information without media")
    public void createValidProfileWithoutMedia() {
        testProfile = Profile.newBuilder()
                .user(
                        UserBusinessObject.newBuilder()
                                .userFirstName(validUserFirstName)
                                .userEmail(validUserEmail)
                                .build()
                ).build();
    }

    @When("I register this profile")
    public void registerValidProfileWithoutMedia() {
        profileManagement.registerProfile(testProfile);
    }

    @Then("profile should be saved successfully")
    public void checkIsTheValidProfileWithoutMediaSaved() {
        assertThat(buildValidProfileWithoutMedia(), equalTo(testProfile));
    }

    @Given("valid profile information with valid media")
    public void createValidProfileWithMedia() {
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

    @When("I register this profile")
    public void registerValidProfileWithMedia() {
        profileManagement.registerProfile(testProfile);
    }

    @Then("profile should be saved successfully")
    public void checkIsTheValidProfileWithMediaSaved() {
        assertThat(buildValidProfileWithMedia(), equalTo(testProfile));
    }

    @Given("profile information with missing profile first name")
    public void createProfileWithMissingUserFirstName() {
        testProfile = Profile.newBuilder()
                .user(
                        UserBusinessObject.newBuilder()
                                .userEmail(validUserEmail)
                                .build()
                )
                .build();
    }

    @When("I register this profile")
    public void registerProfileWithMissingUserFirstName() {
        try {
            profileManagement.registerProfile(testProfile);
        } catch (Exception ex) {
            exception = ex;
        }
    }

    @Then("$exceptionClassName should be thrown")
    public void checkIsTheProfileWithMissingUserFirstNameThrowsException(String exceptionClassName) throws ClassNotFoundException {
        Class<?> exceptionClass = Class.forName(exceptionClassName);
        if (exception != null && exceptionClass.isInstance(exception)) {
            exception = null;
        } else {
            fail();
        }
    }

    @Given("profile information with missing profile email")
    public void createProfileWithMissingUserEmail() {
        testProfile = Profile.newBuilder()
                .user(
                        UserBusinessObject.newBuilder()
                                .userFirstName(validUserFirstName)
                                .build()
                )
                .build();
    }

    @When("I register this profile")
    public void registerProfileWithMissingUserEmail() {
        try {
            profileManagement.registerProfile(testProfile);
        } catch (Exception ex) {
            exception = ex;
        }
    }

    @Then("$exceptionClassName should be thrown")
    public void checkIsTheProfileWithMissingUserEmailThrowsException(String exceptionClassName) throws ClassNotFoundException {
        Class<?> exceptionClass = Class.forName(exceptionClassName);
        if (exception != null && exceptionClass.isInstance(exception)) {
            exception = null;
        } else {
            fail();
        }
    }

    @Given("valid profile information with missing media name")
    public void createProfileWithValidUserAndMissingMediaName() {
        testProfile = Profile.newBuilder()
                .user(
                        UserBusinessObject.newBuilder()
                                .userFirstName(validUserFirstName)
                                .userEmail(validUserEmail)
                                .build()
                ).media(
                        MediaBusinessObject.newBuilder()
                                .mediaExtension(validMediaExtension)
                                .mediaBytes(validMediaBytes)
                                .build()
                )
                .build();
    }

    @When("I register this profile")
    public void registerProfileWithValidUserAndMissingMediaName() {
        try {
            profileManagement.registerProfile(testProfile);
        } catch (Exception ex) {
            exception = ex;
        }
    }

    @Then("$exceptionClassName should be thrown")
    public void checkIsTheProfileWithValidUserAndMissingMediaNameThrowsException(String exceptionClassName) throws ClassNotFoundException {
        Class<?> exceptionClass = Class.forName(exceptionClassName);
        if (exception != null && exceptionClass.isInstance(exception)) {
            exception = null;
        } else {
            fail();
        }
    }

    @Given("valid profile information with missing media extension")
    public void createProfileWithValidUserAndMissingMediaExtention() {
        testProfile = Profile.newBuilder()
                .user(
                        UserBusinessObject.newBuilder()
                                .userFirstName(validUserFirstName)
                                .userEmail(validUserEmail)
                                .build()
                ).media(
                        MediaBusinessObject.newBuilder()
                                .mediaName(validMediaName)
                                .mediaBytes(validMediaBytes)
                                .build()
                )
                .build();
    }

    @When("I register this profile")
    public void registerProfileWithValidUserAndMissingMediaExtention() {
        try {
            profileManagement.registerProfile(testProfile);
        } catch (Exception ex) {
            exception = ex;
        }
    }

    @Then("$exceptionClassName should be thrown")
    public void checkIsTheProfileWithValidUserAndMissingMediaExtentionThrowsException(String exceptionClassName) throws ClassNotFoundException {
        Class<?> exceptionClass = Class.forName(exceptionClassName);
        if (exception != null && exceptionClass.isInstance(exception)) {
            exception = null;
        } else {
            fail();
        }
    }

    @Given("valid profile information with missing media bytes")
    public void createProfileWithValidUserAndMissingMediaBytes() {
        testProfile = Profile.newBuilder()
                .user(
                        UserBusinessObject.newBuilder()
                                .userFirstName(validUserFirstName)
                                .userEmail(validUserEmail)
                                .build()
                ).media(
                        MediaBusinessObject.newBuilder()
                                .mediaName(validMediaName)
                                .mediaExtension(validMediaExtension)
                                .build()
                )
                .build();
    }

    @When("I register this profile")
    public void registerProfileWithValidUserAndMissingMediaBytes() {
        try {
            profileManagement.registerProfile(testProfile);
        } catch (Exception ex) {
            exception = ex;
        }
    }

    @Then("$exceptionClassName should be thrown")
    public void checkIsTheProfileWithValidUserAndMissingMediaBytesThrowsException(String exceptionClassName) throws ClassNotFoundException {
        Class<?> exceptionClass = Class.forName(exceptionClassName);
        if (exception != null && exceptionClass.isInstance(exception)) {
            exception = null;
        } else {
            fail();
        }
    }

}
