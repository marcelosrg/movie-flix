package io.github.marcelosrg.movieflix.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import io.github.marcelosrg.movieflix.configuration.auth.TokenService;
import io.github.marcelosrg.movieflix.dtos.request.LoginRequest;
import io.github.marcelosrg.movieflix.dtos.request.UserRequest;
import io.github.marcelosrg.movieflix.dtos.response.LoginResponse;
import io.github.marcelosrg.movieflix.dtos.response.UserResponse;
import io.github.marcelosrg.movieflix.entity.User;
import io.github.marcelosrg.movieflix.exception.ConflitException;
import io.github.marcelosrg.movieflix.mapper.UserMapper;
import io.github.marcelosrg.movieflix.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class UserService  {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    public UserService(UserRepository userRepository,
                       UserMapper userMapper,
                       PasswordEncoder passwordEncoder,
                       AuthenticationManager authenticationManager,
                       TokenService tokenService) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }



    public UserResponse register(UserRequest userRequest){
        Optional<User> verifyNameAndEmail = this.userRepository.findByEmailAndName(userRequest.email(), userRequest.name());

        if(verifyNameAndEmail.isPresent()) throw new ConflitException("O usuario ou email já estão sendo utilizados!");

        User user = userMapper.toEntity(userRequest);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userMapper.toResponse(userRepository.save(user));
    }

    public LoginResponse login(LoginRequest loginRequest){
        UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password());
        Authentication authentication = authenticationManager.authenticate(userAndPass);

        User user = (User) authentication.getPrincipal();
        String token = tokenService.generateToken(user);

        return new LoginResponse(token);

    }



}
