package io.github.marcelosrg.movieflix.repository;
import io.github.marcelosrg.movieflix.entity.Streaming;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StreamingRepository extends JpaRepository<Streaming, UUID> {
}
