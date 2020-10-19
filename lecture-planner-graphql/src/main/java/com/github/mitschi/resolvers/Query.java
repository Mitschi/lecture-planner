package com.github.mitschi.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.github.mitschi.models.Employee;
import com.github.mitschi.models.Lecture;
import com.github.mitschi.services.EmployeeService;
import com.github.mitschi.services.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private LectureService lectureService;

    public Lecture lectureById(Integer id){
        return lectureService.getLectureById(id);
    }

}
