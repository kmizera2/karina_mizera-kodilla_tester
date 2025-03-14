package optional.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Application {
    public static void main(String[] args) {


        Teacher teacher1=new Teacher("Mike Kowalski");
        Teacher teacher2=new Teacher("Maria Kanarska");
        Teacher teacher3=new Teacher("Leo Zen");

        List <Student> students =new ArrayList<>();
        students.add(new Student("James Blunt", teacher1));
        students.add(new Student("Rod Stewart", null));
        students.add(new Student("Leonard Cohen", teacher2));
        students.add(new Student("Duncan Laurence", teacher1));
        students.add(new Student("Dean Lewis", null));
        students.add(new Student("Shawn Mendes", teacher3));


        for (Student student : students)
        {
            Optional<Teacher> optionalTeacher = Optional.ofNullable(student.getTeacher());
            String teacherName =optionalTeacher.orElse(new Teacher("<undefined>")).getName();
            System.out.println("Uczeń: " + student.getName() + ", Nauczyciel: " +  teacherName);
        }
    }
}
