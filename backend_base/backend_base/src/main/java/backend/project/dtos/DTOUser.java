package backend.project.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class DTOUser {
    private String id;
    private String userName;
    private String password;
    private String authorities;
    private String firstName;
    private String lastName;
}
