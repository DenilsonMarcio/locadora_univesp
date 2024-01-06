package br.com.moppahtech.locadora.model.dto;

import br.com.moppahtech.locadora.model.entities.ClientModel;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public class ClientDto {


    @NotBlank(message = "Nome não pode estar vazio")
    private String name;
    @NotBlank(message = "Endereço não pode estar vazio")
    private String address;

    @Min(value = 18, message = "Cliente deve ter idade maior ou igual a 18 anos")
    private Integer age;


    private Integer matricula;

    public ClientDto() {
    }

    public ClientDto(ClientModel clientModel) {
      name = clientModel.getName();
      address = clientModel.getAddress();
      age = clientModel.getAge();
      matricula = clientModel.getMatricula();

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }
}
