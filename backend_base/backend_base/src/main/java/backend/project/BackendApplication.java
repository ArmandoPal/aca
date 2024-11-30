package backend.project;

import backend.project.dtos.DTOUser;
import backend.project.entities.Authority;
import backend.project.entities.User;
import backend.project.services.AuthorityService;
import backend.project.services.UserService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

// import java.time.LocalDate;


@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}


	@Bean
	public CommandLineRunner mappingDemo(

		UserService userService,
		AuthorityService authorityService
	) {
		return args -> {

			authorityService.addAuthority(new Authority(0L,"ROLE_ADMIN",null));
			authorityService.addAuthority(new Authority(0L,"ROLE_USER",null));
			
			User userAdmin = userService.addUser(new DTOUser("0","admin","123","ROLE_ADMIN", "Admin", "User"));
			// User userJugador1 = userService.addUser(new DTOUser(0L,"user1","123","ROLE_USER"));
			// User userJugador2 = userService.addUser(new DTOUser(0L,"user2","123","ROLE_USER"));	
		};
	}

}
