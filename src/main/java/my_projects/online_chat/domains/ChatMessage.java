package my_projects.online_chat.domains;


import lombok.Data;

@Data
public class ChatMessage {

    private String senderSessionId;
    private String message;
}
