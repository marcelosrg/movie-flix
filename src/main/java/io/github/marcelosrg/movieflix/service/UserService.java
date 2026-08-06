package io.github.marcelosrg.movieflix.service;

import io.github.marcelosrg.movieflix.dtos.request.UserRequest;
import io.github.marcelosrg.movieflix.dtos.response.UserResponse;
import io.github.marcelosrg.movieflix.entity.User;
import io.github.marcelosrg.movieflix.exception.ConflitException;
import io.github.marcelosrg.movieflix.mapper.UserMapper;
import io.github.marcelosrg.movieflix.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    public UserService(UserRepository userRepository,
                       UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserResponse register(UserRequest userRequest){
        Optional<User> verifyNameAndEmail = this.userRepository.findByEmailAndName(userRequest.email(), userRequest.name());

        if(verifyNameAndEmail.isPresent()) throw new ConflitException("O usuario ou email já estão sendo utilizados!");

        return userMapper.toResponse(userRepository.save(userMapper.toEntity(userRequest)));
    }
}
