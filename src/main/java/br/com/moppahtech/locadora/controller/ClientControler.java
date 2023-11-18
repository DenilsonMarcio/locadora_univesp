package br.com.moppahtech.locadora.controller;

import br.com.moppahtech.locadora.model.entities.ClientModel;
import br.com.moppahtech.locadora.service.ClientService;
import br.com.moppahtech.locadora.service.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin("*")
public class ClientControler {

    @Autowired
    ClientService clientService;

    @GetMapping("/client")
    public ResponseEntity<List<ClientModel>> listaCliente(){
        return  ResponseEntity.status(HttpStatus.OK).body(clientService.listClient());
    }

    @GetMapping("/client/{id}")
    public Optional<ClientModel> buscaClientePorId(@PathVariable UUID id){
        return clientService.findClientById(id);
    }

    @PutMapping("/client")
    public ResponseEntity<ClientModel> alteraCliente(@RequestBody ClientModel clientModel){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(clientService.upDateClient(clientModel));
    }

    @DeleteMapping("client/{id}")
    public ResponseEntity<Void> excluiCliente(@PathVariable UUID id){
        clientService.deleteClient(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @PostMapping("/client")
    public ResponseEntity<ClientModel> cadastraCliente(@RequestBody ClientModel clientModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.createClient(clientModel));
    }


}
