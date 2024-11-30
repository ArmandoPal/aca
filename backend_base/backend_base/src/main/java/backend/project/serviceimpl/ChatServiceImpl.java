package backend.project.serviceimpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.project.entities.Chat;
import backend.project.entities.User;
import backend.project.repositories.ChatRepository;
import backend.project.repositories.UserRepository;

@Service
public class ChatServiceImpl {
    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private UserRepository userRepository;

    public Chat createChat(String userId, String chatName) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        Chat chat = new Chat();
        chat.setUser(user);
        chat.setChatName(chatName);
        chat.setDateCreation(new Date());
        return chatRepository.save(chat);
    }
}
