package br.com.miromar.todolist.user;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    UserModel createUser(UserCreateDTO usuario){

      if(repository.findByUsername(usuario.username()).isPresent()){
       throw new ResponseStatusException(HttpStatus.CONFLICT,"Usuário já cadastrado!");
      }

        String passwordCrypt =  BCrypt.withDefaults().hashToString(12,usuario.password().toCharArray());
        UserModel user = new UserModel();
        user.setName(usuario.name());
        user.setUsername(usuario.username());
        user.setPassword(passwordCrypt);      

        return  repository.save(user);
    }

}
