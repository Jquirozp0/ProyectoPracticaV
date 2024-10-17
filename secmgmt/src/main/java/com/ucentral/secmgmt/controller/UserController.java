package com.ucentral.secmgmt.controller;

import com.ucentral.secmgmt.model.User;
import com.ucentral.secmgmt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins ={"http://localhost:4200"} )
@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public List<User> listar() {
        return userService.listUsers();

    }
    @PostMapping("/index")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUsers(@RequestBody User user) {
        return userService.saveUsers(user);
    }
    @GetMapping("/index/{id}")
    public User listUsers (@PathVariable Long id) {
        return userService.findUserbyId(id);
    }

    @PutMapping("/index/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public User actualizarUsers(@RequestBody User user, @PathVariable Long id){
        User userActual = userService.findUserbyId(id);

        return userService.saveUsers(userActual);
    }
    @DeleteMapping("/index/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarUsers(@PathVariable Long id) { userService.deleteUser(id);}
}
