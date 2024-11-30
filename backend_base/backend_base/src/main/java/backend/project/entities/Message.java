package backend.project.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name = "messages")
public class Message {
    public enum Sender {
        USER, AI
    }

    public enum AIModel {
        GPT_3, GPT_4
    }

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(updatable = false, nullable = false)
    private String id;

    @ManyToOne
    @JoinColumn(name = "chat_id", nullable = false)
    private Chat chat;

    @Enumerated(EnumType.STRING)
    private Sender sender;

    private String content;

    private Date timestamp;

    @Enumerated(EnumType.STRING)
    private AIModel aiModel;
}
