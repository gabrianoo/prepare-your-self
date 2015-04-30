package com.learn.management.profile;

import com.learn.service.media.Media;
import com.learn.service.media.MediaBusinessObject;
import com.learn.service.user.User;
import com.learn.service.user.UserBusinessObject;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class RegisterProfileSteps {

    private static final Integer validMediaId = 1;
    private static final String validMediaName = "MediaName";
    private static final String validMediaExtension = "JPG";
    private static final byte[] validMediaBytes = validMediaName.getBytes();
    private static final Integer validUserId = 1;
    private static final String validUserFirstName = "FirstName";
    private static final String validUserEmail = "email@email.com";
    private ProfileManagement profileManagement = new DefaultProfileManagement();
    private Profile testProfile;

    private static User buildValidUser() {
        return UserBusinessObject.newBuilder()
                .userId(validUserId)
                .userFirstName(validUserFirstName)
                .userEmail(validUserEmail)
                .build();
    }

    private static Media buildValidMedia() {
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
    public void initializeValidProfileInfromation() {
        testProfile = buildValidProfileWithoutMedia();
    }

    @When("I register this profile")
    public void registerTheValidProfileInfromation() {
        profileManagement.registerProfile(testProfile);
    }

    @Then("profile should be saved successfully")
    public void checkIsTheValidProfileSaved() {

    }

//    @Given("profile information with missing profile first name")
//    @When("I register this profile")
//    @Then("IllegalArgumentException should be thrown")
//
//    @Given("profile information with missing profile email")
//    @When("I register this profile")
//    @Then("IllegalArgumentException should be thrown")
//
//    @Given("valid profile information with invalid media name")
//    @When("I register this profile")
//    @Then("IllegalArgumentException should be thrown")
//
//    @Given("valid profile information with invalid media extension")
//    @When("I register this profile")
//    @Then("IllegalArgumentException should be thrown")
//
//    @Given("valid profile information with invalid media bytes")
//    @When("I register this profile")
//    @Then("IllegalArgumentException should be thrown")
//
//    @Given("valid profile information with valid media")
//    @When("I register this profile")
//    @Then("profile should be saved successfully")


}
