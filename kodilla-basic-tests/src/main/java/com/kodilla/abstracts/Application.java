package com.kodilla.abstracts;

public class Application {

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.giveVoice();

        Animal dog2= new Dog();
        dog2.giveVoice();

        Duck duck = new Duck();
        duck.giveVoice();


        Animal dog3 = new Dog();
        AnimalProcessor processor = new AnimalProcessor();
        processor.process(dog3);

        Animal dog4 = new Dog();
        AnimalProcessor processor1 = new AnimalProcessor();
        processor1.process(dog3);

    }
}
