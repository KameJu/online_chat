package my_projects.online_chat.domains;

import lombok.*;
import my_projects.online_chat.Dto.RequestParams;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ChatRequest {

    private String sessionId;
    private RequestParams userDto;
}
