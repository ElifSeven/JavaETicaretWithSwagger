package elif.controller;

import elif.dto.UserCreateDTO;
import elif.dto.UserResponseDTO;
import elif.entity.User;
import elif.repository.UserRepository;
import elif.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @ApiOperation(value = "View a list of user", response = List.class)
    @GetMapping("/view")
    public List<User> getAllUser() {

        return userService.getAllUser();
    }

    @ApiOperation(value = "Add an user")
    @PostMapping("/add")
    public UserResponseDTO addUser(@RequestBody UserCreateDTO userCreateDTO) {

        return userService.addUser(userCreateDTO);
    }

    @ApiOperation(value = "View user by id")
    @GetMapping("/view/{id}")
    public User findUserById(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {

        return userService.findUserById(userId);
    }

    @ApiOperation(value = "Delete user by id")
    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteUserById(@PathVariable(value = "id") Long userId) {

        return userService.deleteUserById(userId);
    }
}
