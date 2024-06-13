package e_commerce_application.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

        @Autowired
        private UsersRepository usersRepository;

        public List<Users> getAllUsers() {
            return usersRepository.findAll();
        }

        public Optional<Users> getUserById(Long userId) {
            return usersRepository.findById(userId);
        }

        public Users createUser(Users user) {
            return usersRepository.save(user);
        }

        public Users updateUser(Long userId, Users userDetails) {
            Users user = usersRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found for this id :: " + userId));
            user.setEmail(userDetails.getEmail());
            user.setFirstName(userDetails.getFirstName());
            user.setLastName(userDetails.getLastName());
            user.setPassword(userDetails.getPassword());
            user.setMobileNumber(userDetails.getMobileNumber());
            user.setDateOfBirth(userDetails.getDateOfBirth());
            return usersRepository.save(user);
        }

        public void deleteUser(Long userId) {
            usersRepository.deleteById(userId);

     }
}
