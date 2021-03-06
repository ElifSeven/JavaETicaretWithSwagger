package elif.service.impl;

import elif.dto.UserCreateDTO;
import elif.dto.UserResponseDTO;
import elif.entity.User;
import elif.repository.UserRepository;
import elif.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUser() {

        return userRepository.findAll();
    }

    @Override
    public UserResponseDTO addUser(UserCreateDTO userCreateDTO) {

        User user = userCreateDTOtoUser(userCreateDTO);
        user = userRepository.save(user);
        return userResponseDTOFromUser(user);
    }


    public User userCreateDTOtoUser(UserCreateDTO userCreateDTO) {

        User userFromUserCreateDTO = new User();
        userFromUserCreateDTO.setEmailAddress(userCreateDTO.getEmail());
        userFromUserCreateDTO.setPassword(userCreateDTO.getPassword());

        return userFromUserCreateDTO;

    }

    public UserResponseDTO userResponseDTOFromUser(User user) {

        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setEmail(user.getEmailAddress());

        return userResponseDTO;

    }


    @Override
    public User findUserById(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        return userOptional.orElseThrow(() -> new org.springframework.data.rest.webmvc.ResourceNotFoundException("User not found for this id: " + userId));

    }
    
    @Override
    public User findUserByEmailAdresss(String emailAdress)
    {
    	return userRepository.findUserByEmailAddress(emailAdress);
    }

    @Override
    public Map<String, Boolean> deleteUserById(Long userId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found for this id:" + userId));

        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;
    }


}
