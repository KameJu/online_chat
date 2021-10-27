package my_projects.online_chat.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class ChatResponse {

    private ResponseResult responseResult;
    private String chatRoomId;
    private String sessionId;


    public enum ResponseResult {
        SUCCESS, CANCEL, TIMEOUT;
    }
}
