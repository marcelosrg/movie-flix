package io.github.marcelosrg.movieflix.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="movie")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private  String title;
    private  String description;
    private  double rating;

    @Column(name= "release_date")
    private LocalDate releaseDate;

    @Column(name= "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name= "updated_at")
    private LocalDateTime updatedAt;


    @ManyToMany()
    @JoinTable(name="movie_category",
                joinColumns = @JoinColumn(name = "movie_id"),
                inverseJoinColumns = @JoinColumn(name="category_id"))

    private List<Category> categories;


    @ManyToMany()
    @JoinTable(name="movie_streaming",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name="streaming_id"))
    private List<Streaming> streamings;
}
