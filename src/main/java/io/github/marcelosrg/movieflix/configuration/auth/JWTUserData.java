package io.github.marcelosrg.movieflix.configuration.auth;

import lombok.Builder;

import java.util.UUID;
@Builder
public record JWTUserData (UUID id,
                           String name,
                           String email){
}
