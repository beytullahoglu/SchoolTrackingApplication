package SchoolTrackingApp;

import javax.persistence.Entity;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
class Teacher extends SchoolMember {

    private String classes;

    Teacher(){super();}

    Teacher(Integer id, String name, String surName, int age, String classes){
        super(id, name, surName, age);
        this.classes = classes;
    }

    Teacher(Integer id, String name, String surName, int age){
        super(id, name, surName, age);
    }

    Teacher(Integer id, String name, String surName){
        super(id, name, surName);
    }

    Teacher(Integer id){
        super(id);
    }

    Teacher(SchoolMember member, String classes){
        super(member);
        this.classes = classes;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
        this.updatedAt = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    }    
}
