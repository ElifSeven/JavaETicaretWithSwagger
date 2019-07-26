package elif.service;

import elif.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    List<User> getAllUser();

    User addUser(User user);

    User findUserById(Long userId);

    Map<String, Boolean> deleteUserById(Long userId);
}
