package ru.digitalleague.universityserver.service.customService;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.digitalleague.universityserver.model.StudentInfo;

import javax.transaction.Transactional;

/**
 * Кастомный репозиторий для работы с преподавателями
 */
@Repository
@Transactional
public interface CustomTeacherService {

    @Modifying
    @Query(value = "update TeacherInfo t set t.firstName = :name where t.teacherId = :id")
    int updateTeacherFirstNameById(@Param("id") Long id, @Param("name") String name);

    @Query(value = "select from ")
    Iterable<StudentInfo> getListStudent(@Param("id") Long id);
}
