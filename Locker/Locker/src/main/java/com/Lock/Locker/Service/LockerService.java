package com.Lock.Locker.Service;

import com.Lock.Locker.Entity.Locker;
import com.Lock.Locker.Repository.LockerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LockerService {

    @Autowired
    private LockerRepository lockerRepository;

    public List<Locker> getAllLockers()
    {
        return lockerRepository.findAll();
    }
    public Locker getLockerById(Long id) {
        return lockerRepository.findById(id).orElse(null);
    }

    public Locker createLocker(Locker locker) {
        return lockerRepository.save(locker);
    }

    public void deleteLocker(Long id) {
        lockerRepository.deleteById(id);
    }
}
