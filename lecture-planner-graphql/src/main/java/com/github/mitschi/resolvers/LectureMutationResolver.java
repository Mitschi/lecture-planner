package com.github.mitschi.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.github.mitschi.models.Lecture;
import com.github.mitschi.models.dto.LectureInput;
import com.github.mitschi.services.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LectureMutationResolver implements GraphQLMutationResolver {

    @Autowired
    private LectureService lectureService;

    public Lecture createLecture(LectureInput input) {
        return lectureService.addLecture(createLectureFromInput(input));
    }

    public Lecture updateLecture(long id, LectureInput input) {
        Lecture l = createLectureFromInput(input);
        lectureService.updateLecture(id, l);
        return l;
    }

    public int deleteLecture(long id) {
        lectureService.deleteLecture(id);
        // TODO error handling
        return 1;
    }

    private Lecture createLectureFromInput(LectureInput input) {
        return new Lecture(input.getName(), input.getNumber(), input.getLecturerId());
    }
}
