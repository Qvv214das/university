package ru.digitalleague.universityserver.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "teacher")
public class TeacherInfo {
    /**
     * Идентификатор
     */
    @Id
    @Column(name = "teacher_id")
    private Long teacherId;
    /**
     * Имя
     */
    @Column(name = "first_name")
    private String firstName;
    /**
     * Фамилия
     */
    @Column(name = "last_name")
    private String lastName;
    /**
     * Отчество
     */
    @Column(name = "middle_name")
    private String middleName;
    /**
     * Кафедра
     */
    @Column(name = "chair")
    private String chair;
}
