package backend.project.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import backend.project.entities.Chat;
import backend.project.entities.Message;
import backend.project.repositories.ChatRepository;
import backend.project.repositories.MessageRepository;

import java.util.Date;

@Service
public class MessageServiceImpl {
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private ChatRepository chatRepository;

    public Message sendMessage(String chatId, String content, Message.Sender sender, Message.AIModel aiModel) {
        Chat chat = chatRepository.findById(chatId).orElseThrow(() -> new RuntimeException("Chat not found"));

        Message message = new Message();
        message.setChat(chat);
        message.setSender(sender);
        message.setContent(content);
        message.setTimestamp(new Date());
        message.setAiModel(aiModel);

        return messageRepository.save(message);
    }
}
