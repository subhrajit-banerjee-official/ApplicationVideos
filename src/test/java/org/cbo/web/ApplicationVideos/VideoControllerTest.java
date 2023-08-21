package org.cbo.web.ApplicationVideos;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class VideoControllerTest {
    private final VideoRepository videoRepository = Mockito.mock(VideoRepository.class);
    private final VideoController videoController = new VideoController(videoRepository);

    @Test
    public void testGetVideos() {
        // given
        List<Video> videos = List.of(new Video(1L, "desc1", "name1", null, "url1"));
        when(videoRepository.findAll()).thenReturn(videos);

        // when
        ResponseEntity<List<Video>> response = videoController.getVideos();

        // then
        assertEquals(videos, response.getBody());
    }
}

