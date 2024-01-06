package br.com.moppahtech.locadora.model.entities;

import br.com.moppahtech.locadora.model.PersonModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name= "tb_client")
public class ClientModel extends PersonModel {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer matricula;
    public ClientModel() {
    }
    public ClientModel(UUID id, String name, String address, Integer age, Integer matricula) {
        super(id, name, address, age);
        this.matricula= matricula;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }
}
