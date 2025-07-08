package com.example.court_reserve.service;

import com.example.court_reserve.controller.request.UserRequest;
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

    public User save(User user){
        return repository.save(user);
    }

    public void  delete(Long id){
        repository.deleteById(id);
    }
    public void updatePassword(Long id, UserRequest request) {
        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (request.password() == null || request.password().isBlank()) {
            throw new IllegalArgumentException("Senha não pode ser vazia");
        }
        user.setPassword(request.password());

        repository.save(user);
    }
}
