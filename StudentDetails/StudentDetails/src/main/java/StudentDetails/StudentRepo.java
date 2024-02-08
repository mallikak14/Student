package StudentDetails;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
@Component
public class StudentRepo {
    @Autowired
    NamedParameterJdbcTemplate jdbc;
   
    public void register(Student register)
    {
     String sql="INSERT INTO Student (rollno,studentname, classname, age, marks) values(:rollno,:studentname,:classname,:age,:marks)";
     MapSqlParameterSource namedparameter=new MapSqlParameterSource("rollno", register.getRollno())
     .addValue("studentname",register.getStudentname())
     .addValue("classname", register.getClassname())
    .addValue("age", register.getAge())
     .addValue("marks", register.getMarks());
     int result = jdbc.update(sql,namedparameter);
        if (result>0) {
            System.out.println("student registerd");
        }
    }

   public void update(String studentname,int rollno)
   {
    String sql="update student set studentname=:studentname where rollno=:rollno";
    MapSqlParameterSource namedparameter=new MapSqlParameterSource("rollno",rollno).addValue("studentname", studentname);
    int update=jdbc.update(sql, namedparameter);
    if(update>0)
    {
        System.out.println("row updated");
    }
   }

   public  List<Student> getAllDetails()
   {
    String sql="select * from  student";
    List<Student> studentdata=jdbc.query(sql,BeanPropertyRowMapper.newInstance(Student.class));
       return studentdata;
   }

   public  List<Student> getByRollno(int rollno)
   {
    String sql="select * from  student where rollno=:rollno";
    MapSqlParameterSource namedparameter=new MapSqlParameterSource("rollno",rollno);
    List<Student> studentdata=jdbc.query(sql,namedparameter,BeanPropertyRowMapper.newInstance(Student.class));
       return studentdata;
   }
    
   public void delete(int rollno)
   {
       String deletequery="delete from student where rollno=:rollno";
       MapSqlParameterSource namedparameter=new MapSqlParameterSource("rollno",rollno);
       int deleterow=jdbc.update(deletequery,namedparameter);
       if(deleterow>0)
       {
           System.out.println("row deleted");
       }
   }

   public  List<Student> getByClassname(String classname)
   {
    String sql="select * from  student where classname=:classname";
    MapSqlParameterSource namedparameter=new MapSqlParameterSource("classname",classname);
    List<Student> studentdata=jdbc.query(sql,namedparameter,BeanPropertyRowMapper.newInstance(Student.class));
       return studentdata;
   }

   public List<Student> getDetailsByAge(int min,int max)
   {
       String sql="select * from student where age between :min and :max";
       MapSqlParameterSource namedparameter=new MapSqlParameterSource("min",min).addValue("max", max);
       List<Student> studentdata=jdbc.query(sql,namedparameter,BeanPropertyRowMapper.newInstance(Student.class));
       return studentdata;
   }

   public List<Student> getDetailsbyavg()
   {
        String sql="select * from student where marks>(select avg(marks) from student)";
        List<Student> studentdata=jdbc.query(sql,BeanPropertyRowMapper.newInstance(Student.class));
        return studentdata;
   }



}
