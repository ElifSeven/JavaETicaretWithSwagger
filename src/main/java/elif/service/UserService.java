package elif.service;

import elif.dto.UserCreateDTO;
import elif.dto.UserResponseDTO;
import elif.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    List<User> getAllUser();

    UserResponseDTO addUser(UserCreateDTO userCreateDTO);

    User findUserById(Long userId);

    Map<String, Boolean> deleteUserById(Long userId);
    
    User findUserByEmailAdresss(String emailAdress);
}
