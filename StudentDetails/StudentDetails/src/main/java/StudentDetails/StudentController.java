package StudentDetails;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired
     StudentService ss;
    @GetMapping("/getalldetails")
    public List<Student> getAllDetails()
    {
        return ss.getAllDetails();
    }

    @PostMapping("/register")
    public void register(@RequestBody Student reg)
    {
        ss.register(reg);
    }
    @GetMapping("/getdetailsbyrollno/{rollNo}")
    public List<Student> getDetailsByRollNo(@PathVariable("rollNo") int rollNo) {
        return ss.getByRollno(rollNo);
    }

    @DeleteMapping("/deletestudent/{rollno}")
        public void deleteStudent(@PathVariable("rollno") int rollno)
        {
            ss.delete(rollno);
        }

    @PutMapping("/update/{studentname}/{rollno}")
    public void update(@PathVariable("studentname") String studentname,@PathVariable("rollno") int rollno)
    {
        ss.update(studentname, rollno);
    }

    @GetMapping("/byclassname/{classname}")
    public List<Student> getAllDetailsbyclassname(@PathVariable("classname") String classname)
    {
        return ss.getByClassname(classname);
    }

    @GetMapping("/byrangeofage/{min}/{max}")
        public List<Student> getDetailsByAge(@PathVariable("min") int min,@PathVariable("max") int max)
        {
           return ss.getDetailsByAge(min,max);
        }
    
    @GetMapping("/morethanavg")
    public List<Student> getByAvg()
    {
       return ss.getDetailsbyavg();
    }
}
