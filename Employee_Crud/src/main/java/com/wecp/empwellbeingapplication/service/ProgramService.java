package com.wecp.empwellbeingapplication.service;


import com.wecp.empwellbeingapplication.entity.Program;
import com.wecp.empwellbeingapplication.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramService {


    @Autowired
    private ProgramRepository programRepository;

    public Program createProgram(Program program) {
        return programRepository.save(program);
        // create program
    }

    public List<Program> getAllPrograms() {
        return programRepository.findAll();
       // get all program
    }
}