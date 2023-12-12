package com.example.proyectocomponentes.Controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.example.proyectocomponentes.Exceptions.CustomException;
import com.example.proyectocomponentes.Service.ContactService;
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

    @Autowired
    ContactService contactService;

    @PostMapping("login")
    public ResponseEntity<Client> getClientByEmail(@RequestBody Client loginClient) {
        Client client = iClient.findClientByEmail(loginClient.getEmail());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (client != null && passwordEncoder.matches(loginClient.getPassword(), client.getPassword())) {

            return ResponseEntity.ok(client);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("allClients")
    public List<Client> getAllClients(){ return iClient.findAll();}


    @PostMapping("createClient")
    public Client createClient(@RequestBody Client client){
        if (iClient.existsByEmail(client.getEmail())) {
            throw new CustomException("El email ya está registrado.");
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(client.getPassword());
        client.setPassword(encodedPassword);

        client.setFirstName(client.getFirstName());
        client.setLastName(client.getLastName());
        client.setEmail(client.getEmail());
        client.setPhone(client.getPhone());
        client.setWeight(client.getWeight());
        client.setAge(client.getAge());
        client.setSex(client.getSex());

        contactService.sendSMS(client.getPhone(), "Tu cuenta ha sido creada.");

        contactService.sendEmail(client.getEmail(), "Bienvenido", "<html><body><p>Tu cuenta ha sido creada.</p></body></html>");

        return iClient.save(client);
    }

    @GetMapping("client/byName/{name}")
    public String clientName(@PathVariable(value = "name")String name){
        return iClient.byName(name);}
    @PutMapping("editClient/{id}")
    public ResponseEntity<Client> editClient(@PathVariable(value = "id")Integer id, @RequestBody Client clientUpdate){
        Optional<Client> client = iClient.findById(id);
        client.get().setFirstName(clientUpdate.getFirstName());
        client.get().setLastName(clientUpdate.getLastName());
        client.get().setEmail(clientUpdate.getEmail());
        client.get().setWeight(clientUpdate.getWeight());
        client.get().setAge(clientUpdate.getAge());
        client.get().setSex(clientUpdate.getSex());
        client.get().setHeight(clientUpdate.getHeight());
        client.get().setPhone(clientUpdate.getPhone());
        Client updateClient = iClient.save(client.get());

        return ResponseEntity.ok(updateClient);
    }
    @DeleteMapping("deleteClient/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable(value = "id")Integer id){
        Optional<Client> client = iClient.findById(id);
        if (client.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        iClient.deleteById(id);
        return ResponseEntity.ok(client.get());
    }

}