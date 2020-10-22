package com.github.mitschi.controllers;

import com.github.mitschi.models.Employee;
import com.github.mitschi.models.Lecture;
import com.github.mitschi.services.graphql.GraphQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class MainController {

    @Autowired
    private GraphQLService graphqlService;

    @GetMapping("/")
    public String main(Model model) {
        // TODO better error handling
        Employee[] employees;
        try {
            employees = graphqlService.getEmployees();
        } catch (Exception e) {
            employees = new Employee[0];
        }
        model.addAttribute("employees", employees);

        Lecture[] lectures;
        try {
            lectures = graphqlService.getLectures();
        } catch (Exception e) {
            lectures = new Lecture[0];
        }
        model.addAttribute("lectures", lectures);

        return "index";
    }

    @GetMapping("/addEmployee")
    public RedirectView addEmployee(@RequestParam("pEmpName") String name,
                                    @RequestParam("pEmpNum") int num,
                                    Model model) {
        Employee e = new Employee(name, num);
        graphqlService.addEmployee(e);

        // redirect back to home
        return new RedirectView("/");
    }

    @GetMapping("/addLecture")
    public RedirectView addEmployee(@RequestParam("pLecName") String name,
                                    @RequestParam("pLecNum") String num,
                                    @RequestParam("pLecEmpId") long empId,
                                    Model model) {
        Lecture l = new Lecture(name, num, empId);
        graphqlService.addLecture(l);

        // redirect back to home
        return new RedirectView("/");
    }

}