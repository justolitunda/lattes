package ke.ac.egerton.quality;

import ke.ac.egerton.quality.Repository.UserRepository;
import ke.ac.egerton.quality.model.Role;
import ke.ac.egerton.quality.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QualityApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCreateUser() {


        User user = new User();
        user.setName("justus");
        user.setLastName("luganu");
        user.setStatus("student");

        user.setPassword("12345");
        user.setEmail("jlitunda@egeton.ac.ke");
        userRepository.save(user);

    }

    @Test
    public void testfindUserById() {
        User user = userRepository.findAllById(4);
        System.out.println(user);

    }
    @Test
    public void testUpdateUser() {
        User user
                = userRepository.findAllById(4);
        user.setEmail("litundax@gmail.com");
        userRepository.save(user);

    }
    @Test
    public void testDeleteUser(){
        User user=userRepository.findAllById(4);
        userRepository.delete(user);
    }
}



