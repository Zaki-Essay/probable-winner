package ma.ensah.sprint1.services.impl;


import ma.ensah.sprint1.dao.UserDao;
import ma.ensah.sprint1.dtos.UserDto;
import ma.ensah.sprint1.entities.User;
import ma.ensah.sprint1.exceptions.UserNotFoundException;
import ma.ensah.sprint1.mappres.IUserMapper;
import ma.ensah.sprint1.services.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
//@AllArgsConstructor

public class AdminServiceImpl implements IAdminService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private IUserMapper userMapper;


    @Override
    public UserDto saveUser(UserDto userDto) {

        User user=userMapper.fromUserDto(userDto);
        User savedUser = userDao.save(user);
        return userMapper.fromUser(savedUser);
    }




    @Override
    public List<UserDto> listUsers() {
        List<User> users = userDao.findAll();
        List<UserDto> userDtos = users.stream()
                .map(user -> userMapper.fromUser(user))
                .collect(Collectors.toList());

        return userDtos;
    }



    @Override
    public UserDto getUser(Long userId) throws UserNotFoundException {
        User user = userDao.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("user Not found"));
        return userMapper.fromUser(user);
    }

    @Override
    public UserDto updateUser(UserDto userDto) {

        User user=userMapper.fromUserDto(userDto);
        User savedUser = userDao.save(user);
        return userMapper.fromUser(savedUser);
    }

    @Override
    public void deleteUser(Long userId){
        userDao.deleteById(userId);
    }


    @Override
    public List<UserDto> searchUsers(String keyword) {
        List<User> users=userDao.searchUser(keyword);
        List<UserDto> userDtos = users.stream().map(user -> userMapper.fromUser(user)).collect(Collectors.toList());
        return userDtos;
    }

}
