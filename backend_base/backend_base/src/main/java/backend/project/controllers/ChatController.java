package backend.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.project.dtos.DTOCreateChat;
import backend.project.entities.Chat;
import backend.project.serviceimpl.ChatServiceImpl;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api")
public class ChatController {
    @Autowired
    private ChatServiceImpl chatService;

    @PostMapping("/chats")
    public ResponseEntity<Chat> createChat(@RequestBody DTOCreateChat request) {
        String userId = request.getUserId();
        Chat newChat = chatService.createChat(userId, request.getChatName());
        return ResponseEntity.ok(newChat);
    }
}
