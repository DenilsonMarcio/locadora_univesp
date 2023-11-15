package br.com.moppahtech.locadora.service;

import br.com.moppahtech.locadora.model.entities.ClientModel;
import br.com.moppahtech.locadora.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public ResponseEntity<?> listClient(){
        return new ResponseEntity<>(clientRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> findClientById(UUID id){
        return new ResponseEntity<>(clientRepository.findById(id), HttpStatus.FOUND);
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
