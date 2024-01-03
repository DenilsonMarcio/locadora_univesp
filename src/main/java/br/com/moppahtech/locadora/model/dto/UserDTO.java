package br.com.moppahtech.locadora.model.dto;

import br.com.moppahtech.locadora.model.entities.UserModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private UUID id;
    private String name;
    private String address;
    private Integer age;
    private String login;
    private Integer matricula;

    public UserDTO(UserModel userModel) {
        id = userModel.getId();
        name = userModel.getName();
        address = userModel.getAddress();
        age = userModel.getAge();
        login = userModel.getLogin();
        matricula = userModel.getMatricula();
    }
}
