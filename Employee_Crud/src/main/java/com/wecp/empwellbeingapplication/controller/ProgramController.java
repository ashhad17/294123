package com.wecp.empwellbeingapplication.controller;


import com.wecp.empwellbeingapplication.entity.Program;
import com.wecp.empwellbeingapplication.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/programs")
public class ProgramController {


  @Autowired
    private ProgramService programService;


    @PostMapping
    public Program createProgram(@RequestBody Program program) {
      // create a program
      return programService.createProgram(program);    }

@GetMapping
    public List<Program> getAllPrograms() {
        // get all programs
        return programService.getAllPrograms();
    }
}