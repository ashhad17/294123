package com.wecp.empwellbeingapplication.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Program {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long programId;
   private String programName;
   private String programDescription;
   private Date startDate;

   private Date endDate;

   @ManyToOne
   @JoinColumn(name = "employee_id")
   private Employee employee;

   public Program() {
   }

   public Program(Long programId, String programName, String programDescription, Date startDate, Date endDate,
         Employee employee) {
      this.programId = programId;
      this.programName = programName;
      this.programDescription = programDescription;
      this.startDate = startDate;
      this.endDate = endDate;
      this.employee = employee;
   }

   public Long getProgramId() {
      return programId;
   }

   public void setProgramId(Long programId) {
      this.programId = programId;
   }

   public String getProgramName() {
      return programName;
   }

   public void setProgramName(String programName) {
      this.programName = programName;
   }

   public String getProgramDescription() {
      return programDescription;
   }

   public void setProgramDescription(String programDescription) {
      this.programDescription = programDescription;
   }

   public Date getStartDate() {
      return startDate;
   }

   public void setStartDate(Date startDate) {
      this.startDate = startDate;
   }

   public Date getEndDate() {
      return endDate;
   }

   public void setEndDate(Date endDate) {
      this.endDate = endDate;
   }

   public Employee getEmployee() {
      return employee;
   }

   public void setEmployee(Employee employee) {
      this.employee = employee;
   }

   
   
   // implement entity here
}