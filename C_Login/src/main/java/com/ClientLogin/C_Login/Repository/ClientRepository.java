package com.ClientLogin.C_Login.Repository;

import com.ClientLogin.C_Login.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
    ClientEntity findByUserId(String userId);
    ClientEntity findByEmail(String email);
}
