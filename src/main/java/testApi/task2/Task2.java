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


    private  String getPostsForUser(int userId) {
        String URLGetPosts = "https://jsonplaceholder.typicode.com/users/" + userId + "/posts";
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(URLGetPosts))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = doRequest(httpRequest);
        //System.out.println("response.body().toString() = " + response.body());
        return response.body();
    }
    private  int getMaxIdPosts(String posts) {
        int maxId = 0;
        JSONArray jsonarray = new JSONArray(posts);
        for (int i = 0; i < jsonarray.length(); i++) {
            JSONObject jsonobject = jsonarray.getJSONObject(i);
            maxId = jsonobject.getInt("id");
        }
        return maxId;
    }
    private  String getComments(int idPosts) {
        String url = "https://jsonplaceholder.typicode.com/posts/" + idPosts + "/comments";
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .GET()
                .build();
        HttpResponse<String> response = doRequest(httpRequest);
        System.out.println("Comments:" + response.body());
        return response.body();
    }



    private  void writeInFile(String comments, int idUser, int numberPost)  {
        File file = new File("user-" + idUser + "-post-" + numberPost + "-comments.json");

        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(comments);
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public void getCommentsForLastPostAndWriteFile(int userId){
       String posts =  getPostsForUser(userId);
       int numberPost = getMaxIdPosts(posts);
       String com = getComments(numberPost);

       writeInFile(com,userId,numberPost);
    }

    public static void main(String[] args) {

        Task2 task2 = new Task2();
        task2.getCommentsForLastPostAndWriteFile(1);
    }
}
