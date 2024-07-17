package com.products.products_ms.services;

import com.products.products_ms.entities.User;
import com.products.products_ms.exceptions.UserAlreadyExistsException;
import com.products.products_ms.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = userRepository.findById(id);
        return obj.get();
    }

    public User createUser (User user){
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new UserAlreadyExistsException("O e-mail já está em uso.");
        }
        if (userRepository.existsByCpf(user.getCpf())){
            throw new UserAlreadyExistsException("O CPF já está em uso.");
        }
        return userRepository.save(user);
    }

    public User editUser(User user) {
        User existingUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado."));

        if (!isUnique(user.getId(), user.getEmail(), user.getCpf())) {
            throw new IllegalArgumentException("CPF ou e-mail estão sendo utilizados por outro usuário.");
        }

        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setCpf(user.getCpf());
        existingUser.setPhone(user.getPhone());

        return userRepository.save(existingUser);
    }

    private boolean isUnique(Long userId, String email, String cpf) {

        User userByEmail = userRepository.findByEmail(email);
        if (userByEmail != null && !userByEmail.getId().equals(userId)) {
            return false;
        }

        User userByCpf = userRepository.findByCpf(cpf);
        if (userByCpf != null && !userByCpf.getId().equals(userId)) {
            return false;
        }


        return true;
    }
}
