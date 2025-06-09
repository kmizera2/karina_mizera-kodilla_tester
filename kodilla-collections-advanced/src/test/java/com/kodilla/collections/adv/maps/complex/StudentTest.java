package com.kodilla.collections.adv.maps.complex;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void shouldReturnCorrectFirstnameAndLastname() {
        // given
        Student student = new Student("Anna", "Nowak");

        // then
        assertEquals("Anna", student.getFirstname());
        assertEquals("Nowak", student.getLastname());
    }

    @Test
    void shouldBeEqualWhenFieldsAreSame() {
        // given
        Student student1 = new Student("Jan", "Kowalski");
        Student student2 = new Student("Jan", "Kowalski");

        // then
        assertEquals(student1, student2);
        assertEquals(student1.hashCode(), student2.hashCode());
    }

    @Test
    void shouldNotBeEqualWhenFirstnameDiffers() {
        // given
        Student student1 = new Student("Jan", "Kowalski");
        Student student2 = new Student("Adam", "Kowalski");

        // then
        assertNotEquals(student1, student2);
    }

    @Test
    void shouldNotBeEqualWhenLastnameDiffers() {
        // given
        Student student1 = new Student("Jan", "Kowalski");
        Student student2 = new Student("Jan", "Nowak");

        // then
        assertNotEquals(student1, student2);
    }

    @Test
    void shouldReturnProperToString() {
        // given
        Student student = new Student("Ewa", "Wiśniewska");

        // when
        String result = student.toString();

        // then
        assertEquals("Student{firstname='Ewa', lastname='Wiśniewska'}", result);
    }
}