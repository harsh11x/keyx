package com.keyx.controller;

import com.keyx.model.Key;
import com.keyx.service.KeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/keys")
public class KeyController {

    @Autowired
    private KeyService keyService;

    @GetMapping
    public List<Key> getAllKeys() {
        return keyService.getAllKeys();
    }

    @PostMapping
    public ResponseEntity<Key> createKey(@RequestBody Key key) {
        Key createdKey = keyService.createKey(key);
        return new ResponseEntity<>(createdKey, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Key> getKeyById(@PathVariable Long id) {
        Key key = keyService.getKeyById(id);
        return new ResponseEntity<>(key, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKey(@PathVariable Long id) {
        keyService.deleteKey(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
