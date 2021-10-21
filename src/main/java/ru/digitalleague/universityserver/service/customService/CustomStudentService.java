package ru.digitalleague.universityserver.service.customService;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CustomStudentService {
    @Modifying
    @Query(value = "update StudentInfo s set s.firstName = :name where s.studentId = :id")
    int updateStudentFirstNameById(@Param("id") Long id, @Param("name") String name);
}
