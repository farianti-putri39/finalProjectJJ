package pages;

import helper.Endpoint;
import helper.Utility;
import io.cucumber.java.en.And;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.openqa.selenium.json.Json;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static helper.Models.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ApiPage {

    String setURL, global_id, post_id, global_name, global_email;
    Response res;;

    public void prepareUrlFor(String url){
        switch (url) {
            case "GET_LIST_USERS" :
                setURL = Endpoint.GET_LIST_USERS;
                break;
            case "CREATE_USER" :
                setURL = Endpoint.CREATE_USER;
                break;
            case "DELETE_USER" :
                setURL = Endpoint.DELETE_USER;
                break;
            case "CREATE_POST_COMMENT" :
                setURL = Endpoint.CREATE_POST_COMMENT;
                break;
            default:
                System.out.println("input correct URL");
        }
        System.out.println("Endpoint: "+setURL);
    }

    public void hitAPIGetListData() {
        res = getListUsers(setURL);
    }

    public void hitAPIPostCreateUser() {
        res = postCreateUser(setURL);
    }

    public void statusIs(int status_code) {
        assertThat(res.statusCode()).isEqualTo(status_code);
    }

    public void messageIsSuccess() {
        List<Object> id = res.jsonPath().getList("id");
        List<Object> name = res.jsonPath().getList("name");
        List<Object> email = res.jsonPath().getList("email");
        List<Object> gender = res.jsonPath().getList("gender");
        List<Object> status = res.jsonPath().getList("status");

        assertThat(id.get(0)).isNotNull();
        assertThat(name.get(0)).isNotNull();
        assertThat(email.get(0)).isNotNull();
        assertThat(gender.get(0)).isIn("female","male");
        assertThat(status.get(0)).isIn("active","inactive");
    }

    public void validationResponseJSON(String filename) {
        File JSONFile = Utility.getJSONSchemaFile(filename);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }

    public void validationResponseBodyCreateUser() {
        JsonPath jsonPathEvaluator = res.jsonPath();
        Integer id = jsonPathEvaluator.get("id");
        String name = jsonPathEvaluator.get("name");
        String email = jsonPathEvaluator.get("email");
        String gender = jsonPathEvaluator.get("gender");
        String status = jsonPathEvaluator.get("status");

        assertThat(id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("female","male");
        assertThat(status).isIn("active","inactive");

        global_id = Integer.toString(id);
        global_name = name;
        global_email = email;
    }

    public void hitAPIDeleteUser() {
        res = deleteUser(setURL, global_id);
    }

    public void hitAPIUpdateUser() {
        res = updateUser(setURL, global_id);
    }

    public void validationResponseBodyUpdateUser() {
        JsonPath jsonPathEvaluator = res.jsonPath();
        Integer id = jsonPathEvaluator.get("id");
        String name = jsonPathEvaluator.get("name");
        String email = jsonPathEvaluator.get("email");
        String gender = jsonPathEvaluator.get("gender");
        String status = jsonPathEvaluator.get("status");

        assertThat(id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("female","male");
        assertThat(status).isIn("active","inactive");
    }

    public void validationResponseBodyGetUserDetails() {
        JsonPath jsonPathEvaluator = res.jsonPath();
        Integer id = jsonPathEvaluator.get("id");
        String name = jsonPathEvaluator.get("name");
        String email = jsonPathEvaluator.get("email");
        String gender = jsonPathEvaluator.get("gender");
        String status = jsonPathEvaluator.get("status");

        assertThat(id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("female","male");
        assertThat(status).isIn("active","inactive");
    }

    public void hitAPIGetUserDetails() {
        res = getUserDetails(setURL, global_id);
    }

    public void hitAPIGetUserPosts() {
        res = getUserPosts(setURL, global_id);
    }

    public void validationResponseBodyGetUserPosts() {
        JsonPath jsonPathEvaluator = res.jsonPath();
        ArrayList id = jsonPathEvaluator.get("id");
        ArrayList user_id = jsonPathEvaluator.get("user_id");
        ArrayList title = jsonPathEvaluator.get("title");
        ArrayList body = jsonPathEvaluator.get("body");

        assertThat(id).isNotNull();
        assertThat(user_id).isNotNull();
        assertThat(title).isNotNull();
        assertThat(body).isNotNull();
    }

    public void hitAPIPostUserPosts() {
        res = postUserPosts(setURL, global_id);
    }

    public void validationResponseBodyPostUserPosts() {
        JsonPath jsonPathEvaluator = res.jsonPath();
        Integer id = jsonPathEvaluator.get("id");
        Integer user_id = jsonPathEvaluator.get("user_id");
        String title = jsonPathEvaluator.get("title");
        String body = jsonPathEvaluator.get("body");

        assertThat(id).isNotNull();
        assertThat(user_id).isNotNull();
        assertThat(title).isNotNull();
        assertThat(body).isNotNull();

        post_id = Integer.toString(id);
    }

    public void hitAPIGetUserTodo() {
        res = getUserTodos(setURL, global_id);
    }

    public void hitAPIPostUserTodo() {
        res = postUserTodos(setURL, global_id);
    }

    public void validationResponseGetBodyUserTodos() {
        JsonPath jsonPathEvaluator = res.jsonPath();
        ArrayList id = jsonPathEvaluator.get("id");
        ArrayList user_id = jsonPathEvaluator.get("user_id");
        ArrayList title = jsonPathEvaluator.get("title");
        ArrayList status = jsonPathEvaluator.get("status");
        ArrayList due_on = jsonPathEvaluator.get("due_on");

        assertThat(id).isNotNull();
        assertThat(user_id).isNotNull();
        assertThat(title).isNotNull();
        assertThat(status).isNotNull();
        assertThat(due_on).isNotNull();
    }

    public void validationResponsePostBodyUserTodos() {
        JsonPath jsonPathEvaluator = res.jsonPath();
        Integer id = jsonPathEvaluator.get("id");
        Integer user_id = jsonPathEvaluator.get("user_id");
        String title = jsonPathEvaluator.get("title");
        String status = jsonPathEvaluator.get("status");
        String due_on = jsonPathEvaluator.get("due_on");

        assertThat(id).isNotNull();
        assertThat(user_id).isNotNull();
        assertThat(title).isNotNull();
        assertThat(status).isNotNull();
        assertThat(due_on).isNotNull();
    }

    public void hitAPIPostUserComment() {
        res = postUserComment(setURL, global_id, post_id, global_name, global_email);
    }

    public void hitAPIGetPostComment() {
        res = getPostComment(setURL, global_id);
    }

    public void validationResponseBodyGetUserComment() {
        JsonPath jsonPathEvaluator = res.jsonPath();
        ArrayList id = jsonPathEvaluator.get("id");
        ArrayList post_id = jsonPathEvaluator.get("post_id");
        ArrayList name = jsonPathEvaluator.get("name");
        ArrayList email = jsonPathEvaluator.get("email");
        ArrayList body = jsonPathEvaluator.get("body");

        assertThat(id).isNotNull();
        assertThat(post_id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(body).isNotNull();
    }

    public void validationResponseBodyPostUserComment() {
        JsonPath jsonPathEvaluator = res.jsonPath();
        Integer id = jsonPathEvaluator.get("id");
        Integer post_id = jsonPathEvaluator.get("post_id");
        String name = jsonPathEvaluator.get("name");
        String email = jsonPathEvaluator.get("email");
        String body = jsonPathEvaluator.get("body");

        assertThat(id).isNotNull();
        assertThat(post_id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(body).isNotNull();
    }
}
