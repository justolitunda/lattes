package ke.ac.egerton.quality.service;

import ke.ac.egerton.quality.Repository.RoleRepository;
import ke.ac.egerton.quality.Repository.UserRepository;
import ke.ac.egerton.quality.model.Role;
import ke.ac.egerton.quality.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.HashSet;

public abstract class UserServiceImpl implements UserRepository {

        @Autowired
        BCryptPasswordEncoder encoder;
        @Autowired
        RoleRepository roleRepository;
        @Autowired
        UserRepository userRepository;

        public BCryptPasswordEncoder getEncoder() {
            return encoder;
        }

        public void setEncoder(BCryptPasswordEncoder encoder) {
            this.encoder = encoder;
        }

        public RoleRepository getRoleRepository() {
            return roleRepository;
        }

        public void setRoleRepository(RoleRepository roleRepository) {
            this.roleRepository = roleRepository;
        }

        public UserRepository getUserRepository() {
            return userRepository;
        }

        public void setUserRepository(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        public void saveUser(User user) {
            user.setPassword(encoder.encode(user.getPassword()));
            user.setStatus("VERIFIED");
            Role userRole = roleRepository.findByRole("SITE_USER");
            user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
            userRepository.save(user);
        }

        public boolean isUserAlreadyPresent(User user) {
            boolean isUserAlreadyExists = false;
            User existingUser = userRepository.findAllById(user.getId());
            // If user is found in database, then  user already exists.
            if(existingUser != null){
                isUserAlreadyExists = true;
            }
            return isUserAlreadyExists;
        }

    }

}
