package ru.digitalleague.universityserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.digitalleague.universityserver.model.StudentInfo;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl {

    @Autowired
    private StudentService studentService;

    public StudentInfo addStudent(StudentInfo studentInfo) {
        return studentService.save(studentInfo);
    }

    public List<StudentInfo> findAllStudent() {
        List<StudentInfo> studentInfos = new ArrayList<>();
        studentService.findAll().forEach(studentInfos::add);
        return studentInfos;
    }

    public int updateStudentFirstNameById(Long id, String firstName) {
        return studentService.updateStudentFirstNameById(id, firstName);
    }

    public void deleteStudentById(Long id) {
        studentService.deleteById(id);
    }
}
