package io.github.marcelosrg.movieflix.dtos.request;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record MovieRequest(String title,
                           String description,

                           @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                           LocalDate releaseDate,
                           double rating,
                           List<UUID> categories,
                           List<UUID> streamings) {
}
