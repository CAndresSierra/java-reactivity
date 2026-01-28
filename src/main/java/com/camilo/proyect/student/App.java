package com.camilo.proyect.student;

import com.camilo.proyect.student.controller.StudentController;
import com.camilo.proyect.student.service.StudentService;
import com.camilo.proyect.student.stream.StudentStream;
import com.camilo.proyect.student.view.StudentConsoleView;

public class App {
    public static void main(String[] args) {
        //        stream.getStream().subscribe(
//                item -> System.out.println(item),
//                error -> System.out.println(error.getMessage()),
//                () -> System.out.println("Finished")
//        );
//
//        stream.publish(new Student("Camilo", 19));
//        stream.publish(new Student("Ancizar", 33));
//
//        stream.complete();

        StudentStream stream = new StudentStream();
        StudentService studentService = new StudentService();
        StudentController studentController = new StudentController(stream, studentService);
        StudentConsoleView view = new StudentConsoleView(studentController);

        view.start();

    }
}
