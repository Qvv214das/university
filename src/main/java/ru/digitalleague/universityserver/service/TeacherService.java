package ru.digitalleague.universityserver.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.digitalleague.universityserver.model.TeacherInfo;
import ru.digitalleague.universityserver.service.customService.CustomTeacherService;

@Repository
public interface TeacherService extends CrudRepository<TeacherInfo, Long>, CustomTeacherService {
}
