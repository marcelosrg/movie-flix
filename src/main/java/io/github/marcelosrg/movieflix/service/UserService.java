package io.github.marcelosrg.movieflix.service;

import io.github.marcelosrg.movieflix.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



}
