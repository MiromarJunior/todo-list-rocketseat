package br.com.miromar.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    UserModel createUser(UserModel usuario){
        repository.findByUsername(usuario.getUsername()).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.CONFLICT,"Usuário já cadastrado!")
        );
        return  repository.save(usuario);
    }

}
