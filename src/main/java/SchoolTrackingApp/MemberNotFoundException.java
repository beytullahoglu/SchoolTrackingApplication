package SchoolTrackingApp;

public class MemberNotFoundException extends RuntimeException {
    
    MemberNotFoundException(Integer id){
        super("Could not find student " + id);
    }
}
