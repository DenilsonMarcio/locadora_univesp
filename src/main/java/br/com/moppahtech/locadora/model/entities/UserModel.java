package br.com.moppahtech.locadora.model.entities;

import br.com.moppahtech.locadora.model.PersonModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name= "tb_user")
public class UserModel extends PersonModel {
    private String login;
    private String password;
    public UserModel() {
    }
    public UserModel(String login, String password) {
        this.login = login;
        this.password = password;
    }
    public UserModel(UUID id, String name, String address, Integer age, String login, String password) {
        super(id, name, address, age);
        this.login = login;
        this.password = password;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
