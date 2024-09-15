package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.joda.time.DateTime;
import org.json.JSONObject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import static helper.Utility.generateRandomEmail;

public class Models {
    private static RequestSpecification request;
    public static void setupHeaders() {
        request = RestAssured.given()
                .header("Content-Type","application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer 713902dad7f688f3cde9855733b969e184e8df24a5712651bc6cde418187704b");
    }

    public static Response getListUsers(String endpoint){
        setupHeaders();
        return request.when().get(endpoint);
    }

    public static Response postCreateUser(String endpoint){
        String name = "Test User";
        String gender = "female";
        String email = generateRandomEmail();
        String status = "active";

        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);


        setupHeaders();
        return request.body(payload.toString()).when().post(endpoint);
    }

    public static Response deleteUser(String endpoint, String user_id){
        setupHeaders();
        String finalEndpoint = endpoint + "/" + user_id;
        return request.when().delete(finalEndpoint);
    }

    public static Response updateUser(String endpoint, String user_id){
        setupHeaders();

        String name = "Test User Edit";
        String gender = "female";
        String email = generateRandomEmail();
        String status = "active";

        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);

        String finalEndpoint = endpoint + "/" + user_id;
        return request.body(payload.toString()).when().patch(finalEndpoint);
    }

    public static Response getUserDetails(String endpoint, String user_id){
        setupHeaders();
        String finalEndpoint = endpoint + "/" + user_id;
        return request.when().get(finalEndpoint);
    }

    public static Response getUserPosts(String endpoint, String user_id){
        setupHeaders();
        String finalEndpoint = endpoint + "/" + user_id + "/posts" ;
        return request.when().get(finalEndpoint);
    }

    public static Response postUserPosts(String endpoint, String user_id){
        String body = generateRandomEmail();
        String title = generateRandomEmail();

        JSONObject payload = new JSONObject();
        payload.put("body", body);
        payload.put("title", title);

        setupHeaders();
        String finalEndpoint = endpoint + "/" + user_id + "/posts" ;
        return request.body(payload.toString()).when().post(finalEndpoint);
    }

    public static Response getUserTodos(String endpoint, String user_id){
        setupHeaders();
        String finalEndpoint = endpoint + "/" + user_id + "/todos" ;
        return request.when().get(finalEndpoint);
    }

    public static Response postUserTodos(String endpoint, String user_id){
        LocalDateTime due_on = LocalDateTime.now();;
        String title = generateRandomEmail();
        String status = "pending";

        JSONObject payload = new JSONObject();
        payload.put("title", title);
        payload.put("due_on", due_on);
        payload.put("status", status);

        setupHeaders();
        String finalEndpoint = endpoint + "/" + user_id + "/todos" ;
        System.out.println(finalEndpoint);
        return request.body(payload.toString()).when().post(finalEndpoint);
    }

    public static Response postUserComment(String endpoint, String user_id, String post, String name, String email){
        String finalEndpoint = endpoint + "/" + post + "/comments" ;
        System.out.println(finalEndpoint);

        String body = generateRandomEmail();

        JSONObject payload = new JSONObject();
        payload.put("id", user_id);
        payload.put("post_id", post);
        payload.put("name", name);
        payload.put("body", body);
        payload.put("email", email);

        setupHeaders();

        System.out.println(payload);
        System.out.println(request.response().when().post(finalEndpoint));
        return request.body(payload.toString()).when().post(finalEndpoint);
    }


    public static Response getPostComment(String endpoint, String user_id){
        setupHeaders();
        String finalEndpoint = endpoint + "/" + user_id + "/comments" ;
        System.out.println(finalEndpoint);
        System.out.println(request.response().toString());
        return request.when().get(finalEndpoint);
    }

}
