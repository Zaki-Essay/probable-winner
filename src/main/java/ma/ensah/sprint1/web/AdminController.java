package ma.ensah.sprint1.web;


import ma.ensah.sprint1.dtos.UserDto;
import ma.ensah.sprint1.exceptions.UserNotFoundException;
import ma.ensah.sprint1.services.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
public class AdminController {

    @Autowired
    private IAdminService adminService;


    @GetMapping("/users")
    public List<UserDto> users(){
        return adminService.listUsers();
    }
    @GetMapping("/users/search")
    public List<UserDto> searchUsers(@RequestParam(name = "keyword",defaultValue = "") String keyword){
        return adminService.searchUsers("%"+keyword+"%");
    }
    @GetMapping("/users/{id}")
    public UserDto getUser(@PathVariable(name = "id") Long userId) throws UserNotFoundException {
        return  adminService.getUser(userId);
    }
    @PostMapping("/users")
    public UserDto saveUser(@RequestBody UserDto userDto){
        return adminService.saveUser(userDto);
    }
    @PutMapping("/users/{id}")
    public UserDto updateUser(@PathVariable Long id, @RequestBody UserDto userDto){
        userDto.setUserId(id);
        return adminService.updateUser(userDto);
    }
    @DeleteMapping("/users/{id}")
    public void deleteCustomer(@PathVariable Long id){
        adminService.deleteUser(id);
    }
}
