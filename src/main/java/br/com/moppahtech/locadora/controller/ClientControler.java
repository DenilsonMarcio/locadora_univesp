package br.com.moppahtech.locadora.controller;

import br.com.moppahtech.locadora.model.entities.ClientModel;
import br.com.moppahtech.locadora.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin("*")
public class ClientControler {
    @Autowired
    ClientService clientService;

    @GetMapping("/client")
    public ResponseEntity<?> listaCliente(){
        return clientService.listClient();
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<?> buscaClientePorId(@PathVariable UUID id){
        return clientService.findClientById(id);
    }

    @PutMapping("/client")
    public ResponseEntity<?> alteraCliente(@RequestBody ClientModel clientModel){
        return clientService.upDateClient(clientModel);
    }

    @DeleteMapping("client/{id}")
    public ResponseEntity<?> excluiCliente(@PathVariable UUID id){
        return clientService.deleteClient(id);

    }

    @PostMapping("/client")
    public ResponseEntity<?> cadastraCliente(@RequestBody ClientModel clientModel){
        return clientService.createClient(clientModel);
    }


}
