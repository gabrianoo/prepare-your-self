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
import static org.mockito.Mockito.doReturn;

@Named
public class DefaultProfileManagementUpdateProfileSteps {

    private final Integer validMediaId = 1;
    private final String validMediaName = "MediaName";
    private final String validMediaExtension = "JPG";
    private final byte[] validMediaBytes = validMediaName.getBytes();
    private final Integer validUserId = 1;
    private final String validUserFirstName = "FirstName";
    private final String validUserEmail = "email@email.com";
    @Inject
    @Named("defaultProfileManagement")
    private ProfileManagement profileManagement;
    private Profile testProfile;
    @Inject
    private UserService userService;
    @Inject
    private MediaService mediaService;

    @PostConstruct
    public void initializeDefaultProfileManagementUpdateProfileSteps() {
        doReturn(buildValidUser()).
                when(userService).updateUser(
                UserBusinessObject.newBuilder()
                        .userId(validUserId)
                        .userFirstName(validUserFirstName)
                        .userEmail(validUserEmail)
                        .build()
        );
        doReturn(buildValidMedia()).
                when(mediaService).updateMedia(
                MediaBusinessObject.newBuilder()
                        .mediaId(validMediaId)
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

    @Given("valid user and no media for profile update")
    public void givenValidUserAndNoMediaForProfileUpdate() {
        testProfile = Profile.newBuilder()
                .user(
                        UserBusinessObject.newBuilder()
                                .userId(validUserId)
                                .userFirstName(validUserFirstName)
                                .userEmail(validUserEmail)
                                .build()
                ).build();
    }

    @When("update profile with valid user and no media")
    public void whenUpdateProfileWithValidUserAndNoMedia() {
        profileManagement.updateProfile(testProfile);
    }

    @Then("profile with valid user and no media updated")
    public void thenProfileWithValidUserAndNoMediaUpdated() {
        assertThat(buildValidProfileWithoutMedia(), equalTo(testProfile));
    }

    @Given("no user and valid media for profile update")
    public void givenNoUserAndValidMediaForProfileUpdate() {
        testProfile = Profile.newBuilder()
                .media(
                        MediaBusinessObject.newBuilder()
                                .mediaId(validMediaId)
                                .mediaName(validMediaName)
                                .mediaExtension(validMediaExtension)
                                .mediaBytes(validMediaBytes)
                                .build()
                )
                .build();
    }

    @When("update profile with no user and valid media")
    public void whenUpdateProfileWithNoUserAndValidMedia() {
        profileManagement.updateProfile(testProfile);
    }

    @Then("profile with no user and valid media updated")
    public void thenProfileWithNoUserAndValidMediaUpdated() {
        assertThat(buildValidProfileWithoutMedia(), equalTo(testProfile));
    }

    @Given("valid user and valid media for profile update")
    public void givenValidUserAndValidMediaForProfileUpdate() {
        testProfile = Profile.newBuilder()
                .user(
                        UserBusinessObject.newBuilder()
                                .userId(validUserId)
                                .userFirstName(validUserFirstName)
                                .userEmail(validUserEmail)
                                .build()
                ).media(
                        MediaBusinessObject.newBuilder()
                                .mediaId(validMediaId)
                                .mediaName(validMediaName)
                                .mediaExtension(validMediaExtension)
                                .mediaBytes(validMediaBytes)
                                .build()
                )
                .build();
    }

    @When("update profile with valid user and valid media")
    public void whenUpdateProfileWithValidUserAndValidMedia() {
        profileManagement.updateProfile(testProfile);
    }

    @Then("profile with valid user and valid media updated")
    public void thenProfileWithValidUserAndValidMediaUpdated() {
        assertThat(buildValidProfileWithoutMedia(), equalTo(testProfile));
    }

}
