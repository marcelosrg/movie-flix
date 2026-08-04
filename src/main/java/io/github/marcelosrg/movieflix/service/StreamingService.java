package io.github.marcelosrg.movieflix.service;
import io.github.marcelosrg.movieflix.dtos.request.StreamingRequest;
import io.github.marcelosrg.movieflix.dtos.response.StreamingResponse;
import io.github.marcelosrg.movieflix.entity.Streaming;
import io.github.marcelosrg.movieflix.exception.NotFoundException;
import io.github.marcelosrg.movieflix.mapper.StreamingMapper;
import io.github.marcelosrg.movieflix.repository.StreamingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StreamingService {

    private final StreamingRepository streamingRepository;
    private final StreamingMapper streamingMapper;

    public StreamingService(StreamingRepository streamingRepository, StreamingMapper streamingMapper) {
        this.streamingRepository = streamingRepository;
        this.streamingMapper = streamingMapper;
    }


    public List<StreamingResponse> findAll(){
        return streamingMapper.toResponseList( streamingRepository.findAll());
    }


    public StreamingResponse createStreaming(StreamingRequest streamingRequest) {
        return streamingMapper.toResponse(streamingRepository.save(streamingMapper.toStreaming(streamingRequest)));
    }

    public StreamingResponse findById(UUID id){
        return streamingMapper.toResponse(streamingRepository.findById(id).orElseThrow(() -> new NotFoundException("Streaming não encontrada!")));
    }

    public void deleteStreaming(UUID id){
        Streaming streaming = streamingRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Streaming não encontrada!"));
        streamingRepository.deleteById(id);
    }
}
