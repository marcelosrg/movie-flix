package io.github.marcelosrg.movieflix.mapper;
import io.github.marcelosrg.movieflix.dtos.request.StreamingRequest;
import io.github.marcelosrg.movieflix.dtos.response.StreamingResponse;
import io.github.marcelosrg.movieflix.entity.Streaming;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StreamingMapper {

    public Streaming toStreaming(StreamingRequest streamingRequest){
        Streaming streaming = new Streaming();
        streaming.setName(streamingRequest.name());

        return streaming;
    }

    public StreamingResponse toResponse(Streaming streaming) {
        return new StreamingResponse(
                streaming.getId(),
                streaming.getName());
    }

    public List<StreamingResponse> toResponseList(List<Streaming> streaming) {
        return streaming.stream()
                .map(this::toResponse)
                .toList();
    }
}
