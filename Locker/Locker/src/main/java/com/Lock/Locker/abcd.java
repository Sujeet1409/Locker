package com.Lock.Locker;

import com.Lock.Locker.Entity.Client;
import com.Lock.Locker.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class abcd {
}
package com.Lock.Locker.Controller;

import com.Lock.Locker.Entity.Client;
import com.Lock.Locker.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> getAllClients()
    {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id)
    {
        Client client= clientService.getClientById(id);
        return client !=null ? ResponseEntity.ok(client): ResponseEntity.notFound().build();
    }

    @PostMapping
    public Client createClient(@RequestBody Client client)
    {
        return clientService.createClient(client);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }

}
