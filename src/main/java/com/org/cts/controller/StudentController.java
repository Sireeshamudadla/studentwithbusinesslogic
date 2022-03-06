package com.org.cts.controller;

import com.org.cts.exception.StudentException;
import com.org.cts.model.Student;
import com.org.cts.srevice.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentService studentService;


    @PostMapping("/create")
    public void createStudent(@RequestBody Student student){
        studentService.createStudent(student);
    }

    @PutMapping("/update")
    public void updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);

    }
    @DeleteMapping("/delete/{id}")
    public void deleteByStudentId(@PathVariable Integer id){
        studentService.deleteByStudentId(id);
    }
    @GetMapping("/getAllStudents")
    public List<Student>getAllStudents(){
        List<Student>list=studentService.getAllStudents();
        return list;

    }


    @GetMapping("/getByAddress/{address}")
    public Double findByAddressGetSumOfMarkes(@PathVariable String address) throws StudentException {
        Double aDouble=studentService.findByAddressGetSumOfMarkes(address);

        return aDouble;
    }

}
