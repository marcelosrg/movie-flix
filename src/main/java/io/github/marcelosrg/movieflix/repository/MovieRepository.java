package io.github.marcelosrg.movieflix.repository;

import io.github.marcelosrg.movieflix.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MovieRepository extends JpaRepository<Movie, UUID> {
    @Query("SELECT m FROM Movie m JOIN m.categories c WHERE c.name = :name")
    List<Movie> findByCategoryName(@Param("name") String name);
}
