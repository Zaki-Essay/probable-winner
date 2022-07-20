package ma.ensah.sprint1.services;


import ma.ensah.sprint1.dtos.UserDto;
import ma.ensah.sprint1.exceptions.UserNotFoundException;

import java.util.List;

public interface IAdminService {

    UserDto saveUser(UserDto userDto);

    List<UserDto> listUsers();

    UserDto getUser(Long userId) throws UserNotFoundException;

    UserDto updateUser(UserDto userDto);

    void deleteUser(Long userId);

    List<UserDto> searchUsers(String keyword);
}
