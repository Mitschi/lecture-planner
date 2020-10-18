package com.github.mitschi.controllers;

import com.github.mitschi.models.Employee;
import com.github.mitschi.models.Lecture;
import com.github.mitschi.services.EmployeeService;
import com.github.mitschi.services.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private LectureService lectureService;

    @GetMapping("/")
    public String main(Model model){
        Employee[] employees = employeeService.getEmployees();
        Lecture[] lectures = lectureService.getLectures();

        model.addAttribute("employees", employees);
        model.addAttribute("lectures", lectures);

        return "index";
    }

}