package br.com.moppahtech.locadora.service;

import br.com.moppahtech.locadora.model.dto.ClientDto;
import br.com.moppahtech.locadora.model.entities.ClientModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientService {

    List<ClientModel> listClient();
    Optional<ClientModel> findClientById(UUID id);
    ClientModel upDateClient(ClientModel clientModel);
    void deleteClient(UUID id);
    ClientModel createClient(ClientDto clientDto);
    List<ClientModel> findClientByName(String name);
}