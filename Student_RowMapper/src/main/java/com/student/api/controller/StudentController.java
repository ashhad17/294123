package com.student.api.controller;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.student.api.domain.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing student system process. Use {@link StudentRowMapper} to map database rows to Student entity object.
 */
@RestController
@RequestMapping("/api/v1")
public class StudentController {

    // use JdbcTemplate to query for students aganist database

    @Autowired
    private  JdbcTemplate jdbcTemplate;
    // private final NamedParameterJdbcTemplate jdbcTemplate;


   

    /**
     * {@code GET  /students} : get all the Students.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list
     * of students in body.
     */
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        String sql="SELECT * FROM student";
        
        return ResponseEntity.ok().body(jdbcTemplate.query(sql,new StudentRowMapper()));
    }

    /**
     * {@code GET  /students/:id} : get the "id" Student.
     *
     * @param id the id of the student to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
     * the student, or if does not exist, return with status "noContent".
     */
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        try{
            String sql="SELECT * FROM student WHERE id= ?";
            Student student=jdbcTemplate.queryForObject(sql,new StudentRowMapper(),id);
            return ResponseEntity.ok().body(student);
        }
        catch(EmptyResultDataAccessException e){
            return ResponseEntity.noContent().build();
        }
        
       
        
     }

    /**
     * {@code POST  /student} : Create a new student.
     *
     * @param student the student to create.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with
     * body the new student
     */
    @PostMapping("/students")
    public ResponseEntity<Void> createStudent(@RequestBody Student student) {
        String sql="INSERT INTO student (id,name) VALUES (?,?)";
        jdbcTemplate.update("INSERT INTO student (id,name) VALUES (?,?)", student.getId(),student.getName());
        return ResponseEntity.ok().build();
    }

    /**
     * {@code PUT  /student} : Updates an existing student.
     *
     * @param student the student to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
     * the updated student.
     */
    @PutMapping("/students")
    public ResponseEntity<Void> updateStudent(@RequestBody Student student) {
        String sql="UPDATE student SET name= ? WHERE id = ?";
        jdbcTemplate.update(sql, student.getName(),student.getId());
        return ResponseEntity.ok().build();
    }

    /**
     * {@code DELETE  /student/:id} : delete the "id" student.
     *
     * @param id the id of the student to delete.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)}.
     */
    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        String sql="DELETE FROM student WHERE id = ?";
        int row=jdbcTemplate.update(sql, id);
        if(row>0){
            return ResponseEntity.ok().build();
        }
        else{
            return ResponseEntity.noContent().build();
        }

    }

}