package StudentDetails;

public class Student {
    int rollno;
    String studentname;
    String classname;
    @Override
    public String toString() {
        return "Student [rollno=" + rollno + ", studentname=" + studentname + ", classname=" + classname + ", age="
                + age + ", marks=" + marks + "]";
    }
    int age;
    int marks;
    public int getRollno() {
        return rollno;
    }
    public void setRollno(int rollno) {
        this.rollno = rollno;
    }
    public String getStudentname() {
        return studentname;
    }
    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }
    public String getClassname() {
        return classname;
    }
    public void setClassname(String classname) {
        this.classname = classname;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getMarks() {
        return marks;
    }
    public void setMarks(int marks) {
        this.marks = marks;
    }
    
   

    
}
