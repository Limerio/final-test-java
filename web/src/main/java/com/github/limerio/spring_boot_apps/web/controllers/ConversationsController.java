package com.github.limerio.spring_boot_apps.web.controllers;

import com.github.limerio.spring_boot_apps.web.models.Conversation;
import com.github.limerio.spring_boot_apps.web.services.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class ConversationsController {
    private final RestTemplate restTemplate = new RestTemplate();
    @Autowired
    private ConversationService conversationService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/submit")
    public String submitMessage(@RequestParam String username, @RequestParam String message, Model model) {
        String response = restTemplate.getForObject("http://localhost:8081/api/quotes/random", String.class);
        conversationService.saveConversation(username, message, response);
        model.addAttribute("response", response);
        return "index";
    }

    @GetMapping("/users")
    public String users(Model model) {
        List<String> users = conversationService.getAllUsernames();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/conversations")
    public String conversations(Model model, @RequestParam String username) {
        List<Conversation> conversations = conversationService.getConversationsByUsername(username);
        model.addAttribute("conversations", conversations);
        return "conversations";
    }
}