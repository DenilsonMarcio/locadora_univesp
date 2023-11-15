package br.com.moppahtech.locadora.model.entities;

import br.com.moppahtech.locadora.model.PersonModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name= "tb_client")
public class ClientModel extends PersonModel {
    public ClientModel() {
    }
    public ClientModel(UUID id, String name, String address, Integer age) {
        super(id, name, address, age);
    }
}
