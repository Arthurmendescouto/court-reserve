package com.example.court_reserve.service;

import com.example.court_reserve.entity.User;
import com.example.court_reserve.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public Optional<User> findById(Long id){
        return repository.findById(id);
    }

    public User saveUser(User user){
        return repository.save(user);
    }

    public void  deleteByUser(Long id){
        repository.deleteById(id);
    }
}
