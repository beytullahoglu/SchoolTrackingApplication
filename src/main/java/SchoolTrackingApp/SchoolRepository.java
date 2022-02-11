package SchoolTrackingApp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

interface SchoolRepository extends JpaRepository <SchoolMember, Integer> {

@Query("SELECT m FROM SchoolMember m WHERE m.name = ?1 AND m.surName = ?2")
List<SchoolMember> findByNameAndSurname(String name, String surName);

@Query("SELECT m FROM SchoolMember m WHERE m.name = ?1")
List<SchoolMember> findByName(String name);

@Query("SELECT m FROM SchoolMember m WHERE m.name = ?1")
List<SchoolMember> findBySurname(String surName);

@Query("SELECT m FROM SchoolMember m WHERE TYPE(m.class) = Teacher")
List<SchoolMember> findAllTeachers();

@Query("SELECT m FROM SchoolMember m WHERE TYPE(m.class) = Student")
List<SchoolMember>  findAllStudents();

@Query("SELECT m FROM SchoolMember m WHERE m.id = ?1")
SchoolMember findSchoolMemberById(Integer id);

@Query("SELECT m FROM SchoolMember m WHERE TYPE(m.class) = Student AND m.grade >= ?1")
List<SchoolMember> findAllHigherThanThreshold(double grade);

@Query("SELECT m FROM SchoolMember m WHERE TYPE(m.class) = Student AND m.grade <= ?1")
List<SchoolMember> findAllLowerThanThreshold(double grade);

@Query("SELECT m FROM SchoolMember m WHERE m.grade = (SELECT MAX(m.grade) FROM SchoolMember m)")
List<SchoolMember> findTheBestStudent();

@Query("INSERT INTO SchoolMember (id, name, surName, age) VALUES (?1, ?2, ?3, ?4)")
SchoolMember addNewMemberWithQuery(Integer id, String name, String surName, int age);

}


