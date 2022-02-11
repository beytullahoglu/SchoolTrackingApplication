package SchoolTrackingApp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;
import java.text.SimpleDateFormat;

@Entity
public class SchoolMember {

    private @GeneratedValue @Id Integer id;
    private String name;
    private String surName;
    private int age;
    @Schema(hidden = true)
    protected String createdAt;
    @Schema(hidden = true)
    protected String updatedAt;

    SchoolMember(){
        this.createdAt = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        this.updatedAt = this.createdAt;
    }

    SchoolMember(SchoolMember member){
        this.createdAt = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        this.updatedAt = this.createdAt;
    }

    SchoolMember(Student s, Integer id, String name, String surName, int age){
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.createdAt = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        this.updatedAt = this.createdAt;
    }

    SchoolMember(Integer id){
        this.id = id;
        this.createdAt = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        this.updatedAt = this.createdAt;
    }
    
    SchoolMember(Integer id, String name, String surName){
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.createdAt = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        this.updatedAt = this.createdAt;
    }

    SchoolMember(Integer id, String name, String surName, int age){
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.createdAt = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        this.updatedAt = this.createdAt;
    }    

    public Integer getId() {return this.id;}

    public String getName() {return this.name;}

    public String getSurName() {return surName;}

    public int getAge() {return this.age;}

    public String getCreatedAt() {return this.createdAt;}

    public String getUpdatedAt() {return this.updatedAt;}

    public void setId(Integer id) {
        this.id = id;
        this.updatedAt = new SimpleDateFormat("yyy.MM.dd.HH.mm.ss").format(new Date());
    }

    public void setName(String name) {
        this.name = name;
        this.updatedAt = new SimpleDateFormat("yyy.MM.dd.HH.mm.ss").format(new Date());
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setAge(int age) {
        this.age = age;
        this.updatedAt = new SimpleDateFormat("yyy.MM.dd.HH.mm.ss").format(new Date());
    }

}
