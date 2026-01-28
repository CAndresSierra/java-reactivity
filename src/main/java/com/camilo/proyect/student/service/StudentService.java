package com.camilo.proyect.student.service;

import com.camilo.proyect.student.model.Student;
import io.reactivex.rxjava3.core.Observable;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private final List<Student> students = new ArrayList<>();

    public void subscribeTo(Observable<Student> stream){
        stream.subscribe(
                stu -> {
                    System.out.println("Adding student.... " + stu);
                    this.students.add(stu);
                },
                error -> System.out.println("Error on the stream: " + error.getMessage()),
                () -> {
                    System.out.println("Completed stream. Students charged");
                    this.students
                            .forEach((stu) -> {
                                System.out.println("Name: " + stu.getName());
                                System.out.println("Age: " + stu.getAge());
                            });
                    this.showStats();
                }
        );
    }

    private void showStats() {
        System.out.println("Stats");
        System.out.println("Total: " + students.size());
        System.out.println(" ");
        if(!students.isEmpty()){
              double ageAverage = this.students.stream()
                   .mapToInt(Student::getAge)
                   .average()
                   .orElse(0);
              System.out.println("Age Average: " + Math.round(ageAverage));
        }
    }

    public Observable<Student> verifyStudent(Student student) {
        return Observable.create(emitter -> {
            System.out.println("Veryfing..... " + student.getName());
            Thread.sleep(1000);

            if(student.getAge() >= 18){
               emitter.onNext(student);
            } else {
                System.out.println("The student is a minor... " + student.getName());
            }

            emitter.onComplete();
        });
    }

    public Observable<Student> validateStudentName(Student student){
        return Observable.create(emitter -> {
            System.out.println("Verifing name... ");
            Thread.sleep(1000);

            if(student.getName().length() < 3){
                emitter.onError(new IllegalArgumentException("The student name is invalid"));
            } else {
               emitter.onNext(student);
            }

            emitter.onComplete();
        });
    }
}