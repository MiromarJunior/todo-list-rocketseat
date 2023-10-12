package br.com.miromar.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping
    public ResponseEntity<UserModel> createUser(@RequestBody UserCreateDTO usuario){

        UserModel user = service.createUser(usuario);
        return ResponseEntity.ok().body(user);
    }


    @GetMapping
    public String TesteApp(){
        return "App online";
    }
}
