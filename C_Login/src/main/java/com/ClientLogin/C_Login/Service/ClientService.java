package com.ClientLogin.C_Login.Service;

import com.ClientLogin.C_Login.Repository.ClientRepository;
import com.ClientLogin.C_Login.entity.ClientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public ClientEntity register(ClientEntity user)
    {
        if (clientRepository.findByEmail(user.getUserId()) !=null || clientRepository.findByEmail(user.getEmail())!=null)
        {
            throw new DuplicateClientException("A user with this email already exists.");
        }
        return clientRepository.save(user);
    }
    public  ClientEntity login(String userId, String password)
    {
        ClientEntity user =clientRepository.findByEmail(userId);
        if (user !=null && user.getPassword().equals(password))
        {
            return user;
        }
        return null;
    }
}
