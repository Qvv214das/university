package ru.digitalleague.universityserver.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "student")
public class StudentInfo {
    /**
     * Идентификатор
     */
    @Id
    @Column(name = "student_id")
    private Long studentId;
    /**
     * Имя
     */
    @Column
    private String firstName;
    /**
     * Фамилия
     */
    @Column
    private String lastName;
    /**
     * Отчество
     */
    @Column
    private String middleName;
    /**
     * Курс
     */
    @Column
    private int course;
    /**
     * Специальность
     */
    @Column
    private String speciality;
}
