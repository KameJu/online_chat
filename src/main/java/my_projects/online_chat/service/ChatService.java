package my_projects.online_chat.service;

import my_projects.online_chat.domains.ChatMessage;
import my_projects.online_chat.domains.ChatRequest;
import my_projects.online_chat.domains.ChatResponse;
import my_projects.online_chat.domains.ChatResponse.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

import javax.annotation.PostConstruct;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Service
public class ChatService {

    private Map<ChatRequest, DeferredResult<ChatResponse>> waitingUsers;
    // {key : websocket session id, value : chat room id}
    private Map<String, String> connectedUsers;
    private ReentrantReadWriteLock lock;


    private final SimpMessagingTemplate simpMessagingTemplate;


    @Autowired
    public ChatService(SimpMessagingTemplate simpMessagingTemplate) {

        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @PostConstruct
    private void setUp() {
        this.waitingUsers = new LinkedHashMap<>();
        this.lock = new ReentrantReadWriteLock();
        this.connectedUsers = new ConcurrentHashMap<>();
    }


    @Async("asyncThreadPool")
    public void joinChatRoom(ChatRequest request, DeferredResult<ChatResponse> deferredResult) {
        if (request == null || deferredResult == null) {
            return;
        }

        try {
            lock.writeLock().lock();
            waitingUsers.put(request, deferredResult);
        } finally {
            lock.writeLock().unlock();
            establishChatRoom();
        }
    }

    public void establishChatRoom() {
        try {
            lock.readLock().lock();
            if (waitingUsers.size() < 2) {
                return;
            }

            Iterator<ChatRequest> itr = waitingUsers.keySet().iterator();
            ChatRequest user1 = itr.next();
            ChatRequest user2 = itr.next();

            String uuid = UUID.randomUUID().toString();

            DeferredResult<ChatResponse> user1Result = waitingUsers.remove(user1);
            DeferredResult<ChatResponse> user2Result = waitingUsers.remove(user2);

            user1Result.setResult(new ChatResponse(ResponseResult.SUCCESS, uuid, user1.getSessionId()));
            user2Result.setResult(new ChatResponse(ResponseResult.SUCCESS, uuid, user2.getSessionId()));
        } catch (Exception e) {
        } finally {
            lock.readLock().unlock();
        }
    }



    public void sendMessage(String chatRoomId, ChatMessage message){
        simpMessagingTemplate.convertAndSend(getDestination(chatRoomId), message);
    }

    private String getDestination(String chatRoomId) {
        return "/topic/chat" + chatRoomId;
    }

    public void connectUser(String chatRoomId, String sessionId) {

    }
}
