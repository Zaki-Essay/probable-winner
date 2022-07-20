package ma.ensah.sprint1.mappres;


import ma.ensah.sprint1.dtos.UserDto;
import ma.ensah.sprint1.entities.User;

public interface IUserMapper {
    UserDto fromUser(User user);

    User fromUserDto(UserDto userDto);
}
