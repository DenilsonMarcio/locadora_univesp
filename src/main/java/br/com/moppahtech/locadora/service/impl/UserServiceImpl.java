package br.com.moppahtech.locadora.service.impl;

import br.com.moppahtech.locadora.exceptions.BusinessException;
import br.com.moppahtech.locadora.exceptions.NotFoundException;
import br.com.moppahtech.locadora.model.dto.UserDTO;
import br.com.moppahtech.locadora.model.entities.UserModel;
import br.com.moppahtech.locadora.repository.UserRepository;
import br.com.moppahtech.locadora.service.UserService;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public List<UserDTO> listUsers(){
        List<UserModel> userModelList = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for (UserModel userModel: userModelList) {
            userDTOList.add(new UserDTO(userModel));
        }
      return userDTOList;

    }

    public Optional<UserDTO> findUserById(UUID id){
        Optional<UserModel> userOptional = userRepository.findById(id);
        if (userRepository.findById(id).isEmpty()){
            throw new NotFoundException("Usuário não encontrado");
        }
        UserDTO userDTO = new UserDTO(userOptional.get());
        return Optional.of(userDTO);
    }

    public UserDTO upDateUser(UserModel userModel){
        return new UserDTO(userRepository.save(userModel));
    }

    public void deleteUser(UUID id){
     if (userRepository.findById(id).isEmpty()){
         throw new NotFoundException("Usuário não encontrado");
     }
      userRepository.deleteById(id);
    }

    public UserDTO createUser(UserModel userModel){
        UserModel model = userRepository.findByLogin(userModel.getLogin());
        if(nonNull(model)){
            throw new BusinessException("Usuario ja cadastrado.");
        }
        userModel.setPassword(encriptPassWord(userModel.getPassword()));
        return new UserDTO(userRepository.save(userModel));
    }

    private String encriptPassWord(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

}
