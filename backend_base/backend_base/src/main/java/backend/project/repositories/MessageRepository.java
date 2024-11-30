package backend.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import backend.project.entities.Message;

public interface MessageRepository extends JpaRepository<Message, String> {
}