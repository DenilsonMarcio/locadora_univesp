package br.com.moppahtech.locadora.service.impl;

import br.com.moppahtech.locadora.exceptions.NotFoundException;
import br.com.moppahtech.locadora.model.dto.ClientDto;
import br.com.moppahtech.locadora.model.entities.ClientModel;
import br.com.moppahtech.locadora.repository.ClientRepository;
import br.com.moppahtech.locadora.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<ClientModel> listClient(){
        return clientRepository.findAll();
    }

    public Optional<ClientModel> findClientById(UUID id){
        if (clientRepository.findById(id).isEmpty()){
          throw new NotFoundException("Cliente não encontrado");
        }
        return clientRepository.findById(id);
    }

    public ClientModel upDateClient(ClientModel clientModel){
        return clientRepository.save(clientModel);
    }

    public ClientModel createClient(ClientDto clientDto){

        ClientModel clientModel= new ClientModel();

        clientModel.setAge(clientDto.getAge());
        clientModel.setAddress(clientDto.getAddress());
        clientModel.setName(clientDto.getName());

        clientModel.setMatricula(gerarMatriculaCliente());

        return clientRepository.save(clientModel);
    }

    private Integer gerarMatriculaCliente() {

        return clientRepository.gerarMatriculaCliente()+1;
    }

    @Override
    public List<ClientModel> findClientByName(String name) {
        return clientRepository.findClientByName(name);
    }

    public void deleteClient(UUID id){
        if (clientRepository.findById(id).isEmpty()){
            throw new NotFoundException("Cliente não encontrado");
        }
        clientRepository.deleteById(id);
    }

}
