package backend.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.project.dtos.DTOMessage;
import backend.project.entities.Message;
import backend.project.serviceimpl.AIServiceImpl;
import backend.project.serviceimpl.MessageServiceImpl;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api")
public class MessageController {
    @Autowired
    private MessageServiceImpl messageService;

    @Autowired
    private AIServiceImpl aiService;

    @PostMapping("/messages")
    public ResponseEntity<Message> sendMessage(@RequestBody DTOMessage messageDTO) {
        Message.Sender sender = Message.Sender.USER;

        if (messageDTO.getAiModel() != null) {
            String aiResponse = aiService.sendMessageToAI(messageDTO.getContent());
            Message aiMessage = messageService.sendMessage(
                    messageDTO.getChatId(), aiResponse, Message.Sender.AI, messageDTO.getAiModel());
            return new ResponseEntity<>(aiMessage, HttpStatus.OK);
        }

        Message userMessage = messageService.sendMessage(
                messageDTO.getChatId(), messageDTO.getContent(), sender, messageDTO.getAiModel());
        return new ResponseEntity<>(userMessage, HttpStatus.OK);
    }
}
