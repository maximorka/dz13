package testApi.task1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import testApi.Request;
import testApi.User;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;



public class Task1 extends Request {

    /* 1.1 Create Users  */
    public void createNewUser(User user) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(user);

        String URLCreate = "https://jsonplaceholder.typicode.com/users";
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(URLCreate))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response = doRequest(httpRequest);
        System.out.println("response.body().toString() = " + response.body());
    }
    /* 1.2 Update Users  */
    public void updateUser(User user) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(user);

        String URLUpdate = "https://jsonplaceholder.typicode.com/users/1";
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(URLUpdate))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response = doRequest(httpRequest);
        System.out.println("response.body().toString() = " + response.body());
    }



    /* 1.3 Delete Users  */
    public void deleteUser(int userId) {
        String URLDelete = "https://jsonplaceholder.typicode.com/users/"+userId;
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(URLDelete))
                .header("Content-Type", "application/json")
                .DELETE()
                .build();

        HttpResponse<String> response = doRequest(httpRequest);
        System.out.println("response.body().toString() = " + response.body());
    }

    /* 1.4 Get information about all Users  */
    public void getInfAbAllUsers() {
        String URLGetAllUsers = "https://jsonplaceholder.typicode.com/users";
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(URLGetAllUsers))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = doRequest(httpRequest);
        System.out.println("response.body().toString() = " + response.body());
    }

    /* 1.5 Get information about User for id  */
    public void getInfAbUserForId(int userId) {
        String URLGetUserForId = "https://jsonplaceholder.typicode.com/users?id="+userId;
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(URLGetUserForId))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = doRequest(httpRequest);
        System.out.println("response.body().toString() = " + response.body());
    }

    /* 1.6 Get information about User for username  */
    public void getInfAbUserForUserName(String userName) {

        String URLGetUserForUserName = "https://jsonplaceholder.typicode.com/users?username="+userName;
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(URLGetUserForUserName))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = doRequest(httpRequest);
        System.out.println("response.body().toString() = " + response.body());
    }

}
