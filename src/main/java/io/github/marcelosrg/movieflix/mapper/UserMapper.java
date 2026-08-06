package io.github.marcelosrg.movieflix.mapper;
import io.github.marcelosrg.movieflix.dtos.request.UserRequest;
import io.github.marcelosrg.movieflix.dtos.response.UserResponse;
import io.github.marcelosrg.movieflix.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMapper {

    public User toEntity(UserRequest userRequest){
        User user = new User();
        user.setName(userRequest.name());
        user.setEmail(userRequest.email());
        user.setPassword(userRequest.password());

        return user;
    }

    public UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail());
    }

    public List<UserResponse> toResponseList(List<User> user) {
        return user.stream()
                .map(this::toResponse)
                .toList();
    }

}
