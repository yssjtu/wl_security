package authserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class data {
    @Autowired
    userRepository userRepository;

    @PostConstruct
    public void dataInit(){
        user admin = new user();
        admin.setPassword("admin");
        admin.setUsername("admin");
        userRepository.save(admin);

        user user = new user();
        user.setPassword("user");
        user.setUsername("user");
        userRepository.save(user);
    }

}
