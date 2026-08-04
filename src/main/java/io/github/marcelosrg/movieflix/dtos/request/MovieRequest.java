package io.github.marcelosrg.movieflix.dtos.request;


import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record MovieRequest(String title,
                           String description,
                           LocalDate releaseDate,
                           double rating,
                           List<UUID> categories,
                           List<UUID> streamings) {
}
