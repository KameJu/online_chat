package my_projects.online_chat.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.Session;
import java.net.Socket;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping
    public String main(Model model) {

        model.addAttribute("isDevMode", true);
        return "index";
    }

    @PostMapping
    public void data() {

    }

//    @GetMapping("/chat")
//    public void chat(Model model) {
//
//    }
}
