package my_projects.online_chat.Dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class RequestParams {

    private String mySex;
    private String opSex;
    private String myAge;
    private String opAge;

}
