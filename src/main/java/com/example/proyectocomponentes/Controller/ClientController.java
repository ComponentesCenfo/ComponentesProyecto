package com.example.proyectocomponentes.Controller;

import com.example.proyectocomponentes.models.Client;
import com.example.proyectocomponentes.repository.IClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ClientController {
    @Autowired
    IClient iClient;

    @GetMapping("allClients")
    public List<Client> getAllClients(){ return iClient.findAll();}

    @PostMapping("createClient")
    public Client createClient(@RequestBody Client client){
        client.setFirstName(client.getFirstName());
        client.setLastName(client.getFirstName());
        client.setEmail(client.getEmail());
        client.setWeight(client.getWeight());
        client.setAge(client.getAge());
        client.setSex(client.isSex());
        return iClient.save(client);
    }

    @GetMapping("client/{name}")
    public String clientName(@PathVariable(value = "name")String name){ return iClient.byName(name);}

    @PutMapping("editClient/{id}")
    public ResponseEntity<Client> createClient(@PathVariable(value = "id")Integer id, @RequestBody Client clientUpdate){
        Optional<Client> client = iClient.findById(id);
        client.get().setFirstName(clientUpdate.getFirstName());
        client.get().setLastName(clientUpdate.getLastName());
        client.get().setEmail(clientUpdate.getEmail());
        client.get().setWeight(clientUpdate.getWeight());
        client.get().setAge(clientUpdate.getAge());
        client.get().setSex(clientUpdate.isSex());
        Client updateClient = iClient.save(client.get());

        return ResponseEntity.ok(updateClient);
    }

}
