package StudentDetails;

import java.util.List;
//import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class StudentService {
    @Autowired
    StudentRepo sr;
  public  List<Student> getAllDetails()
    {
        return sr.getAllDetails();
    }
    public void register(Student register)
    {
        sr.register(register);
    }
    public  List<Student> getByRollno(int rollno)
    {
        return sr.getByRollno(rollno);
    }
    public void delete(int rollno)
    {
        sr.delete(rollno);
    }
    public void update(String studentname,int rollno)
    {
        sr.update(studentname, rollno);
    }
    public  List<Student> getByClassname(String classname)
    {
        return sr.getByClassname(classname);
    }
    public  List<Student> getDetailsByAge(int min,int max)
    {
        return sr.getDetailsByAge(min,max);
    }
    public  List<Student> getDetailsbyavg()
    {
        return sr.getDetailsbyavg();
    }
}
