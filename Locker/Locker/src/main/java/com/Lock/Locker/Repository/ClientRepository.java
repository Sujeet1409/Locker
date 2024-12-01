package com.Lock.Locker.Repository;

import com.Lock.Locker.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
