package optional.homework;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    @Test
    void testStudentTeacherAssociation() {
        Teacher teacher1 = new Teacher("Mike Kowalski");
        Teacher teacher2 = new Teacher("Maria Kanarska");
        Teacher teacher3 = new Teacher("Leo Zen");

        List<Student> students = new ArrayList<>();
        students.add(new Student("James Blunt", teacher1));
        students.add(new Student("Rod Stewart", null));
        students.add(new Student("Leonard Cohen", teacher2));
        students.add(new Student("Duncan Laurence", teacher1));
        students.add(new Student("Dean Lewis", null));
        students.add(new Student("Shawn Mendes", teacher3));

        for (Student student : students) {
            Optional<Teacher> optionalTeacher = Optional.ofNullable(student.getTeacher());
            String teacherName = optionalTeacher.orElse(new Teacher("<undefined>")).getName();
            assertNotNull(teacherName);
        }
    }

    @Test
    void testStudentWithoutTeacher() {
        Student student = new Student("Rod Stewart", null);
        Optional<Teacher> optionalTeacher = Optional.ofNullable(student.getTeacher());
        String teacherName = optionalTeacher.orElse(new Teacher("<undefined>")).getName();
        assertEquals("<undefined>", teacherName);
    }

    @Test
    void testStudentWithTeacher() {
        Teacher teacher = new Teacher("Anna Nowak");
        Student student = new Student("Rod Stewart", teacher);
        Optional<Teacher> optionalTeacher = Optional.ofNullable(student.getTeacher());
        String teacherName = optionalTeacher.orElse(new Teacher("<undefined>")).getName();
        assertEquals("Anna Nowak", teacherName);
    }

}