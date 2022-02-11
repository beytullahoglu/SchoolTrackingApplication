package SchoolTrackingApp;

import javax.persistence.Entity;

import java.util.Date;
import java.text.SimpleDateFormat;

@Entity
class Student extends SchoolMember{

  private int studentNumber;
  private double grade;

  Student(){super();}

  Student(Integer id, String name, String surName, int age, int studentNumber, double grade){        
    super(id, name, surName, age);
    this.studentNumber = studentNumber;
    this.grade = grade;
  }

  Student(Integer id, String name, String surName){
    super(id,name, surName);
  }

  Student(Integer id){
    super(id);
  }

  Student(SchoolMember member, int studentNumber, double grade){
    super(member);
    this.studentNumber = studentNumber;
    this.grade = grade;
  }

  public int getStudentNumber() {return this.studentNumber;}

  public double getGrade() {return this.grade;}

  public void setStudentNumber(int studentNumber){
    this.studentNumber = studentNumber;
    this.updatedAt = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
  }
  
  public void setGrade(double grade) {
    this.grade = grade;
    this.updatedAt = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
  }
}