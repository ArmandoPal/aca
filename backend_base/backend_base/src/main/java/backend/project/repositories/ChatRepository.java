package backend.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.project.entities.Chat;

public interface ChatRepository extends JpaRepository<Chat, String> {
}