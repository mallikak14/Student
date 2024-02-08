package StudentDetails;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class TestStudent implements CommandLineRunner {
    Scanner sc=new Scanner(System.in);
    @Autowired
    JdbcTemplate jdbc;
    //1
    void register()
    {
        String data = "INSERT INTO Student (rollno, studentname, class, age, marks) VALUES (?, ?, ?,?,?)";
        int result = jdbc.update(data, "56kL", "elena", "tenth",16,70); 
        if (result>0) {
            System.out.println("student registerd");
        }
    }
    //2
    void update()
    {
        String query="update student set studentname=? where rollno=?";
        //Object[] newdata={"micheal","18AB9"};
        String name_of_student=sc.next();
        String rollno_of_student=sc.next();
        int updateddata=jdbc.update(query,name_of_student,rollno_of_student);
        if(updateddata>0)
        {
            System.out.println("data updated");
        }
    }
    //3
    void listofallstudents()
    {
        var datalist=jdbc.queryForList("select * from student");
        for(var show: datalist)
        {
            System.out.printf("%5s %15s %5s %5d %5d \n",show.get("rollno"),show.get("studentname"),show.get("class"),
            show.get("age"),show.get("marks"));
        }
    }
    //4
    void listbyrollno()
    {
        var display="select * from student where rollno=?";
        String enter_rollno=sc.next();
        var detailsbyrollno= jdbc.queryForList(display,enter_rollno);
        for(var show: detailsbyrollno)
        {
            System.out.printf("%5s %15s %5s %5d %5d\n",show.get("rollno"),show.get("studentname"),show.get("class"),
            show.get("age"),show.get("marks"));
        }
    }
    //5
    void delete()
    {
        String deletequery="delete from student where rollno=?";
        System.out.println("enter rollno to be deleted"); 
        String rollno=sc.next();
        int deleterow=jdbc.update(deletequery, rollno);
        if(deleterow>0)
        {
            System.out.println("row deleted");
        }
    }
    //6
    void listbyclass()
    {
        var displaybyclass="select * from student where class=?";
        String enter_classname=sc.next();
        var detailsbyclass= jdbc.queryForList(displaybyclass,enter_classname);
        for(var show: detailsbyclass)
        {
            System.out.printf("%5s %15s %5s %5d %5d\n",show.get("rollno"),show.get("studentname"),show.get("class"),
            show.get("age"),show.get("marks"));
        }
    }
    //7
    void listbyagegroup()
    {
        var displaybyage="select * from student where age between ? and ?";
        //Object[] rangeofage={11,15};
        int min=sc.nextInt();
        int max=sc.nextInt();
        var detailsbyage= jdbc.queryForList(displaybyage,min,max);
        for(var show: detailsbyage)
        {
            System.out.printf("%5s %15s %5s %5d %5d\n",show.get("rollno"),show.get("studentname"),show.get("class"),
            show.get("age"),show.get("marks"));
        }
    }
    //8
    void listmorethanavg()
    {
        var displaybyavg="select * from student where marks>(select avg(marks) from student)";
        var detailsaboveavg=jdbc.queryForList(displaybyavg);
        for(var show: detailsaboveavg)
        {
            System.out.printf("%5s %15s %5s %5d %5d\n",show.get("rollno"),show.get("studentname"),show.get("class"),
            show.get("age"),show.get("marks"));
        }
    }

    @Override
    public void run(String... args) throws Exception {
        //register();
        //update();
        //listofallstudents();
        //listbyrollno();
        //listbyclass();
        //listbyagegroup();
        //delete();
        //listmorethanavg();


        
       
        

        
       
        
    }
}
