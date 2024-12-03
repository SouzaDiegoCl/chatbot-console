package service;

import infra.ApiClient;

import java.io.IOException;

public class ChatService {
    private final ApiClient apiClient;


    public ChatService() {
            this.apiClient = new ApiClient();
    }

    public String getChatGptResponse(String userQuestion){
        try{
            return apiClient.sendMessage(userQuestion);
        }catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
