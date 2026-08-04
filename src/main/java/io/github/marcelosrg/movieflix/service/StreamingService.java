package io.github.marcelosrg.movieflix.service;

import io.github.marcelosrg.movieflix.repository.StreamingRepository;
import org.springframework.stereotype.Service;

@Service
public class StreamingService {

    private final StreamingRepository streamingRepository;

    public StreamingService(StreamingRepository streamingRepository) {
        this.streamingRepository = streamingRepository;
    }
}
