package backend.project.dtos;

import backend.project.entities.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class DTOMessage {

  private String content;
  private String chatId;
  private Message.AIModel aiModel;
  
}
