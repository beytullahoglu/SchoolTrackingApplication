package SchoolTrackingApp;

public class MemberWithThisIdAlreadyExists extends RuntimeException {

    MemberWithThisIdAlreadyExists(Integer id){
        super("Member with Id: " + id + " already exists!");
    }
    
}
