package br.com.moppahtech.locadora.controller;

import br.com.moppahtech.locadora.model.entities.ClientModel;
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
    ClientServiceImpl clientServiceImpl;

    @GetMapping("/client")
    public ResponseEntity<List<ClientModel>> listaCliente(){
        return  ResponseEntity.status(HttpStatus.OK).body(clientServiceImpl.listClient());
    }

    @GetMapping("/client/{id}")
    public Optional<ClientModel> buscaClientePorId(@PathVariable UUID id){
        return clientServiceImpl.findClientById(id);
    }

    @PutMapping("/client")
    public ResponseEntity<?> alteraCliente(@RequestBody ClientModel clientModel){
        return clientServiceImpl.upDateClient(clientModel);
    }

    @DeleteMapping("client/{id}")
    public ResponseEntity<?> excluiCliente(@PathVariable UUID id){
        return clientServiceImpl.deleteClient(id);

    }

    @PostMapping("/client")
    public ResponseEntity<?> cadastraCliente(@RequestBody ClientModel clientModel){
        return clientServiceImpl.createClient(clientModel);
    }


}
