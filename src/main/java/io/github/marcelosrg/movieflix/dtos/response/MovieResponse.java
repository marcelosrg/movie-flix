package io.github.marcelosrg.movieflix.dtos.response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record MovieResponse(UUID id,
                            String title,
                            String description,
                            LocalDate releaseDate,
                            double rating,
                            List<CategoryResponse> categories,
                            List<StreamingResponse> streamings,
                            LocalDateTime createdAt,
                            LocalDateTime updatedAt) {
}
