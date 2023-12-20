package br.com.moppahtech.locadora.service.impl;

import br.com.moppahtech.locadora.exceptions.BusinessException;
import br.com.moppahtech.locadora.exceptions.NotFoundException;
import br.com.moppahtech.locadora.model.entities.UserModel;
import br.com.moppahtech.locadora.repository.UserRepository;
import br.com.moppahtech.locadora.service.UserService;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public List<UserModel> listUsers(){
      return userRepository.findAll();

    }

    public Optional<UserModel> findUserById(UUID id){
        if (userRepository.findById(id).isEmpty()){
            throw new NotFoundException("Usuário não encontrado");
        }
        return userRepository.findById(id);
    }

    public UserModel upDateUser(UserModel userModel){
                return userRepository.save(userModel);
    }

    public void deleteUser(UUID id){
     if (userRepository.findById(id).isEmpty()){
         throw new NotFoundException("Usuário não encontrado");
     }
      userRepository.deleteById(id);
    }

    public UserModel createUser(UserModel userModel){
        UserModel model = userRepository.findByLogin(userModel.getLogin());
        if(nonNull(model)){
            throw new BusinessException("Usuario ja cadastrado.");
        }
        userModel.setPassword(encriptPassWord(userModel.getPassword()));
        return userRepository.save(userModel);
    }

    private String encriptPassWord(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

}
