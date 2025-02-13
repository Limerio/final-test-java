package com.github.limerio.spring_boot_apps.web.services;

import com.github.limerio.spring_boot_apps.web.models.Conversation;
import com.github.limerio.spring_boot_apps.web.repositories.ConversationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ConversationService {

    ConversationRepository conversationRepository;

    public ConversationService(ConversationRepository conversationRepository) {
        this.conversationRepository = conversationRepository;
    }

    public void saveConversation(String username, String message, String response) {
        Conversation conversation = new Conversation();
        conversation.setUsername(username);
        conversation.setMessage(message);
        conversation.setResponse(response);
        conversation.setTimestamp(LocalDateTime.now());
        conversationRepository.save(conversation);
    }

    public List<Conversation> getConversationsByUsername(String username) {
        return conversationRepository.findByUsername(username);
    }

    public List<Conversation> getAll() {
        return conversationRepository.findAll();
    }
}