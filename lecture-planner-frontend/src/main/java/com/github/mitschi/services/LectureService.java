package com.github.mitschi.services;

import com.github.mitschi.models.Lecture;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LectureService {
    private final RestTemplate restTemplate;
    private final String lectureEndpointUrl = "http://localhost:8082/lectures";

    public LectureService(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    public Lecture[] getLectures(){
        return restTemplate.getForObject(lectureEndpointUrl, Lecture[].class);
    }
}
