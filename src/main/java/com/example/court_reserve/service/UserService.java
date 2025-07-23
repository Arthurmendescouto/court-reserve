package com.example.court_reserve.service;

import com.example.court_reserve.controller.request.UserRequest;
import com.example.court_reserve.entity.User;
import com.example.court_reserve.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public List<User> findAll(){
        return repository.findAll();
    }

    public Optional<User> findById(Long id){
        return repository.findById(id);
    }

    public User save(User user){
        String password=user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        return repository.save(user);
    }

    public void  delete(Long id){
        repository.deleteById(id);
    }
    public void updatePassword(Long id, String newPassword) {
        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        String encodedPassword=passwordEncoder.encode(newPassword);

        user.setPassword(encodedPassword);

        repository.save(user);
    }
}
