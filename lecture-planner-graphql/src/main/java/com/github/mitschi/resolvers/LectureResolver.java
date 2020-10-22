package com.github.mitschi.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.github.mitschi.models.Employee;
import com.github.mitschi.models.Lecture;
import com.github.mitschi.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * This class resolves values for the Lecture model.
 * By default, in GraphQL the values from the model bean are taken directly, eg. lecture.getName() for name.
 * This Resolver overrides the default bean resolver if something else is needed.
 */
@Component
public class LectureResolver implements GraphQLResolver<Lecture> {

    @Autowired
    private EmployeeService employeeService;

    public Employee getLecturer(Lecture lecture){
        return employeeService.getEmployeeById(lecture.getLecturerId());
    }

}
