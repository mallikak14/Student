package StudentDetails;

import java.util.List;

public interface StudentInterface {
    void register(Student reg);
    List<Student> getAllDetails();
    void update(String studentname,int rollno);
    List<Student> getByRollno(int rollno);
    void delete(int rollno);
    List<Student> getByClassname(String classname);
    List<Student> getDetailsByAge(int min,int max);
    List<Student> getDetailsbyavg();

    
}
