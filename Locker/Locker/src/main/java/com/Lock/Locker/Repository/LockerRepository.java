package com.Lock.Locker.Repository;

import com.Lock.Locker.Entity.Locker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LockerRepository extends JpaRepository<Locker, Long> {
}
