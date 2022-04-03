package testApi.task3;

import org.json.JSONArray;
import org.json.JSONObject;
import testApi.Request;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Task3 extends Request {

    public String getOpenTaskForUser(int userId) {
        String url = "https://jsonplaceholder.typicode.com/users/" + userId + "/todos";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = doRequest(request);

        StringBuilder result = new StringBuilder();
        JSONArray jsonArray = new JSONArray(response.body());

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonobject = jsonArray.getJSONObject(i);
            if(jsonobject.get("completed").equals(false)) {
                result.append(jsonobject);
                result.append(","+"\n");
            }
        }
        System.out.println(result);
        return result.toString();
    }
}
