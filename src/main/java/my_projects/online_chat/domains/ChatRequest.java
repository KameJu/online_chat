package my_projects.online_chat.domains;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ChatRequest {

    private String sessionId;
}
