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

    public ResponseEntity<?> lisClient(){
        return new ResponseEntity<>(clientRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> getClientById(UUID id){
        return new ResponseEntity<>(clientRepository.findById(id), HttpStatus.OK);
    }

    public ResponseEntity<?> upDateClient(ClientModel clientModel){
        return new ResponseEntity<>(clientRepository.save(clientModel));
    }

    public ResponseEntity<?> createClient(ClientModel clientModel){

        return new ResponseEntity<>(clientRepository.save(clientModel), HttpStatus.CREATED) ;
    }

}
