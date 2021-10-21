package ru.digitalleague.universityserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.digitalleague.universityserver.model.TeacherInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Сервис для работы с данными преподавателей
 */
@Service
public class TeacherServiceImpl {

    @Autowired
    private TeacherService teacherService;

    public TeacherInfo addTeacher(TeacherInfo teacherInfo) {
        return teacherService.save(teacherInfo);
    }

    public List<TeacherInfo> findAllTeacher() {
        List<TeacherInfo> teacherInfos = new ArrayList<>();
        teacherService.findAll().forEach(teacherInfos::add);
        return teacherInfos;
    }

    public int updateTeacherFirstNameById(Long id, String firstName) {
        return teacherService.updateTeacherFirstNameById(id, firstName);
    }

    public void deleteTeacherById(Long id) {
        teacherService.deleteById(id);
    }
}
