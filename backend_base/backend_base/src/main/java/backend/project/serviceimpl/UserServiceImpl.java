package backend.project.serviceimpl;

import backend.project.dtos.DTOUser;
import backend.project.entities.Authority;
import backend.project.entities.User;
import backend.project.repositories.UserRepository;
import backend.project.security.SecurityUser;
import backend.project.services.AuthorityService;
import backend.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
// import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthorityService authorityService;

    @Override
    public User findByUsername(String username) {
        User userFound = userRepository.findByUserName(username);

        return userFound;
    }

    @Override
    public User findById(String id) {
        User userFound = userRepository.findById(id).orElse(null);

        return userFound;
    }


    public List<Authority> authorityListFromString(String authorityString) {

        List<String> authorityListString =  List.of(authorityString.split(";"));

        List<Authority> authorityList = new ArrayList<>();

        for (String authorityStringItem: authorityListString){
            Authority authority = authorityService.findByName(authorityStringItem);
            authorityList.add(authority);
        }

        return  authorityList;
    }

    @Override
    public User addUser(DTOUser dtoUser) {
        User newUser = new User();
        newUser.setUserName(dtoUser.getUserName());
        newUser.setPassword( new BCryptPasswordEncoder().encode(dtoUser.getPassword()));
        newUser.setAuthorities(authorityListFromString(dtoUser.getAuthorities()));
        newUser.setFirstName(dtoUser.getFirstName());
        newUser.setLastName(dtoUser.getLastName()); 
        return userRepository.save(newUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new SecurityUser(findByUsername(username));
    }
}
