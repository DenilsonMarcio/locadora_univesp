package br.com.moppahtech.locadora.service.impl;

import br.com.moppahtech.locadora.model.entities.ClientModel;
import br.com.moppahtech.locadora.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class ClientServiceImpl {

    @Autowired
    private ClientRepository clientRepository;

    public List<ClientModel> listClient(){
        return clientRepository.findAll();
    }

    public Optional<ClientModel> findClientById(UUID id){
        return clientRepository.findById(id);
    }

    public ResponseEntity<?> upDateClient(ClientModel clientModel){
        return new ResponseEntity<>(clientRepository.save(clientModel),HttpStatus.OK);
    }

    public ResponseEntity<?> createClient(ClientModel clientModel){

        return new ResponseEntity<>(clientRepository.save(clientModel), HttpStatus.CREATED) ;
    }

    public ResponseEntity<?> deleteClient(UUID id){
        clientRepository.deleteById(id);
       return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }

}
