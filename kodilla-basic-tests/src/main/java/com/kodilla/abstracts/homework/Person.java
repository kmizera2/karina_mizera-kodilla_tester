package com.kodilla.abstracts.homework;

public class Person {
    public String firstName;
    public int age;
    public Job job;

    public void displayPersonResponsibilities(){
        System.out.println(firstName+" age: "+age+" responsibilities:" +job.responsibilities );
    }
}
