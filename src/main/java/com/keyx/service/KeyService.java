package com.keyx.service;

import com.keyx.exception.KeyNotFoundException;
import com.keyx.model.Key;
import com.keyx.repository.KeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeyService {

    @Autowired
    private KeyRepository keyRepository;

    public List<Key> getAllKeys() {
        return keyRepository.findAll();
    }

    public Key createKey(Key key) {
        return keyRepository.save(key);
    }

    public Key getKeyById(Long id) {
        return keyRepository.findById(id)
                .orElseThrow(() -> new KeyNotFoundException("Key not found with ID: " + id));
    }

    public void deleteKey(Long id) {
        keyRepository.deleteById(id);
    }
}
