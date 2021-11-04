package my_projects.online_chat.web;

import my_projects.online_chat.Dto.RequestParams;
import my_projects.online_chat.domains.ChatMessage;
import my_projects.online_chat.domains.ChatRequest;
import my_projects.online_chat.domains.ChatResponse;
import my_projects.online_chat.service.ChatService;
import my_projects.online_chat.util.ServletUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.List;

@RestController
public class ChatController {

    private List<ChatRequest> users;
    private final ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }



    private int counter = 0;
    @PostMapping("/join.data")
    public void test(@RequestBody RequestParams data) {
        System.out.println(++counter + ": " + data);

        String sessionId = ServletUtil.getSession().getId();
        users.add(new ChatRequest(sessionId, data));
    }

    @GetMapping("/join")
    @ResponseBody
    public DeferredResult<ChatResponse> joinRequest() {
        String sessionId = ServletUtil.getSession().getId();
//        ChatUserDto data = new ChatUserDto();

//        final ChatRequest user = new ChatRequest(sessionId);
        final DeferredResult<ChatResponse> deferredResult = new DeferredResult<>(null);
//        chatService.joinChatRoom(user, deferredResult);

//        deferredResult.onCompletion(() -> chatService.cancelChatRoom(user));
//        deferredResult.onError((throwable) -> chatService.cancelChatRoom(user));
//        deferredResult.onTimeout(() -> chatService.timeout(user));

        return deferredResult;
    }


    @MessageMapping("/chat.message/{chatRoomId}")
    public void sendMessage(@DestinationVariable("chatRoomId") String chatRoomId, @Payload ChatMessage message) {
        chatService.sendMessage(chatRoomId, message);
    }
}
