package com.Lock.Locker.Controller;

import com.Lock.Locker.Entity.Locker;
import com.Lock.Locker.Service.LockerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/lockers")
public class LockerController {

    @Autowired
    private LockerService lockerService;

    @GetMapping
    public List<Locker> getAllLockers()
    {
        return lockerService.getAllLockers();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Locker> getLockerById(@PathVariable Long id)
    {
        Locker locker = lockerService.getLockerById(id);
        return locker != null ?  ResponseEntity.ok(locker) : ResponseEntity.notFound().build();
    }
    @PostMapping
    public Locker createLocker(@RequestBody Locker locker) {
        return lockerService.createLocker(locker);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocker(@PathVariable Long id) {
        lockerService.deleteLocker(id);
        return ResponseEntity.noContent().build();
    }
}
