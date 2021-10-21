package ru.digitalleague.universityserver.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import ru.digitalleague.universityserver.model.StudentInfo;
import ru.digitalleague.universityserver.service.StudentServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Контроллер для работы с записями студентов
 */
@Slf4j
@RestController
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    /**
     * Добавление нового студента
     */
    @PostMapping("/addStudent")
    public ResponseEntity<String> addStudent(@RequestBody StudentInfo studentInfo) {
        if (ObjectUtils.isEmpty(studentService.addStudent(studentInfo))) {
            return ResponseEntity.badRequest().body("Студент не добавлен");
        }
        return ResponseEntity.ok("Студент добавлен ");
    }

    /**
     * Получение данных о всех студентах
     */
    @GetMapping("/findAllStudent")
    public ResponseEntity<List> findAllStudent() {
        List<StudentInfo> studentInfos = new ArrayList<>();
        studentInfos = studentService.findAllStudent();
        return ResponseEntity.ok(studentInfos);
    }

    /**
     * Изменение данных студента
     */
    @PutMapping("/updateStudentFirstNameById/{id}")
    public ResponseEntity<String> updateStudentFirstNameById(
            @PathVariable("id") Long id, @RequestBody StudentInfo studentInfo) {

        if (studentService.updateStudentFirstNameById(id, studentInfo.getFirstName()) > 0) {
            return ResponseEntity.ok("Запись студента изменена");
        }

        return ResponseEntity.badRequest().body("Запись студента не изменена");
    }

    /**
     * Удаление записи студента
     */
    @DeleteMapping("/deleteStudentById/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable("id") Long id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.ok("Запись " + id + " удалена");
    }
}