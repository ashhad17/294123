package com.wecp.empwellbeingapplication.repository;

import com.wecp.empwellbeingapplication.entity.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramRepository extends JpaRepository<Program,Long> {
    // extends jpa repository
}