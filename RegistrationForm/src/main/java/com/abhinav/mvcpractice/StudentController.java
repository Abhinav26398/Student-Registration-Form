package com.abhinav.mvcpractice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    @Value("${countries}")
    List<String>countries;
    @Value("${languages}")
    List<String>languages;
    @Value("${favos}")
    List<String>favos;

    @GetMapping("/showInputForm")
    public String showForm(Model model){
        Student student=new Student();
        model.addAttribute("student" , student);
        model.addAttribute("countries", countries);
        model.addAttribute("languages", languages);
        model.addAttribute("favos",favos);
        return "studentInput";
    }

    @PostMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student student){
        System.out.println("Student Full Name is : "+student.getFirstName()+" "+student.getLastName());
        return "processedForm";
    }
}
