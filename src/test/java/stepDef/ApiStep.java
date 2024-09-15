package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ApiPage;

public class ApiStep {

    ApiPage apiPage;

    public ApiStep() {
        this.apiPage = new ApiPage();
    }

    @Given("prepare url for {string}")
    public void prepareUrlFor(String url) {
        apiPage.prepareUrlFor(url);
    }

    @And("hit API get list users")
    public void hitAPIGetListData() {
        apiPage.hitAPIGetListData();
    }

    @Then("validation response status code equals to {int}")
    public void statusIs(int status_code) {
        apiPage.statusIs(status_code);
    }

    @Then("validation response body get list users")
    public void messageIsSuccess() {
        apiPage.messageIsSuccess();
    }

    @Then("validation response json with JSONSchema {string}")
    public void validationResponseJSON(String filename) {
        apiPage.validationResponseJSON(filename);
    }

    @And("hit API post create user")
    public void hitAPIPostCreateUser() {
        apiPage.hitAPIPostCreateUser();
    }

    @Then("validation response body post create new user")
    public void validationResponseBodyPostCreateNewUser() {
        apiPage.validationResponseBodyCreateUser();
    }

    @And("hit API delete user")
    public void hitAPIDeleteUser() {
        apiPage.hitAPIDeleteUser();
    }

    @And("hit API update user")
    public void hitAPIUpdateUser() {
        apiPage.hitAPIUpdateUser();
    }

    @Then("validation response body update user")
    public void validationResponseBodyUpdateUser() {
        apiPage.validationResponseBodyUpdateUser();
    }

    @And("hit API get user details")
    public void hitAPIGetUserDetails() {
        apiPage.hitAPIGetUserDetails();
    }

    @Then("validation response body get user details")
    public void validationResponseBodyGetUserDetails() {
        apiPage.validationResponseBodyGetUserDetails();
    }

    @And("hit API get user posts")
    public void hitAPIGetUserPosts() {
        apiPage.hitAPIGetUserPosts();
    }

    @Then("validation response body get user posts")
    public void validationResponseBodyGetUserPosts() {
        apiPage.validationResponseBodyGetUserPosts();
    }

    @And("hit API post user posts")
    public void hitAPIPostUserPosts() {
        apiPage.hitAPIPostUserPosts();
    }

    @Then("validation response body post user posts")
    public void validationResponseBodyPostUserPosts() {
        apiPage.validationResponseBodyPostUserPosts();
    }

    @And("hit API get user todo")
    public void hitAPIGetUserTodo() {
        apiPage.hitAPIGetUserTodo();
    }

    @And("hit API post user todo")
    public void hitAPIPostUserTodo() {
        apiPage.hitAPIPostUserTodo();
    }

    @Then("validation response body get user todo")
    public void validationResponseBodyGetUserTodo() {
        apiPage.validationResponseGetBodyUserTodos();
    }

    @Then("validation response body post user todo")
    public void validationResponseBodyPostUserTodo() {
        apiPage.validationResponsePostBodyUserTodos();
    }

    @Then("hit API post user comment")
    public void hitAPIPostUserComment() {
        apiPage.hitAPIPostUserComment();
    }

    @Then("validation response body post user comment")
    public void validationResponseBodyPostUserComment() {
        apiPage.validationResponseBodyPostUserComment();
    }

    @Then("hit API get user comment")
    public void hitAPIGetUserComment() {
        apiPage.hitAPIGetPostComment();
    }

    @Then("validation response body get user comment")
    public void validationResponseBodyGetUserComment() {
        apiPage.validationResponseBodyGetUserComment();
    }
}
