package com.github.mitschi.controllers;

import com.github.mitschi.IllegalResourceException;
import com.github.mitschi.ResourceNotFoundException;
import com.github.mitschi.models.Lecture;
import com.github.mitschi.models.validation.LectureValidator;
import com.github.mitschi.repositories.LectureDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("/lectures")
public class LectureController {
    private static final Logger LOG = LoggerFactory.getLogger(LectureController.class);

    @Autowired
    private LectureDao lectureDao;

    @Autowired
    private LectureValidator validator;

    @GetMapping()
    public List<Lecture> listLectures() {
        return lectureDao.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lecture> getLectureById(@PathVariable("id") Long id)
            throws ResourceNotFoundException {

        Lecture l = lectureDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lecture not found for id: " + id));
        return ResponseEntity.ok(l);
    }

    @PostMapping()
    public Lecture createLecture(@RequestBody Lecture lecture) throws IllegalResourceException {
        if (!validator.isLectureValid(lecture))
            throw new IllegalResourceException("Lecture values are not valid");

        return lectureDao.save(lecture);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lecture> updateLecture(@PathVariable("id") Long id,
                                                 @RequestBody Lecture lectureDto)
            throws ResourceNotFoundException, IllegalResourceException {
        if (!validator.isLectureValid(lectureDto))
            throw new IllegalResourceException("Lecture values are not valid");

        Lecture origLecture = lectureDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lecture not found for id: " + id));

        origLecture.updateFromDto(lectureDto);

        Lecture updatedLecture = lectureDao.save(origLecture);
        return ResponseEntity.ok(updatedLecture);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteLecture(@PathVariable("id") Long id)
            throws ResourceNotFoundException {

        Lecture origLecture = lectureDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lecture not found for id: " + id));

        lectureDao.delete(origLecture);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
