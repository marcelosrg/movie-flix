package io.github.marcelosrg.movieflix.contorller;

import io.github.marcelosrg.movieflix.dtos.request.StreamingRequest;
import io.github.marcelosrg.movieflix.dtos.response.StreamingResponse;
import io.github.marcelosrg.movieflix.service.StreamingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/movieflix/streaming")
public class StreamingController {

    private final StreamingService streamingService;
    public StreamingController(StreamingService streamingService) {
        this.streamingService = streamingService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingResponse> findStreamingById(@PathVariable UUID id) {
        StreamingResponse streaming = streamingService.findById(id);
        return ResponseEntity.ok(streaming);

    }

    @GetMapping()
    public ResponseEntity<List<StreamingResponse>> findAllStreaming() {
        List<StreamingResponse> streamings = streamingService.findAll();
        return ResponseEntity.ok(streamings);
    }

    @PostMapping()
    public ResponseEntity<StreamingResponse> createStreaming(@RequestBody StreamingRequest streamingRequest) {
        StreamingResponse response = streamingService.createStreaming(streamingRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StreamingResponse> deleteStreamingById(@PathVariable UUID id) {
        streamingService.deleteStreaming(id);
        return ResponseEntity.noContent().build();
    }

}
