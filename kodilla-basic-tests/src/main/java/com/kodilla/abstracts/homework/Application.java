package com.kodilla.abstracts.homework;

public class Application {
    public static void main(String[] args) {

        Circle circle = new Circle();
        circle.r = 5;
        System.out.println("This circle area is: " + circle.area());
        System.out.println("This circle perimeter is: " + circle.perimeter());

        Square square = new Square();
        square.side = 9;
        System.out.println("This square area is: " + square.area());
        System.out.println("This square perimeter is: " + square.perimeter());

        Job mathTeacher = new Teacher();
        mathTeacher.responsibilities = "Teaching math, giving grades, talking to parents of students";

        Person person1 = new Person();
        person1.age = 40;
        person1.firstName = "Anna";
        person1.job = mathTeacher;
        person1.displayPersonResponsibilities();

        Teacher physicalEducationTeacher = new Teacher();
        physicalEducationTeacher.responsibilities = "Giving exercises to do, first aid, giving grades, talking to parents of students";

        Person person2 = new Person();
        person2.age = 37;
        person2.firstName = "Adam";
        person2.job = physicalEducationTeacher;
        person2.displayPersonResponsibilities();
    }
}
