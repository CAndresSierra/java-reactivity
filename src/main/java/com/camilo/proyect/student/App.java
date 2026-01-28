package com.camilo.proyect.student;

import com.camilo.proyect.student.model.Student;
import com.camilo.proyect.student.stream.StudentStream;

public class App {
    public static void main(String[] args) {
        StudentStream stream = new StudentStream();

        stream.getStream().subscribe(
                item -> System.out.println(item),
                error -> System.out.println(error.getMessage()),
                () -> System.out.println("Finished")
        );

        stream.publish(new Student("Camilo", 19));
        stream.publish(new Student("Ancizar", 33));

        stream.complete();

    }
}
