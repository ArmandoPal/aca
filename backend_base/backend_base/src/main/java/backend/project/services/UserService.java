package backend.project.services;

import backend.project.dtos.DTOUser;
import backend.project.entities.User;

public interface UserService {

    public User findByUsername(String username);
    public User findById(String id);

    public User addUser(DTOUser dtoUser);




}
