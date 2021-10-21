package ru.digitalleague.universityserver.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.digitalleague.universityserver.model.StudentInfo;
import ru.digitalleague.universityserver.service.customService.CustomStudentService;

@Repository
public interface StudentService extends CrudRepository<StudentInfo, Long>, CustomStudentService {

}
