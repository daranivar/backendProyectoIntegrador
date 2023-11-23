package com.example.BackendProyIntegrador.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder1 = new BCryptPasswordEncoder();
        String password = passwordEncoder1.encode("password");

        BCryptPasswordEncoder passwordEncoder2 = new BCryptPasswordEncoder();
        String password2 = passwordEncoder2.encode("password2");

        /*userRepository.save(new AppUser("Charly", "charly", "charly@dh.com", password, AppUsuarioRoles.ADMIN));
        userRepository.save(new AppUser("Charly2", "charly2", "charly2@dh.com", password2, AppUsuarioRoles.USER));
*/
    }
}
