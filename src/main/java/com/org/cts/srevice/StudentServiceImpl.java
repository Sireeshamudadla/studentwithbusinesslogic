package com.org.cts.srevice;

import com.org.cts.exception.StudentException;
import com.org.cts.model.Student;
import com.org.cts.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepo studentRepo;


    @Override
    public void createStudent(Student student) {
        studentRepo.save(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentRepo.save(student);
    }

    @Override
    public void deleteByStudentId(Integer id) {
        studentRepo.deleteById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Double findByAddressGetSumOfMarkes(String address) throws StudentException {
        double sumOfMarks = 0;
        List<Student> list = studentRepo.findByAddress(address);

        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {

                Student student = list.get(i);
                Double marks = student.getMarks();

                sumOfMarks = sumOfMarks + marks;
            }
        } else {
           throw new StudentException("this name dont not contains marks");
        }
        return sumOfMarks;
    }

}
