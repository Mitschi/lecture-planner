package com.github.mitschi.services;

import com.github.mitschi.models.Lecture;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class LectureService {
    private final RestTemplate restTemplate;

    @Value("${endpoint.lecture}")
    private String lectureEndpointUrl;

    public LectureService(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    public Lecture[] getLectures() {
        return restTemplate.getForObject(lectureEndpointUrl, Lecture[].class);
    }

    public Lecture getLectureById(long id) throws RestClientException {
        return restTemplate.getForObject(lectureEndpointUrl+"/"+id, Lecture.class);
    }

    public Lecture addLecture(Lecture l) {
        ResponseEntity<Lecture> response = restTemplate.postForEntity(lectureEndpointUrl, l, Lecture.class);
        return response.getBody();
    }

    public void updateLecture(long id, Lecture l) throws RestClientException {
        restTemplate.put(lectureEndpointUrl + '/' + id, l);
    }

    public void deleteLecture(long id) throws RestClientException {
        restTemplate.delete(lectureEndpointUrl + '/' + id);
    }
}
