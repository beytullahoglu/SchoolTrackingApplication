package SchoolTrackingApp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchoolTrackingController {

    private final SchoolRepository schoolRepository;

    SchoolTrackingController(SchoolRepository schoolRepository){
        this.schoolRepository = schoolRepository;

    }

    @GetMapping("/schoolMembers/getAll")
    List<SchoolMember> findAll(){
        List<SchoolMember> members = schoolRepository.findAll().stream().collect(Collectors.toList());
        return members;
    }
    @GetMapping("/schoolMembers/students/getAll")
    List<SchoolMember> findAllStudents(){
        return schoolRepository.findAllStudents();
    }

    @GetMapping("/schoolMembers/teachers/getAll")
    List<SchoolMember> findAllTeachers(){
        return schoolRepository.findAllTeachers();
    }

    @GetMapping("/schoolMembers/findByNameAndSurname")
    List<SchoolMember> findByNameAndSurname(String name, String surName){
        return schoolRepository.findByNameAndSurname(name, surName);
    }

    @GetMapping("/schoolMembers/findByName")
    List<SchoolMember> findByName(String name){
        return schoolRepository.findByName(name);
    }

    @GetMapping("/schoolMembers/findBySurname")
    List<SchoolMember> findBySurname(String surName){
        return schoolRepository.findBySurname(surName);
    }
    
    @GetMapping("schoolMembers/findById/{Id}")
    SchoolMember findSchoolMemberById(Integer id){
        return schoolRepository.findSchoolMemberById(id);
    }

    @GetMapping("schoolMembers/students/findAllHigherThanThreshold")
    List<SchoolMember> findAllHigherThanThreshold(double grade){
        return schoolRepository.findAllHigherThanThreshold(grade);
    }

    @GetMapping("schoolMembers/students/findAllLowerThanThreshold")
    List<SchoolMember> findAllLowerThanThreshold(double grade){
        return schoolRepository.findAllLowerThanThreshold(grade);
    }

    @GetMapping("schoolMembers/students/findBest")
    List<SchoolMember> findTheBest(){
        return schoolRepository.findTheBestStudent();
    }   
    
    @PostMapping("/schoolMembers/newEntry")
    SchoolMember member(@RequestBody SchoolMember member){
        return schoolRepository.save(member);
    }

    @PutMapping("schoolMembers/newMember")
    void newMember(Integer id, String name, String surName, int age){
        schoolRepository.addNewMemberWithQuery(id, name, surName, age);
    }

    @PutMapping("schoolMembers/addNewStudent")
    Student addNewStudent(Integer id, String name, String surName, int age, int studentNumber, double grade) throws MemberWithThisIdAlreadyExists{
        if (schoolRepository.findSchoolMemberById(id) != null){
            throw new MemberWithThisIdAlreadyExists(id);
        }
        else{
            Student s = new Student(id, name, surName, age, studentNumber, grade);
            return schoolRepository.save(s);
        }   
    }    

    @PutMapping("/schoolMembers/{id}")
    SchoolMember replaceMember(@PathVariable Integer id, String name, String surName, int age){

        return schoolRepository.findById(id)
        .map(member -> {
            member.setName(name);
            member.setAge(age);
            return schoolRepository.save(member);
        })
        .orElseGet(() -> {
            SchoolMember newMember = new SchoolMember(id, name, surName, age); 
            return schoolRepository.save(newMember);
        });
    }

    @DeleteMapping("/schoolMembers/delete/{id}")
    void deleteMember(@PathVariable Integer id){
        schoolRepository.deleteById(id);
    }
}
