package testApi.task2;

import org.json.JSONArray;
import org.json.JSONObject;
import testApi.Request;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class Task2 extends Request {

    private String getPostsByUserId(int userId) {
        String URLGetPosts = "https://jsonplaceholder.typicode.com/users/" + userId + "/posts";
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(URLGetPosts))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = doRequest(httpRequest);
        return response.body();
    }

    private int getMaxIdPosts(String posts) {
        int maxId = 0;
        JSONArray jsonArray = new JSONArray(posts);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonobject = jsonArray.getJSONObject(i);
            maxId = jsonobject.getInt("id");
        }
        return maxId;
    }

    private String getComments(int postsId) {
        String url = "https://jsonplaceholder.typicode.com/posts/" + postsId + "/comments";
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = doRequest(httpRequest);
        return response.body();
    }

    private void writeInFile(String comments, int userId, int numberPost) {
        File file = new File("user-" + userId + "-post-" + numberPost + "-comments.json");

        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(comments);
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getCommentsForLastPostAndWriteFile(int userId) {
        String posts = getPostsByUserId(userId);
        int numberPost = getMaxIdPosts(posts);
        String comments = getComments(numberPost);
        System.out.println(comments);
        writeInFile(comments, userId, numberPost);
    }
}
