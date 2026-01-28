package com.camilo.proyect.student.controller;

import com.camilo.proyect.student.model.Student;
import com.camilo.proyect.student.service.StudentService;
import com.camilo.proyect.student.stream.StudentStream;
import io.reactivex.rxjava3.core.Observable;

public class StudentController {
    private final StudentStream stream;
    private final StudentService service;

    public StudentController(StudentStream stream, StudentService service) {
        this.stream = stream;
        this.service = service;
        this.service.subscribeTo(
                stream.getStream()
                        .flatMap(service::verifyStudent)
                        .flatMap(stu -> service.validateStudentName(stu)
                                .onErrorResumeNext(throwable -> {
                                    System.out.println("Error: " + throwable.getMessage());
                                    return Observable.empty();
                                })
                        )
        );

    }

    public boolean processInput(String name, String ageInput){
        try {
            int age = Integer.parseInt(ageInput);
            stream.publish(new Student(name, age));
            return true;
        } catch (NumberFormatException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void finishInput(){
        stream.complete();
    }
}
