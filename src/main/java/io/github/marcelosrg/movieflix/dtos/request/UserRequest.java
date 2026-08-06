package io.github.marcelosrg.movieflix.dtos.request;

import java.util.UUID;

public record UserRequest(String name,
                          String email,
                          String password) {
}
