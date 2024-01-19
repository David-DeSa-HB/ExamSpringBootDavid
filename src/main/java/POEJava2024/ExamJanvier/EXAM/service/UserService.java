package POEJava2024.ExamJanvier.EXAM.service;

import POEJava2024.ExamJanvier.EXAM.DTO.UserDTO;
import POEJava2024.ExamJanvier.EXAM.Slugger;
import POEJava2024.ExamJanvier.EXAM.entity.Listing;
import POEJava2024.ExamJanvier.EXAM.entity.User;
import POEJava2024.ExamJanvier.EXAM.exception.NotFoundCentralishException;
import POEJava2024.ExamJanvier.EXAM.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private Slugger slugger;


    public User show(Long id){
        Optional<User> uOptional = userRepository.findById(id);
        if (uOptional.isPresent()) {
            return uOptional.get();
        }
        throw new NotFoundCentralishException("User", "id", id);
    }

    public User persist(UserDTO userDTO, Long id){
        if (id !=null && userRepository.findById(id).isEmpty()){
            throw new NotFoundCentralishException(
                    "User", "id", id
            );
        }

        User u = new User();
        u.setId(id);
        u.setCreatedAt(userDTO.getCreatedAt());
        u.setEmail(userDTO.getEmail());
        u.setPassword((userDTO.getPassword()));
        u.setRoles(userDTO.getRoles());

        return userRepository.saveAndFlush(u);

    }
}
