package com.github.mitschi.services;

import com.github.mitschi.models.Lecture;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LectureService {
    private final RestTemplate restTemplate;

    @Value("${endpoint.lecture}")
    private String lectureEndpointUrl;

    public LectureService(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    public Lecture[] getLectures(){
        return restTemplate.getForObject(lectureEndpointUrl, Lecture[].class);
    }

    public ResponseEntity<Lecture> addLecture(Lecture l) {
         return restTemplate.postForEntity(lectureEndpointUrl, l, Lecture.class);
    }
}
