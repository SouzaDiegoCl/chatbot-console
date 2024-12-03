import service.ChatService;

import java.security.Provider;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ChatService chatService = new ChatService();
        while (true) {
            System.out.println("Select an option:\n1 - Send a Question to Gemini\n0 - Exit");
            int opt = sc.nextInt();
            sc.nextLine();
            switch (opt) {
                case 1:
                    System.out.print("Send a message: ");
                    String message = sc.nextLine();
                    System.out.println(chatService.getChatGptResponse(message));
                    System.out.println("================");
                    break;
                case 0:
                    sc.close();
                    return;
                default:
                    System.out.println("Not a valid Option!");
                    break;
            }
        }

    }
}