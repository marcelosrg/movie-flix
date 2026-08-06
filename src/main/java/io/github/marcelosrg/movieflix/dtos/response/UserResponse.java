package io.github.marcelosrg.movieflix.dtos.response;

import java.util.UUID;

public record UserResponse(UUID id,
                           String name,
                           String email) {
}
