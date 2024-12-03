package infra;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient {
    //Get API_KEY as a Environment Variable
    //private static final String API_KEY = System.getenv("API_KEY");
    private static final String API_KEY = "YOUR_GEMINI_API_KEY";
    //URL
    private static final String API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash-latest:generateContent";

    public String sendMessage(String userQuestion) throws IOException, InterruptedException {
        //Creating a JSON
        String body = "{\"contents\":[{\"parts\":[{\"text\":\"" + userQuestion + "\"}]}]}";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL + "?key=" + API_KEY))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        //It handles the body response into a String
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject jsonObject = new JSONObject(response.body());
        JSONArray jsonArray = jsonObject.getJSONArray("candidates");
        String textResponse =  jsonArray.getJSONObject(0).getJSONObject("content").getJSONArray("parts").getJSONObject(0).getString("text");
        return textResponse;

    }
}
