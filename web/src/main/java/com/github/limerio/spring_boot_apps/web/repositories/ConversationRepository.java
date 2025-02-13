package com.github.limerio.spring_boot_apps.web.repositories;

import com.github.limerio.spring_boot_apps.web.models.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConversationRepository extends JpaRepository<Conversation, Long> {
    List<Conversation> findByUsername(String username);
}