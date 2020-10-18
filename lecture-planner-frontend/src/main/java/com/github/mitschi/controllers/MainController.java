package com.github.mitschi.controllers;

import com.github.mitschi.models.Employee;
import com.github.mitschi.models.Lecture;
import com.github.mitschi.services.EmployeeService;
import com.github.mitschi.services.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

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

    @GetMapping("/addEmployee")
    public RedirectView addEmployee(@RequestParam("pEmpName") String name,
                                    @RequestParam("pEmpNum") int num,
                                    Model model){
        Employee e = new Employee(name, num);
        employeeService.addEmployee(e);

        // redirect back to home
        return new RedirectView("/");
    }

    @GetMapping("/addLecture")
    public RedirectView addEmployee(@RequestParam("pLecName") String name,
                                    @RequestParam("pLecNum") String num,
                                    @RequestParam("pLecEmpId") long empId,
                                    Model model){
        Lecture l = new Lecture(name, num, empId);
        lectureService.addLecture(l);

        // redirect back to home
        return new RedirectView("/");
    }

}