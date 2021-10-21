package ru.digitalleague.universityserver.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import ru.digitalleague.universityserver.model.TeacherInfo;
import ru.digitalleague.universityserver.service.TeacherServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Контроллер для работы с учителями
 */
@Slf4j
@RestController
public class TeacherController {

    @Autowired
    private TeacherServiceImpl teacherService;

    /**
     * Добавление нового преподавателя
     */
    @PostMapping("/addTeacher")
    public ResponseEntity<String> addTeacher(@RequestBody TeacherInfo teacherInfo) {
        if (ObjectUtils.isEmpty(teacherService.addTeacher(teacherInfo))) {
            return ResponseEntity.badRequest().body("Учитель не добавлен");
        }
        return ResponseEntity.ok("Учитель добавлен ");
    }
    /**
     * Получение данных о всех преподавателях
     */
    @GetMapping("/findAllTeacher")
    public ResponseEntity<List> findAllTeacher() {
        List<TeacherInfo> teacherInfos = new ArrayList<>();
        teacherInfos = teacherService.findAllTeacher();
        return ResponseEntity.ok(teacherInfos);
    }
    /**
     * Изменение данных преподавателя
     */
    @PutMapping("/updateTeacherFirstNameById/{id}")
    public ResponseEntity<String> updateTeacherFirstNameById(
            @PathVariable("id") Long id, @RequestBody TeacherInfo teacherInfo) {

        if (teacherService.updateTeacherFirstNameById(id, teacherInfo.getFirstName()) > 0) {
            return  ResponseEntity.ok("Запись преподавателя изменена");
        }

        return ResponseEntity.badRequest().body("Запись преподавателя не изменена");
    }

    /**
     * Удаление записи преподавателя
     */
    @DeleteMapping("/deleteTeacherById/{id}")
    public ResponseEntity<String> deleteteacherById(@PathVariable("id") Long id) {
        teacherService.deleteTeacherById(id);
        return ResponseEntity.ok("Запись " + id + " удалена");
    }

}
